import { Component, OnInit } from '@angular/core';
import { HarrypotterService } from '../harrypotter.service';
import { HpSpell } from '../hp-spell';
import { HpWizard } from '../hp-wizard';
import { ExtraService } from '../extra.service';

@Component({
  selector: 'app-attacks',
  templateUrl: './spells.component.html',
  styleUrls: ['./spells.component.css'],
})
export class SpellsComponent implements OnInit {
  wizards: HpWizard[] = [];
  spells: HpSpell[] = [];

  constructor(
    private hpService: HarrypotterService,
    private extraService: ExtraService
  ) {}

  ngOnInit(): void {
    this.hpService.getWizards().subscribe((ws) => {
      ws.forEach((w) =>
        w.spells.forEach((a) => {
          if (
            this.spells.find((attack) => attack.name === a.name) === undefined
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
}
