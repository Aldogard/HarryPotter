import { Component, OnInit } from '@angular/core';
import { WizardService } from '../wizard.service';
import { HpSpell } from '../hp-spell';
import { HpWizard } from '../hp-wizard';
import { ExtraService } from '../extra.service';
import { MagicalBeingService } from '../magical-being.service';

@Component({
  selector: 'app-attacks',
  templateUrl: './spells.component.html',
  styleUrls: ['./spells.component.css'],
})
export class OverviewSpellComponent implements OnInit {
  wizards: HpWizard[] = [];
  spells: HpSpell[] = [];

  constructor(
    private mbService: MagicalBeingService,
    private extraService: ExtraService
  ) {}

  ngOnInit(): void {
    this.mbService.getMagicalBeings().subscribe((ws) => {
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

  gotoAnimals(){
    this.extraService.redirectTo('animals')
  }
}
