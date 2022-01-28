import { Component, OnInit } from '@angular/core';
import { HpAnimal } from '../interfaces/hp-animal';
import { ExtraService } from '../services/extra.service';
import { HpMagicalBeing } from '../interfaces/hp-magical-being';
import { MagicalBeingService } from '../services/magical-being.service';

@Component({
  selector: 'app-overview-animal',
  templateUrl: './overview-animal.component.html',
  styleUrls: ['./overview-animal.component.css']
})
export class OverviewAnimalComponent implements OnInit {
  wizards: HpMagicalBeing[] = [];
  animals: HpAnimal[] = [];

  constructor(
    private mbService: MagicalBeingService,
    private extraService: ExtraService
  ) {}

  ngOnInit(): void {
    this.mbService.getMagicalBeings().subscribe((ws) => {
      ws.forEach((w) =>
        w.animals.forEach((p: HpAnimal) => {
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
