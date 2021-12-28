import { Component, OnInit } from '@angular/core';
import { FormControl } from '@angular/forms';
import { BehaviorSubject } from 'rxjs';
import { HarrypotterService } from '../harrypotter.service';
import { HpWizard } from '../hp-wizard';
import { ExtraService } from '../extra.service';

@Component({
  selector: 'app-harrypotter',
  templateUrl: './harrypotter.component.html',
  styleUrls: ['./harrypotter.component.css'],
})
export class HarrypotterComponent implements OnInit {
  wizards: HpWizard[] = [];
  results: HpWizard[] = [];
  showAll = new BehaviorSubject<boolean>(true);
  showFilter = new BehaviorSubject<boolean>(false);
  max: FormControl = new FormControl();
  min: FormControl = new FormControl();
  spellAmount = new FormControl('');
  potionAmount = new FormControl('');
  animalAmount = new FormControl('');
  minVictories = new FormControl('');
  class: string[] = this.extraService.wizardType;

  constructor(
    private hpService: HarrypotterService,
    private extraService: ExtraService
  ) {}

  ngOnInit(): void {
    this.getAllWizards();
  }

  getAllWizards() {
    this.hpService.getWizards().subscribe((element) => {
      this.wizards = element;
      //this.mss.sendArray(this.zauberer);
    });
  }

  getWizard(house: string) {
    console.log(house);
    this.hpService
      .getWizardSearchKlasse(house)
      .subscribe((x) => (this.wizards = x));
  }

  deleteFilter() {
    this.extraService.redirectTo('overview');
  }

  maxSearch(event: any) {
    this.hpService
      .getHealthpointsMax(Math.round(this.max.value))
      .subscribe((x) => (this.wizards = x));
  }

  minSearch(event: any) {
    this.hpService
      .getHealthpointsMin(Math.round(this.min.value))
      .subscribe((x) => {
        this.wizards = x;
      });
  }

  getSpellAmount(event: any) {
    this.hpService.getWizards().subscribe((za) => {
      let platzhalter = za;
      this.wizards = [];
      platzhalter
        .filter(
          (element) =>
            element.spells.length === Math.round(this.spellAmount.value)
        )
        .forEach((element) => this.wizards.push(element));
    });
  }

  getPotionAmount(event: any) {
    this.hpService.getWizards().subscribe((za) => {
      let platzhalter = za;
      this.wizards = [];
      platzhalter
        .filter(
          (element) =>
            element.potions.length === Math.round(this.potionAmount.value)
        )
        .forEach((element) => this.wizards.push(element));
    });
  }

  getAnimalAmount(event: any) {
    this.hpService.getWizards().subscribe((za) => {
      let platzhalter = za;
      this.wizards = [];
      platzhalter
        .filter(
          (element) =>
            element.animals.length === Math.round(this.animalAmount.value)
        )
        .forEach((element) => this.wizards.push(element));
    });
  }

  getMinVictories(event: any) {
    console.log(this.minVictories.value);
    this.hpService
      .getVictoriesMin(Math.round(this.minVictories.value))
      .subscribe((x) => {
        this.wizards = x;
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
}
