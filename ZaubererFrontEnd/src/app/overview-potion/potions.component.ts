import { Component, OnInit } from '@angular/core';
import { WizardService } from '../wizard.service';
import { HpPotion } from '../hp-potion';
import { HpWizard } from '../hp-wizard';
import { ExtraService } from '../extra.service';
import { MagicalBeingService } from '../magical-being.service';

@Component({
  selector: 'app-potions',
  templateUrl: './potions.component.html',
  styleUrls: ['./potions.component.css'],
})
export class OverviewPotionComponent implements OnInit {
  wizards: HpWizard[] = [];
  potions: HpPotion[] = [];

  constructor(
    private mbService: MagicalBeingService,
    private extraService: ExtraService
  ) {}

  ngOnInit(): void {
    this.mbService.getMagicalBeings().subscribe((ws) => {
      ws.forEach((w) =>
        w.potions.forEach((p) => {
          if (
            this.potions.find((potion) => potion.name === p.name) === undefined
          ) {
            this.potions.push(p);
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

  gotoAnimals(){
    this.extraService.redirectTo('animals')
  }
}
