import { Component, OnInit } from '@angular/core';
import { HpPotion } from '../interfaces/hp-potion';
import { ExtraService } from '../services/extra.service';
import { HpMagicalBeing } from '../interfaces/hp-magical-being';
import { MagicalBeingService } from '../services/magical-being.service';

@Component({
  selector: 'app-potions',
  templateUrl: './potions.component.html',
  styleUrls: ['./potions.component.css'],
})
export class OverviewPotionComponent implements OnInit {
  wizards: HpMagicalBeing[] = [];
  potions: HpPotion[] = [];

  constructor(
    private mbService: MagicalBeingService,
    private extraService: ExtraService
  ) {}

  ngOnInit(): void {
    this.mbService.getMagicalBeings().subscribe((ws) => {
      ws.forEach((w) =>
        w.potions.forEach((p: HpPotion) => {
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
