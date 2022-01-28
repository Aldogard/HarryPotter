import { Component, OnInit } from '@angular/core';
import { FormControl } from '@angular/forms';
import { BehaviorSubject } from 'rxjs';
import { WizardService } from '../services/wizard.service';
import { ExtraService } from '../services/extra.service';
import { MagicalBeingService } from '../services/magical-being.service';
import { HpMagicalBeing } from '../interfaces/hp-magical-being';
import { HpWizard } from '../interfaces/hp-wizard';

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
  class: string[] = this.extraService.magicalBeingType;
  species: string[] = this.extraService.species;

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

  getMagicalBeingByHouse(house: string) {
    console.log(house);
    this.mbService
      .getMagicalBeingSearchKlasse(house)
      .subscribe((x) => (this.magicalBeings = x));
  }

  getMagicalBeingBySpecies(species: string) {
    console.log(species);
    this.mbService
      .getMagicalBeingSearchSpecies(species)
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

  gotoMelees(){
    this.extraService.redirectTo('melees')
  }

  showHideFilter(status: boolean){
    this.showFilter.next(status);

  }
}
