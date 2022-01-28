import { Component, OnInit } from '@angular/core';
import { HpSpell } from '../interfaces/hp-spell';
import { ExtraService } from '../services/extra.service';
import { HpMagicalBeing } from '../interfaces/hp-magical-being';
import { MagicalBeingService } from '../services/magical-being.service';

@Component({
  selector: 'app-attacks',
  templateUrl: './spells.component.html',
  styleUrls: ['./spells.component.css'],
})
export class OverviewSpellComponent implements OnInit {
  wizards: HpMagicalBeing[] = [];
  spells: HpSpell[] = [];

  constructor(
    private mbService: MagicalBeingService,
    private extraService: ExtraService
  ) {}

  ngOnInit(): void {
    this.mbService.getMagicalBeings().subscribe((ws) => {
      ws.forEach((w) =>
        w.spells.forEach((a: HpSpell) => {
          if (
            this.spells.find((spell) => spell.name === a.name) === undefined
          ) {
            this.spells.push(a);
          }
        })
      );
    });
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
