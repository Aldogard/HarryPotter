import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormControl } from '@angular/forms';
import { BehaviorSubject } from 'rxjs';
import { ExtraService } from '../extra.service';
import { HpMagicalBeing } from '../hp-magical-being';
import { HpSpell } from '../hp-spell';
import { MagicalBeingService } from '../magical-being.service';
import { MessageService } from '../message.service';
import { WizardService } from '../wizard.service';

@Component({
  selector: 'app-training',
  templateUrl: './training.component.html',
  styleUrls: ['./training.component.css'],
})
export class TrainingComponent implements OnInit {
  show: boolean = true;
  dummy?: HpMagicalBeing;
  magicalBeing1?: HpMagicalBeing;
  chosenOption: string = '';
  validateSpell = new BehaviorSubject<boolean>(false);
  spell = new FormControl('');
  showStart = new BehaviorSubject<boolean>(true);
  remainingSpells = 0;
  amountOfSpells = -1;
  showTable = new BehaviorSubject<boolean>(true);
  showDetails = new BehaviorSubject<boolean>(false);
  showSucces = new BehaviorSubject<boolean>(false);
  showFailure = new BehaviorSubject<boolean>(false);
  trainingVictories = 0;

  magicalBeingForm = this.fb.group({
    name: new FormControl('Dummy'),
    healthPoints: new FormControl(25),
    description: new FormControl('Test dummy for pratice'),
  });

  constructor(
    private mbService: MagicalBeingService,
    private extraService: ExtraService,
    private fb: FormBuilder,
    private ws: WizardService,
    private ms: MessageService
  ) {}

  ngOnInit(): void {
    this.beforeStart();
  }

  beforeStart() {
    this.ws
      .postWizard(this.magicalBeingForm.value, 'Alumni')
      .subscribe((post) => {
        this.mbService.getMagicalBeingByName('Dummy').subscribe((mb) => {
          this.dummy = mb;
        });
      });
    setTimeout(() => {
      this.mbService.deleteDummy().subscribe();
    }, 500);

    // this.magicalBeing1 = this.ms.participants.value[0];
    // this.show = this.ms.showTraining.value;

    this.mbService.getMagicalBeings().subscribe((mb) => {
      mb[0].energy = 15;
      this.magicalBeing1 = mb[0];
      this.getAmount();
    });
    this.show = true;
    this.remainingSpells = 0;
    this.amountOfSpells = 0;
    if (this.trainingVictories >= 3 && this.magicalBeing1 !== undefined) {
      this.showSucces.next(true);
      this.magicalBeing1.victories = this.magicalBeing1.victories + 1;
      if (this.magicalBeing1.victories < 100) {
        this.magicalBeing1.rank =
          this.extraService.ranking[
            Math.floor(this.magicalBeing1.victories / 5)
          ];

        this.mbService.updateVictories(this.magicalBeing1).subscribe((uv) => {
          this.trainingVictories = 0;
          this.chosenOption = '';
          this.spell = new FormControl('');
          this.showDetails.next(false);
          this.showSucces.next(true);
        });
      }
    }
  }

  showSpell() {
    this.chosenOption = 'spell';
  }

  showPotion() {
    this.chosenOption = 'potion';
  }

  getAmount() {
    if (this.magicalBeing1 !== undefined) {
      let startAmount = 7 - Math.floor(this.magicalBeing1.victories / 5);
      if (startAmount < 3) {
        startAmount = 3;
      }
      this.remainingSpells = startAmount - this.amountOfSpells;
      this.amountOfSpells = this.amountOfSpells + 1;
    }
  }

  getSpell(spell: HpSpell) {
    this.spell = new FormControl(spell);
    this.validateSpell.next(true);
    this.showSucces.next(false);
  }

  gotoAttackDetail(attackId: number) {
    this.ms.sendAttackId(attackId);
    const url = 'spelldetail/' + attackId;
    window.open(url);
  }

  executeAttack(
    attackMagicalBeing: HpMagicalBeing,
    defendMagicalBeing: HpMagicalBeing,
    defender: boolean
  ) {
    this.preparation(attackMagicalBeing);
    this.fiendfyreEffects(attackMagicalBeing);
    if (!attackMagicalBeing.conditions[1].condition) {
      attackMagicalBeing.energy =
        attackMagicalBeing.energy - this.spell.value.energyUsage;
      this.spellEffects(defendMagicalBeing, attackMagicalBeing);

      this.getDamage(
        attackMagicalBeing,
        defendMagicalBeing,
        this.spell.value.maxDamage,
        true
      );

      this.formattingStunnedAndConfunded(defendMagicalBeing);
      this.confunded(defendMagicalBeing);
      this.stunned(defendMagicalBeing);
    } else {
      alert(
        attackMagicalBeing.name +
          ' has been stunned and cannot attack this round!'
      );
    }
    this.getAmount();
    if (this.remainingSpells < 0) {
      this.showFailure.next(true);
      this.beforeStart();
    } else if (defendMagicalBeing.healthPoints < 0) {
      this.trainingVictories = this.trainingVictories + 1;
      this.chosenOption = '';
      this.spell = new FormControl('');
      this.showDetails.next(false);
      this.beforeStart();
    }
  }

  preparation(attackMagicalBeing: HpMagicalBeing) {
    this.showStart.next(false);
    attackMagicalBeing.energy = attackMagicalBeing.energy + 3;
  }

  fiendfyreEffects(attackMagicalBeing: HpMagicalBeing) {
    if (attackMagicalBeing.fiendfyre) {
      if (this.spell.value.name === 'Anti Fiendfyre') {
        attackMagicalBeing.fiendfyre = false;
      } else {
        attackMagicalBeing.healthPoints = -100;
      }
    }
  }

  spellEffects(
    defendMagicalBeing: HpMagicalBeing,
    attackMagicalBeing: HpMagicalBeing
  ) {
    if (this.spell.value.imperio && this.dummy !== undefined) {
      if (this.dummy?.additionalFactor < 1.5) {
        this.getDamage(
          defendMagicalBeing,
          attackMagicalBeing,
          defendMagicalBeing.spells[
            Math.floor(Math.random() * defendMagicalBeing.spells.length)
          ].maxDamage,
          true
        );
      } else {
        alert('Brain Elixir prevented Imperio');
      }
      this.confunded(defendMagicalBeing);
    }
  }

  getDamage(
    attackMagicalBeing: HpMagicalBeing,
    defendMagicalBeing: HpMagicalBeing,
    damageFromAction: number,
    spell: boolean
  ) {
    let randomFactor = Math.round(Math.random() * 100) / 100;
    if (spell) {
      randomFactor = randomFactor * attackMagicalBeing.additionalFactor;
      if (
        attackMagicalBeing.conditions[0].condition &&
        attackMagicalBeing.confundedProtection === 0
      ) {
        randomFactor = randomFactor / 2;
      }
      attackMagicalBeing.strengthAndWeaknesses.forEach((saw) => {
        if (saw.house === defendMagicalBeing.klasse && saw.strength) {
          console.log('Double');
          randomFactor = randomFactor * 2;
        } else if (saw.house === defendMagicalBeing.klasse && !saw.strength) {
          console.log('Half');
          randomFactor = randomFactor / 2;
        }
      });
    }
    const magicalBeingFactor = attackMagicalBeing.faktor;
    const maxDamage = damageFromAction;
    const damage =
      Math.round(randomFactor * magicalBeingFactor * maxDamage * 100) / 100;

    if (
      Math.random() > 0.5 &&
      defendMagicalBeing.protego &&
      !attackMagicalBeing.fiendfyre
    ) {
      attackMagicalBeing.healthPoints =
        Math.round((defendMagicalBeing.healthPoints - damage) * 100) / 100;
      alert(attackMagicalBeing.name + ' received ' + damage + ' damage');
    } else {
      defendMagicalBeing.healthPoints =
        Math.round((defendMagicalBeing.healthPoints - damage) * 100) / 100;
      alert(defendMagicalBeing.name + ' received ' + damage + ' damage');
    }
    return Math.round(damage * 100) / 100;
  }

  formattingStunnedAndConfunded(defendMagicalBeing: HpMagicalBeing) {
    defendMagicalBeing.conditions[0].condition = false;
    defendMagicalBeing.conditions[1].condition = false;
  }

  stunned(defendMagicalBeing: HpMagicalBeing) {
    if (Math.random() > 0.5 && this.spell.value.stunned) {
      if (defendMagicalBeing.stunnedProtection === 0) {
        defendMagicalBeing.conditions[1].condition = true;
        console.log('Stunned');
      } else {
        console.log('The stunning effect has been repelled');
      }
    }
  }

  confunded(defendMagicalBeing: HpMagicalBeing) {
    if (Math.random() > 0.5 && this.spell.value.confunded) {
      if (defendMagicalBeing.confundedProtection === 0) {
        defendMagicalBeing.conditions[0].condition = true;
        console.log('Confunded');
      } else {
        console.log('The confunded effect has been repelled');
      }
    }
  }

  strengthAndWeakness(
    magicalBeing1: HpMagicalBeing,
    magicalBeing2: HpMagicalBeing
  ) {
    let indicator;
    magicalBeing1.strengthAndWeaknesses.forEach((saw) => {
      if (saw.house === magicalBeing2.klasse && saw.strength) {
        indicator = true;
      } else if (saw.house === magicalBeing2.klasse && !saw.strength) {
        indicator = false;
      }
    });
    if (indicator === true) {
      return 'Strength';
    } else if (indicator === false) {
      return 'Weakness';
    } else {
      return 'None';
    }
  }

  showHideTable(status: boolean) {
    this.showTable.next(status);
    this.showDetails.next(true);
  }

  showHideDetails(status: boolean) {
    this.showDetails.next(status);
  }

  gotoSelection() {
    this.extraService.redirectTo('selection');
  }
}
