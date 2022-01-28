import { Component, OnInit } from '@angular/core';
import { HpPotion } from '../interfaces/hp-potion';
import { HpSpell } from '../interfaces/hp-spell';
import { HpMagicalBeing } from '../services/hp-magical-being';
import { MagicalBeingService } from '../services/magical-being.service';


@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.css'],
})
export class HomeComponent implements OnInit {
  magicalBeing?: HpMagicalBeing;
  quote: string = '';

  constructor(private mbService: MagicalBeingService) {}

  ngOnInit(): void {
    this.getBestMagicalBeing();
    this.getQuote();
  }

  getBestMagicalBeing() {
    let max = 0;
    let maxVictories = 0;
    this.mbService.getMagicalBeings().subscribe((arrayMb) => {
      max = arrayMb[0].id;
      arrayMb.forEach((mb) => {
        if (mb.victories > maxVictories) {
          maxVictories = mb.victories;
          max = mb.id;
        }
      });
      this.mbService.getMagicalBeingById(max).subscribe((w) => (this.magicalBeing = w));
    });
  }

  getQuote() {
    this.mbService.getQuote().subscribe((q) => {
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
