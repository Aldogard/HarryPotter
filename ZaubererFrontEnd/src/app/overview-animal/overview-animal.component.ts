import { Component, OnInit } from '@angular/core';
import { ExtraService } from '../extra.service';
import { HarrypotterService } from '../harrypotter.service';
import { HpAnimal } from '../hp-animal';
import { HpWizard } from '../hp-wizard';

@Component({
  selector: 'app-overview-animal',
  templateUrl: './overview-animal.component.html',
  styleUrls: ['./overview-animal.component.css']
})
export class OverviewAnimalComponent implements OnInit {
  wizards: HpWizard[] = [];
  animals: HpAnimal[] = [];

  constructor(
    private hpService: HarrypotterService,
    private extraService: ExtraService
  ) {}

  ngOnInit(): void {
    this.hpService.getWizards().subscribe((ws) => {
      ws.forEach((w) =>
        w.animals.forEach((p) => {
          if (
            this.animals.find((animal) => animal.name === p.name) === undefined
          ) {
            this.animals.push(p);
          }
        })
      );
    });
  }

  gotoOverview() {
    this.extraService.redirectTo('overview');
  }

  gotoAttacks() {
    this.extraService.redirectTo('spells');
  }

  gotoPotions(){
    this.extraService.redirectTo('potions')
  }

}
