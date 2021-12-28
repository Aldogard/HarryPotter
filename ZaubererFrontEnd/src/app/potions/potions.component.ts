import { Component, OnInit } from '@angular/core';
import { HarrypotterService } from '../harrypotter.service';
import { HpPotion } from '../hp-potion';
import { HpWizard } from '../hp-wizard';
import { ExtraService } from '../extra.service';

@Component({
  selector: 'app-potions',
  templateUrl: './potions.component.html',
  styleUrls: ['./potions.component.css'],
})
export class PotionsComponent implements OnInit {
  wizards: HpWizard[] = [];
  potions: HpPotion[] = [];

  constructor(
    private hpService: HarrypotterService,
    private extraService: ExtraService
  ) {}

  ngOnInit(): void {
    this.hpService.getWizards().subscribe((ws) => {
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
}
