import { Component, OnInit } from '@angular/core';
import { HpMagicalBeing } from '../interfaces/hp-magical-being';
import { HpMelee } from '../interfaces/hp-melee';
import { ExtraService } from '../services/extra.service';
import { MagicalBeingService } from '../services/magical-being.service';

@Component({
  selector: 'app-overview-melee',
  templateUrl: './overview-melee.component.html',
  styleUrls: ['./overview-melee.component.css']
})
export class OverviewMeleeComponent implements OnInit {
  wizards: HpMagicalBeing[] = [];
  melees: HpMelee[] = [];

  constructor(
    private mbService: MagicalBeingService,
    private extraService: ExtraService
  ) {}

  ngOnInit(): void {
    this.mbService.getMagicalBeings().subscribe((ws) => {
      ws.forEach((w) =>
        w.melees.forEach((m: HpMelee) => {
          if (
            this.melees.find((melee) => melee.name === m.name) === undefined
          ) {
            this.melees.push(m);
          }
        })
      );
    });
  }

  gotoSpells(){
    this.extraService.redirectTo('spells');
  }

  gotoPotions() {
    this.extraService.redirectTo('potions');
  }

  gotoOverview() {
    this.extraService.redirectTo('overview');
  }

  gotoAnimals(){
    this.extraService.redirectTo('animals')
  }

}
