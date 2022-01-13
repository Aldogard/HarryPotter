import { Component, OnInit } from '@angular/core';
import { FormControl } from '@angular/forms';
import { BehaviorSubject } from 'rxjs';
import { WizardService } from '../wizard.service';
import { HpWizard } from '../hp-wizard';
import { ExtraService } from '../extra.service';
import { HpMagicalBeing } from '../hp-magical-being';
import { MagicalBeingService } from '../magical-being.service';

@Component({
  selector: 'app-harrypotter',
  templateUrl: './overview.component.html',
  styleUrls: ['./overview.component.css'],
})
export class OverviewComponent implements OnInit {
  magicalBeings: HpMagicalBeing[] = [];
  results: HpWizard[] = [];
  showAll = new BehaviorSubject<boolean>(true);
  showFilter = new BehaviorSubject<boolean>(true);
  max: FormControl = new FormControl();
  min: FormControl = new FormControl();
  spellAmount = new FormControl('');
  potionAmount = new FormControl('');
  animalAmount = new FormControl('');
  minVictories = new FormControl('');
  class: string[] = this.extraService.wizardType;

  constructor(
    private mbService: MagicalBeingService,
    private extraService: ExtraService
  ) {}

  ngOnInit(): void {
    this.getAllMagicalBeings();
  }

  getAllMagicalBeings() {
    this.mbService.getMagicalBeings().subscribe((element) => {
      this.magicalBeings = element;
      //this.mss.sendArray(this.zauberer);
    });
  }

  getMagicalBeing(house: string) {
    console.log(house);
    this.mbService
      .getMagicalBeingSearchKlasse(house)
      .subscribe((x) => (this.magicalBeings = x));
  }

  deleteFilter() {
    this.extraService.redirectTo('overview');
  }

  maxSearch(event: any) {
    this.mbService
      .getHealthpointsMax(Math.round(this.max.value))
      .subscribe((x) => (this.magicalBeings = x));
  }

  minSearch(event: any) {
    this.mbService
      .getHealthpointsMin(Math.round(this.min.value))
      .subscribe((x) => {
        this.magicalBeings = x;
      });
  }

  getSpellAmount(event: any) {
    this.mbService.getMagicalBeings().subscribe((za) => {
      let platzhalter = za;
      this.magicalBeings = [];
      platzhalter
        .filter(
          (element) =>
            element.spells.length === Math.round(this.spellAmount.value)
        )
        .forEach((element) => this.magicalBeings.push(element));
    });
  }

  getPotionAmount(event: any) {
    this.mbService.getMagicalBeings().subscribe((za) => {
      let platzhalter = za;
      this.magicalBeings = [];
      platzhalter
        .filter(
          (element) =>
            element.potions.length === Math.round(this.potionAmount.value)
        )
        .forEach((element) => this.magicalBeings.push(element));
    });
  }

  getAnimalAmount(event: any) {
    this.mbService.getMagicalBeings().subscribe((za) => {
      let platzhalter = za;
      this.magicalBeings = [];
      platzhalter
        .filter(
          (element) =>
            element.animals.length === Math.round(this.animalAmount.value)
        )
        .forEach((element) => this.magicalBeings.push(element));
    });
  }

  getMinVictories(event: any) {
    console.log(this.minVictories.value);
    this.mbService
      .getVictoriesMin(Math.round(this.minVictories.value))
      .subscribe((x) => {
        this.magicalBeings = x;
      });
  }

  gotoPotions() {
    this.extraService.redirectTo('potions');
  }

  gotoSpells() {
    this.extraService.redirectTo('spells');
  }

  gotoAnimals(){
    this.extraService.redirectTo('animals')
  }

  showHideFilter(status: boolean){
    this.showFilter.next(status);

  }
}
