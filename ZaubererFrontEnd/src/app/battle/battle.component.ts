import { Component, OnInit } from '@angular/core';
import { FormControl } from '@angular/forms';
import { BehaviorSubject } from 'rxjs';
import { HarrypotterService } from '../harrypotter.service';
import { Hptype } from '../hptype';
import { MessageService } from '../message.service';
import { ExtraService } from '../extra.service';
import { HpSpell } from '../hp-spell';
import { HpPotion } from '../hp-potion';

@Component({
  selector: 'app-battle',
  templateUrl: './battle.component.html',
  styleUrls: ['./battle.component.css'],
})
export class BattleComponent implements OnInit {
  wizardsArray: Hptype[] = [];
  wizard1?: Hptype;
  wizard2?: Hptype;
  options = this.extraService.options;
  chosenOption: string = '';
  validateSpell = new BehaviorSubject<boolean>(false);
  validatePotion = new BehaviorSubject<boolean>(false);
  spell = new FormControl('');
  potion = new FormControl('');
  attackWizard1 = new BehaviorSubject<boolean>(false);
  attackWizard2 = new BehaviorSubject<boolean>(true);
  showResult = new BehaviorSubject<boolean>(false);
  showStart = new BehaviorSubject<boolean>(true);
  attackWizardNumber: number = 1;
  voldemortIsDead: boolean = false;
  environment: string = '';

  constructor(
    private hpService: HarrypotterService,
    private extraService: ExtraService,
    private ms: MessageService
  ) {}

  ngOnInit(): void {
    this.environment =
      this.extraService.environment[
        Math.floor(Math.random() * this.extraService.environment.length)
      ];
    this.ms.zaubererArray.subscribe((za) => {
      this.wizardsArray = za;
      this.wizard1 = za[0];
      this.wizard2 = za[1];
    });
    this.determineStarter();
  }

  determineStarter() {
    if (Math.random() > 0.5) {
      this.attackWizard1.next(true);
      this.attackWizard2.next(false);
    }
  }

  getPotion(potion: HpPotion) {
    this.potion = new FormControl(potion);
    if (this.potion.value.name === 'Unicorn Blood') {
      alert(
        'It is a monstrous thing, to slay a unicorn. Only one who has nothing to lose, and everything to gain, would commit such a crime. The blood of a unicorn will keep you alive, even if you are an inch from death, but at a terrible price. You have slain something so pure and defenceless to save yourself and you will have but a half life, a cursed life, from the moment the blood touches your lips.'
      );
    }
    this.validatePotion.next(true);
  }

  getSpell(spell: HpSpell) {
    this.spell = new FormControl(spell);
    this.validateSpell.next(true);
  }

  executeAttack(attackWizard: Hptype, defendWizard: Hptype, defender: boolean) {
    this.showStart.next(false);
    attackWizard.energy = attackWizard.energy + 3;
    this.fiendfyreEffects(attackWizard);
    if (!attackWizard.conditions[1].condition) {
      attackWizard.energy = attackWizard.energy - this.spell.value.energyUsage;
      this.spellEffects(defendWizard, attackWizard);

      this.getDamage(
        attackWizard,
        defendWizard,
        this.spell.value.maxDamage,
        true
      );

      this.formattingStunnedAndConfunded(defendWizard);
      this.confunded(defendWizard);
      this.stunned(defendWizard);
    } else {
      alert(
        attackWizard.name + ' has been stunned and cannot attack this round!'
      );
    }

    attackWizard.energy = Math.round(attackWizard.energy);
    this.resetAFandProtego(attackWizard, defendWizard);
    this.reduceProtection(defendWizard);
    this.halfLifeEffects(attackWizard);
    this.nextRound(defendWizard, defender, attackWizard);

    if (this.spell.value.fiendfyre) {
      attackWizard.fiendfyre = true;
    }
    if (this.spell.value.name === 'Piertotum Locomotor') {
      attackWizard.ptCounter++;
    }
    this.formattingOfKeyVariables();
  }

  executePotion(attackWizard: Hptype, defendWizard: Hptype, defender: boolean) {
    let damage = 0;
    this.showStart.next(false);
    attackWizard.energy = attackWizard.energy + 3;
    this.fiendfyreEffects(attackWizard);
    if (!attackWizard.conditions[1].condition) {
      this.potionEffects(attackWizard, defender);

      damage = this.getDamage(
        attackWizard,
        defendWizard,
        this.potion.value.maxDamage,
        false
      );

      this.formattingStunnedAndConfunded(defendWizard);
    } else {
      alert(
        attackWizard.name +
          ' has been stunned and cannot use a Potion this round!'
      );
    }

    attackWizard.energy = Math.round(attackWizard.energy);
    this.reduceProtection(defendWizard);
    this.nextRound(defendWizard, defender, attackWizard);
    this.formattingOfKeyVariables();
  }

  nextRound(defendWizard: Hptype, defender: boolean, attackWizard: Hptype) {
    this.voldemortIsDead = this.checkIfDead();

    if (
      ((defendWizard.healthPoints <= 0 && !defendWizard.halfLife) ||
        (attackWizard.healthPoints <= 0 && !attackWizard.halfLife)) &&
      (!defender ||
        defendWizard === this.wizardsArray[this.wizardsArray.length - 1])
    ) {
      this.victoryFormation();
      this.updateVictories();
    } else if (
      ((defendWizard.healthPoints <= -100 && defendWizard.halfLife) ||
        (attackWizard.healthPoints <= -100 && attackWizard.halfLife)) &&
      (!defender ||
        defendWizard === this.wizardsArray[this.wizardsArray.length - 1])
    ) {
      this.victoryFormation();
      this.updateVictories();
    } else if (
      ((defendWizard.healthPoints <= 0 && !defendWizard.halfLife) ||
        (attackWizard.healthPoints <= 0 && !attackWizard.halfLife)) &&
      defendWizard !== this.wizardsArray[this.wizardsArray.length - 1]
    ) {
      this.attackWizardNumber++;
      this.wizard2 = this.wizardsArray[this.attackWizardNumber];
      this.gotoNextRound(defendWizard);
    } else if (
      ((defendWizard.healthPoints <= -100 && defendWizard.halfLife) ||
        (attackWizard.healthPoints <= -100 && attackWizard.halfLife)) &&
      defendWizard !== this.wizardsArray[this.wizardsArray.length - 1]
    ) {
      this.attackWizardNumber++;
      this.wizard2 = this.wizardsArray[this.attackWizardNumber];
      this.gotoNextRound(defendWizard);
    } else {
      this.attackWizard2.next(!this.attackWizard2.value);
      this.attackWizard1.next(!this.attackWizard1.value);
    }
  }

  formattingOfKeyVariables() {
    this.spell = new FormControl('');
    this.potion = new FormControl('');
    this.validateSpell.next(false);
    this.validatePotion.next(false);
    this.chosenOption = '';
  }

  getDamage(
    attackWizard: Hptype,
    defendWizard: Hptype,
    damageFromAction: number,
    spell: boolean
  ) {
    let randomFactor = Math.round(Math.random() * 100) / 100;
    if (
      attackWizard.conditions[0].condition &&
      spell &&
      attackWizard.confundedProtection === 0
    ) {
      randomFactor = randomFactor / 2;
    }
    if (spell) {
      randomFactor = randomFactor * attackWizard.additionalFactor;
    }
    const wizardFactor = attackWizard.faktor;
    const maxDamage = damageFromAction;
    const damage =
      Math.round(randomFactor * wizardFactor * maxDamage * 100) / 100;

    if (
      Math.random() > 0.5 &&
      defendWizard.protego &&
      !attackWizard.fiendfyre 
    ) {
      attackWizard.healthPoints =
        Math.round((defendWizard.healthPoints - damage) * 100) / 100;
      alert(attackWizard.name + ' received ' + damage + ' damage');
    } else {
      defendWizard.healthPoints =
        Math.round((defendWizard.healthPoints - damage) * 100) / 100;
      alert(defendWizard.name + ' received ' + damage + ' damage');
    }
    return Math.round(damage * 100) / 100;
  }

  potionEffects(attackWizard: Hptype, defender: boolean) {
    if (this.potion.value.storage > 0) {
      this.potion.value.storage = this.potion.value.storage - 1;
    }
    attackWizard.additionalFactor = this.potion.value.additionalFactor;
    attackWizard.healthPoints =
      Math.round(
        (attackWizard.healthPoints +
          this.potion.value.healing * attackWizard.internHealthPoints) *
          100
      ) / 100;
    attackWizard.energy =
      Math.round(
        (attackWizard.energy +
          this.potion.value.energyRestorage * attackWizard.internEnergy) *
          100
      ) / 100;
    if (this.potion.value.antiParalysis) {
      attackWizard.stunnedProtection = 3;
    }

    if (this.potion.value.antiConfunded) {
      attackWizard.confundedProtection = 3;
    }

    if (this.potion.value.unicornBlood) {
      attackWizard.halfLife = true;
    }

    if (this.potion.value.regeneration && !defender && this.voldemortIsDead) {
      this.hpService.getVoldemort().subscribe((v) => {
        console.log(v);
        if (v) {
          v.name = v.name + ' (resurected)';
          v.healthPoints =
            Math.round(v.internHealthPoints * Math.random() * 100) / 100;
          v.potions.forEach((p) => (p.storage = 0));
          this.wizardsArray.push(v);
          alert('Voldemort has been resurected and rejoins the Fight!');
        }
      });
    }
  }

  formattingStunnedAndConfunded(defendWizard: Hptype) {
    defendWizard.conditions[0].condition = false;
    defendWizard.conditions[1].condition = false;
  }

  spellEffects(defendWizard: Hptype, attackWizard: Hptype) {
    if (this.spell.value.imperio) {
      if (
        attackWizard.id === this.wizardsArray[0].id &&
        attackWizard.id !== this.wizardsArray[this.wizardsArray.length - 1].id
      )
        if (defendWizard.additionalFactor < 1.5) {
          {
            const choice = Math.floor(
              Math.random() *
                (this.wizardsArray.length - this.attackWizardNumber) +
                this.attackWizardNumber +
                1
            );
            this.getDamage(
              defendWizard,
              this.wizardsArray[choice - 1],
              defendWizard.spells[
                Math.floor(Math.random() * defendWizard.spells.length)
              ].maxDamage,
              true
            );
          }
        } else {
          alert('Brain Elixir prevented Imperio');
        }

      this.confunded(defendWizard);
    }

    if (this.spell.value.protego) {
      attackWizard.protego = true;
    }

  }

  checkIfDead() {
    return (
      this.wizardsArray.filter(
        (v) => v.klasse === 'Voldemort' && v.healthPoints < 0
      ).length > 0
    );
  }

  reduceProtection(defendWizard: Hptype) {
    if (defendWizard.stunnedProtection > 0) {
      defendWizard.stunnedProtection = defendWizard.stunnedProtection - 1;
    }
    if (defendWizard.confundedProtection > 0) {
      defendWizard.confundedProtection = defendWizard.confundedProtection - 1;
    }
  }

  halfLifeEffects(attackWizard: Hptype) {
    if (attackWizard.halfLife) {
      attackWizard.additionalFactor =
        Math.round((Math.random() + 0.5) * 10) / 10;
      attackWizard.healthPoints =
        Math.round(
          (attackWizard.healthPoints +
            attackWizard.internHealthPoints * ((Math.random() - 0.5) * 0.2)) *
            100
        ) / 100;
    }
  }

  stunned(defendWizard: Hptype) {
    if (Math.random() > 0.5 && this.spell.value.stunned) {
      if (defendWizard.stunnedProtection === 0) {
        defendWizard.conditions[1].condition = true;
        console.log('Stunned');
      } else {
        console.log('The stunning effect has been repelled');
      }
    }
  }

  confunded(defendWizard: Hptype) {
    if (Math.random() > 0.5 && this.spell.value.confunded) {
      if (defendWizard.confundedProtection === 0) {
        defendWizard.conditions[0].condition = true;
        console.log('Confunded');
      } else {
        console.log('The confunded effect has been repelled');
      }
    }
  }

  gotoAttackDetail(attackId: number) {
    this.ms.sendAttackId(attackId);
    const url = 'spelldetail/' + attackId;
    window.open(url);
  }

  gotoPotionDetail(potionId: number) {
    this.ms.sendPotionId(potionId);
    const url = 'potiondetail/' + potionId;
    window.open(url);
  }

  gotoRules() {
    this.ms.sendShow(false);
    window.open('rules');
  }

  updateVictories() {
    this.wizardsArray.forEach((za) => {
      let speicher: Hptype;
      this.hpService.getWizardById(za.id).subscribe((z) => {
        speicher = z;
        if (za.healthPoints > 0) {
          speicher.victories = speicher.victories + 1;
          if(speicher.victories<400){
            speicher.rank = this.extraService.ranking[Math.floor(speicher.victories/5)];
            //Math.floor((rank +2)/3 * rank)
          }
        }
        this.hpService.updateVictories(speicher).subscribe();
      });
    });
  }

  victoryFormation() {
    this.attackWizard2.next(false);
    this.attackWizard1.next(false);
    this.showResult.next(true);
  }

  gotoNextRound(defendWizard: Hptype) {
    this.attackWizard2.next(false);
    this.attackWizard1.next(true);
    if (this.wizard2 !== undefined) {
      alert(
        defendWizard.name +
          ' has been defeated, ' +
          this.wizard2.name +
          ' will carry on the attack'
      );
    }
  }

  resetAFandProtego(attackWizard: Hptype, defendWizard: Hptype) {
    attackWizard.additionalFactor = 1;
    defendWizard.protego = false;
  }

  fiendfyreEffects(attackWizard: Hptype){
    if (attackWizard.fiendfyre) {
      if (this.spell.value.name === 'Anti Fiendfyre') {
        attackWizard.fiendfyre = false;
      } else {
        attackWizard.healthPoints = -100;
      }
    }
  }
}
