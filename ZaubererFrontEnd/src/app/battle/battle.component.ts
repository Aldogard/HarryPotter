import { Component, OnInit } from '@angular/core';
import { FormControl } from '@angular/forms';
import { BehaviorSubject } from 'rxjs';
import { MessageService } from '../services/message.service';
import { ExtraService } from '../services/extra.service';
import { MagicalBeingService } from '../services/magical-being.service';
import { HpPotion } from '../interfaces/hp-potion';
import { HpSpell } from '../interfaces/hp-spell';
import { HpAnimal } from '../interfaces/hp-animal';
import { HpMagicalBeing } from '../interfaces/hp-magical-being';

@Component({
  selector: 'app-battle',
  templateUrl: './battle.component.html',
  styleUrls: ['./battle.component.css'],
})
export class BattleComponent implements OnInit {
  magicalBeingsArray: HpMagicalBeing[] = [];
  magicalBeing1?: HpMagicalBeing;
  magicalBeing2?: HpMagicalBeing;
  magicalBeing3?: HpMagicalBeing;
  magicalBeing4?: HpMagicalBeing;
  magicalBeing5?: HpMagicalBeing;
  options = this.extraService.options;
  chosenOption: string = '';
  validateSpell = new BehaviorSubject<boolean>(false);
  validatePotion = new BehaviorSubject<boolean>(false);
  validateAnimal = new BehaviorSubject<boolean>(false);
  spell = new FormControl('');
  potion = new FormControl('');
  animal = new FormControl('');
  attackMagicalBeing1 = new BehaviorSubject<boolean>(false);
  attackMagicalBeing2 = new BehaviorSubject<boolean>(true);
  showResult = new BehaviorSubject<boolean>(false);
  showStart = new BehaviorSubject<boolean>(true);
  showTable = new BehaviorSubject<boolean>(true);
  showDetails = new BehaviorSubject<boolean>(true);
  attackMagicalBeingNumber: number = 1;
  voldemortIsDead: boolean = false;
  environment: string = '';

  constructor(
    private mbService: MagicalBeingService,
    private extraService: ExtraService,
    private ms: MessageService
  ) {}

  ngOnInit(): void {
    this.environment = this.ms.environment.value;
    this.ms.magicalBeingArray.subscribe((za) => {
      this.magicalBeingsArray = za;
      this.magicalBeing1 = za[0];
      this.magicalBeing2 = za[1];
      if (za.length > 2) {
        this.magicalBeing3 = za[2];
      }
      if (za.length > 3) {
        this.magicalBeing4 = za[3];
      }
    });
    this.determineStarter();
  }

  determineStarter() {
    if (Math.random() > 0.5) {
      this.attackMagicalBeing1.next(true);
      this.attackMagicalBeing2.next(false);
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

  getAnimal(animal: HpAnimal) {
    this.animal = new FormControl(animal);
    this.validateAnimal.next(true);
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

    attackMagicalBeing.energy = Math.round(attackMagicalBeing.energy * 10) / 10;
    this.resetAFandProtego(attackMagicalBeing, defendMagicalBeing);
    this.reduceProtection(defendMagicalBeing);
    this.halfLifeEffects(attackMagicalBeing);
    this.nextRound(defendMagicalBeing, defender, attackMagicalBeing);

    if (this.spell.value.fiendfyre) {
      attackMagicalBeing.fiendfyre = true;
    }
    if (this.spell.value.name === 'Piertotum Locomotor') {
      attackMagicalBeing.ptCounter++;
    }
    this.formattingOfKeyVariables();
  }

  executePotion(
    attackMagicalBeing: HpMagicalBeing,
    defendMagicalBeing: HpMagicalBeing,
    defender: boolean
  ) {
    this.preparation(attackMagicalBeing);
    this.fiendfyreEffects(attackMagicalBeing);
    if (!attackMagicalBeing.conditions[1].condition) {
      this.potionEffects(attackMagicalBeing, defender);

      this.getDamage(
        attackMagicalBeing,
        defendMagicalBeing,
        this.potion.value.maxDamage,
        false
      );

      this.formattingStunnedAndConfunded(defendMagicalBeing);
    } else {
      alert(
        attackMagicalBeing.name +
          ' has been stunned and cannot use a Potion this round!'
      );
    }

    attackMagicalBeing.energy = Math.round(attackMagicalBeing.energy * 10) / 10;
    this.reduceProtection(defendMagicalBeing);
    this.nextRound(defendMagicalBeing, defender, attackMagicalBeing);
    this.formattingOfKeyVariables();
  }

  useAnimal(
    attackMagicalBeing: HpMagicalBeing,
    defendMagicalBeing: HpMagicalBeing,
    defender: boolean
  ) {
    this.preparation(attackMagicalBeing);
    this.fiendfyreEffects(attackMagicalBeing);
    if (!attackMagicalBeing.conditions[1].condition) {
      attackMagicalBeing.energy =
        attackMagicalBeing.energy - this.animal.value.energyUsage;
      this.animalEffects(defendMagicalBeing, attackMagicalBeing);
      this.fiendfyreEffects(attackMagicalBeing);
      this.getDamage(
        attackMagicalBeing,
        defendMagicalBeing,
        this.animal.value.maxDamage,
        false
      );

      this.formattingStunnedAndConfunded(defendMagicalBeing);
    } else {
      alert(
        attackMagicalBeing.name +
          ' has been stunned and cannot use a Potion this round!'
      );
    }

    attackMagicalBeing.energy = Math.round(attackMagicalBeing.energy * 10) / 10;
    this.reduceProtection(defendMagicalBeing);
    this.nextRound(defendMagicalBeing, defender, attackMagicalBeing);
    this.formattingOfKeyVariables();
  }

  nextRound(
    defendMagicalBeing: HpMagicalBeing,
    defender: boolean,
    attackMagicalBeing: HpMagicalBeing
  ) {
    this.voldemortIsDead = this.checkIfDead();

    if (
      ((defendMagicalBeing.healthPoints <= 0 && !defendMagicalBeing.halfLife) ||
        (attackMagicalBeing.healthPoints <= 0 &&
          !attackMagicalBeing.halfLife)) &&
      (!defender ||
        defendMagicalBeing ===
          this.magicalBeingsArray[this.magicalBeingsArray.length - 1])
    ) {
      this.victoryFormation();
      this.updateVictories();
    } else if (
      ((defendMagicalBeing.healthPoints <= -100 &&
        defendMagicalBeing.halfLife) ||
        (attackMagicalBeing.healthPoints <= -100 &&
          attackMagicalBeing.halfLife)) &&
      (!defender ||
        defendMagicalBeing ===
          this.magicalBeingsArray[this.magicalBeingsArray.length - 1])
    ) {
      this.victoryFormation();
      this.updateVictories();
    } else if (
      ((defendMagicalBeing.healthPoints <= 0 && !defendMagicalBeing.halfLife) ||
        (attackMagicalBeing.healthPoints <= 0 &&
          !attackMagicalBeing.halfLife)) &&
      defendMagicalBeing !==
        this.magicalBeingsArray[this.magicalBeingsArray.length - 1]
    ) {
      this.attackMagicalBeingNumber++;
      const tempStorage = this.magicalBeing2;
      this.magicalBeing2 =
        this.magicalBeingsArray[this.attackMagicalBeingNumber];
      this.switchMagicalBeings(tempStorage);
      this.gotoNextRound(defendMagicalBeing);
      if (
        this.magicalBeing2 !== undefined &&
        this.magicalBeing1 !== undefined
      ) {
        if (this.magicalBeing2.healthPoints < 0) {
          this.nextRound(this.magicalBeing2, defender, this.magicalBeing1);
        }
      }
    } else if (
      ((defendMagicalBeing.healthPoints <= -100 &&
        defendMagicalBeing.halfLife) ||
        (attackMagicalBeing.healthPoints <= -100 &&
          attackMagicalBeing.halfLife)) &&
      defendMagicalBeing !==
        this.magicalBeingsArray[this.magicalBeingsArray.length - 1]
    ) {
      this.attackMagicalBeingNumber++;
      const tempStorage = this.magicalBeing2;
      this.magicalBeing2 =
        this.magicalBeingsArray[this.attackMagicalBeingNumber];
      this.switchMagicalBeings(tempStorage);
      this.gotoNextRound(defendMagicalBeing);
      if (
        this.magicalBeing2 !== undefined &&
        this.magicalBeing1 !== undefined
      ) {
        if (this.magicalBeing2.healthPoints < 0) {
          this.nextRound(this.magicalBeing2, defender, this.magicalBeing1);
        }
      }
    } else {
      this.attackMagicalBeing2.next(!this.attackMagicalBeing2.value);
      this.attackMagicalBeing1.next(!this.attackMagicalBeing1.value);
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
    if (defendMagicalBeing.species === 'Giant') {
      randomFactor = randomFactor * Math.random() * 0.5;
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

  potionEffects(attackMagicalBeing: HpMagicalBeing, defender: boolean) {
    if (this.potion.value.storage > 0) {
      this.potion.value.storage = this.potion.value.storage - 1;
    }
    attackMagicalBeing.additionalFactor = this.potion.value.additionalFactor;
    attackMagicalBeing.healthPoints =
      Math.round(
        (attackMagicalBeing.healthPoints +
          this.potion.value.healing * attackMagicalBeing.internHealthPoints) *
          100
      ) / 100;
    attackMagicalBeing.energy =
      Math.round(
        (attackMagicalBeing.energy +
          this.potion.value.energyRecovery * attackMagicalBeing.internEnergy) *
          100
      ) / 100;
    if (this.potion.value.antiParalysis) {
      attackMagicalBeing.stunnedProtection = 3;
    }

    if (this.potion.value.antiConfunded) {
      attackMagicalBeing.confundedProtection = 3;
    }

    if (this.potion.value.unicornBlood) {
      attackMagicalBeing.halfLife = true;
    }

    if (this.potion.value.regeneration && !defender && this.voldemortIsDead) {
      this.mbService.getVoldemort().subscribe((v) => {
        console.log(v);
        if (v) {
          v.name = v.name + ' (resurected)';
          v.healthPoints =
            Math.round(v.internHealthPoints * Math.random() * 100) / 100;
          v.potions.forEach((p: { storage: number; }) => (p.storage = 0));
          this.magicalBeingsArray.push(v);
          this.magicalBeing5 = v;
          alert('Voldemort has been resurected and rejoins the Fight!');
        }
      });
    }
  }

  spellEffects(
    defendMagicalBeing: HpMagicalBeing,
    attackMagicalBeing: HpMagicalBeing
  ) {
    if (this.spell.value.imperio && defendMagicalBeing.species !== 'Giant') {
      if (
        attackMagicalBeing.id === this.magicalBeingsArray[0].id &&
        defendMagicalBeing.additionalFactor < 1.5
      ) {
        const choice = Math.floor(
          Math.random() *
            (this.magicalBeingsArray.length - this.attackMagicalBeingNumber) +
            this.attackMagicalBeingNumber
        );

        this.getDamage(
          defendMagicalBeing,
          this.magicalBeingsArray[choice],
          defendMagicalBeing.spells[
            Math.floor(Math.random() * defendMagicalBeing.spells.length)
          ].maxDamage,
          true
        );
      } else if (
        attackMagicalBeing.id !== this.magicalBeingsArray[0].id &&
        defendMagicalBeing.additionalFactor < 1.5
      ) {
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

    // if (this.spell.value.imperio) {
    //   if (
    //     attackMagicalBeing.id === this.magicalBeingsArray[0].id &&
    //     attackMagicalBeing.id !==
    //       this.magicalBeingsArray[this.magicalBeingsArray.length - 1].id
    //   )
    //     if (defendMagicalBeing.additionalFactor < 1.5) {
    //       {
    //         const choice = Math.floor(
    //           Math.random() *
    //             (this.magicalBeingsArray.length -
    //               this.attackMagicalBeingNumber) +
    //             this.attackMagicalBeingNumber +
    //             1
    //         );
    //         this.getDamage(
    //           defendMagicalBeing,
    //           this.magicalBeingsArray[choice - 1],
    //           defendMagicalBeing.spells[
    //             Math.floor(Math.random() * defendMagicalBeing.spells.length)
    //           ].maxDamage,
    //           true
    //         );
    //       }
    //     } else {
    //       alert('Brain Elixir prevented Imperio');
    //     }

    //   this.confunded(defendMagicalBeing);
    // }
    else {
      if (this.spell.value.protego) {
        attackMagicalBeing.protego = true;
      }

      attackMagicalBeing.healthPoints =
        Math.round(
          (attackMagicalBeing.healthPoints +
            this.spell.value.healing * attackMagicalBeing.internHealthPoints) *
            100
        ) / 100;
    }
  }

  animalEffects(
    defendMagicalBeing: HpMagicalBeing,
    attackMagicalBeing: HpMagicalBeing
  ) {
    attackMagicalBeing.healthPoints =
      Math.round(
        (attackMagicalBeing.healthPoints +
          this.animal.value.healing * attackMagicalBeing.internHealthPoints) *
          100
      ) / 100;
    attackMagicalBeing.energy =
      Math.round(
        (attackMagicalBeing.energy +
          this.animal.value.energyRecovery * attackMagicalBeing.internEnergy) *
          100
      ) / 100;

    if (this.animal.value.niffler && Math.random() > 0.5) {
      let availablePotions: HpPotion[] = [];
      let chosenPotion: HpPotion;
      defendMagicalBeing.potions.forEach((p) => {
        if (p.storage > 0) {
          availablePotions.push(p);
        }
      });
      chosenPotion =
        availablePotions[Math.floor(Math.random() * availablePotions.length)];
      defendMagicalBeing.potions.forEach((p) => {
        if (chosenPotion === p) {
          p.storage = p.storage - 1;
        }
      });
      attackMagicalBeing.potions.forEach((p) => {
        if (chosenPotion.name === p.name) {
          p.storage = p.storage + 1;
        }
      });
    }
  }

  checkIfDead() {
    return (
      this.magicalBeingsArray.filter(
        (v) =>
          v.klasse === 'Voldemort' &&
          v.healthPoints < 0 &&
          this.magicalBeingsArray[0] !== v
      ).length > 0
    );
  }

  reduceProtection(defendMagicalBeing: HpMagicalBeing) {
    if (defendMagicalBeing.stunnedProtection > 0) {
      defendMagicalBeing.stunnedProtection =
        defendMagicalBeing.stunnedProtection - 1;
    }
    if (defendMagicalBeing.confundedProtection > 0) {
      defendMagicalBeing.confundedProtection =
        defendMagicalBeing.confundedProtection - 1;
    }
  }

  halfLifeEffects(attackMagicalBeing: HpMagicalBeing) {
    if (attackMagicalBeing.halfLife) {
      attackMagicalBeing.additionalFactor =
        Math.round((Math.random() + 0.5) * 10) / 10;
      attackMagicalBeing.healthPoints =
        Math.round(
          (attackMagicalBeing.healthPoints +
            attackMagicalBeing.internHealthPoints *
              ((Math.random() - 0.5) * 0.2)) *
            100
        ) / 100;
    }
  }

  stunned(defendMagicalBeing: HpMagicalBeing) {
    if (
      Math.random() > 0.5 &&
      this.spell.value.stunned &&
      defendMagicalBeing.species !== 'Giant'
    ) {
      if (defendMagicalBeing.stunnedProtection === 0) {
        defendMagicalBeing.conditions[1].condition = true;
        console.log('Stunned');
      } else {
        console.log('The stunning effect has been repelled');
      }
    }
  }

  confunded(defendMagicalBeing: HpMagicalBeing) {
    if (
      Math.random() > 0.5 &&
      this.spell.value.confunded &&
      defendMagicalBeing.species !== 'Giant'
    ) {
      if (defendMagicalBeing.confundedProtection === 0) {
        defendMagicalBeing.conditions[0].condition = true;
        console.log('Confunded');
      } else {
        console.log('The confunded effect has been repelled');
      }
    }
  }

  formattingOfKeyVariables() {
    this.spell = new FormControl('');
    this.potion = new FormControl('');
    this.animal = new FormControl('');
    this.validateSpell.next(false);
    this.validatePotion.next(false);
    this.validateAnimal.next(false);
    this.chosenOption = '';
  }

  updateVictories() {
    this.magicalBeingsArray.forEach((mb) => {
      let speicher: HpMagicalBeing;
      this.mbService.getMagicalBeingById(mb.id).subscribe((m) => {
        speicher = m;
        if (mb.healthPoints > 0) {
          speicher.victories = speicher.victories + 1;
          if (speicher.victories < 100) {
            speicher.rank =
              this.extraService.ranking[Math.floor(speicher.victories / 5)];
            //Math.floor((rank +2)/3 * rank)
          }
        }
        this.mbService.updateVictories(speicher).subscribe();
      });
    });
  }

  victoryFormation() {
    this.attackMagicalBeing2.next(false);
    this.attackMagicalBeing1.next(false);
    this.showResult.next(true);
    this.showTable.next(false);
  }

  gotoNextRound(defendMagicalBeing: HpMagicalBeing) {
    this.attackMagicalBeing2.next(false);
    this.attackMagicalBeing1.next(true);
    if (this.magicalBeing2 !== undefined) {
      alert(
        defendMagicalBeing.name +
          ' has been defeated, ' +
          this.magicalBeing2.name +
          ' will carry on the attack'
      );
    }
  }

  formattingStunnedAndConfunded(defendMagicalBeing: HpMagicalBeing) {
    defendMagicalBeing.conditions[0].condition = false;
    defendMagicalBeing.conditions[1].condition = false;
  }

  resetAFandProtego(
    attackMagicalBeing: HpMagicalBeing,
    defendMagicalBeing: HpMagicalBeing
  ) {
    attackMagicalBeing.additionalFactor = 1;
    defendMagicalBeing.protego = false;
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

  preparation(attackMagicalBeing: HpMagicalBeing) {
    this.showStart.next(false);
    attackMagicalBeing.energy = attackMagicalBeing.energy + 3;
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

  gotoAnimalDetail(animalId: number) {
    this.ms.sendAnimalId(animalId);
    const url = 'animaldetail/' + animalId;
    window.open(url);
  }

  gotoRules() {
    this.ms.sendShow(false);
    window.open('rules');
  }

  gotoPrologue() {
    this.extraService.redirectTo('prologue');
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

  switchMagicalBeings(magicalBeing: HpMagicalBeing | undefined) {
    if (this.attackMagicalBeingNumber === 2) {
      this.magicalBeing3 = magicalBeing;
    }
    if (this.attackMagicalBeingNumber === 3) {
      this.magicalBeing4 = magicalBeing;
    }
    if (this.attackMagicalBeingNumber === 4) {
      this.magicalBeing5 = magicalBeing;
    }
  }
}
