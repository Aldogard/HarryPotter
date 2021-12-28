import { Component, OnInit } from '@angular/core';
import { HarrypotterService } from '../harrypotter.service';
import { HpSpell } from '../hp-spell';
import { HpPotion } from '../hp-potion';
import { HpWizard } from '../hp-wizard';

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.css'],
})
export class HomeComponent implements OnInit {
  wizard?: HpWizard;
  quote: string = '';

  constructor(private hpService: HarrypotterService) {}

  ngOnInit(): void {
    this.getBestWizard();
    this.getQuote();
  }

  getBestWizard() {
    let max = 0;
    let maxVictories = 0;
    this.hpService.getWizards().subscribe((arrayZ) => {
      max = arrayZ[0].id;
      arrayZ.forEach((zauberer) => {
        if (zauberer.victories > maxVictories) {
          maxVictories = zauberer.victories;
          max = zauberer.id;
        }
      });
      this.hpService.getWizardById(max).subscribe((w) => (this.wizard = w));
    });
  }

  getQuote() {
    this.hpService.getQuote().subscribe((q) => {
      this.quote = q;
    });
  }

  // Score berechnen
  getMostPowerfulAttack(list: HpSpell[]) {
    let name = '';
    const maxDamage = Math.max.apply(
      Math,
      list.map((s) => s.maxDamage)
    );

    name = list[0].name;
    list.forEach((item) => {
      if (item.maxDamage === maxDamage) {
        name = item.name;
      }
    });
    return name;
  }

  //Score berechnen
  getMostPowerfulPotion(list: HpPotion[]) {
    let name = '';
    const maxHealing = Math.max.apply(
      Math,
      list.map((s) => s.healing)
    );

    name = list[0].name;
    list.forEach((item) => {
      if (item.healing === maxHealing) {
        name = item.name;
      }
    });

    return name;
  }
}
