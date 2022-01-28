import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { HpSpell } from '../interfaces/hp-spell';
import { ExtraService } from '../services/extra.service';
import { MagicalBeingService } from '../services/magical-being.service';

@Component({
  selector: 'app-details-spell',
  templateUrl: './details-spell.component.html',
  styleUrls: ['./details-spell.component.css'],
})
export class DetailsSpellComponent implements OnInit {
  id: number = 0;
  spell?: HpSpell;
  constructor(
    private mbService: MagicalBeingService,
    private extraService: ExtraService,
    private ar: ActivatedRoute
  ) {}

  ngOnInit(): void {
    this.id = this.ar.snapshot.paramMap.get('id') as unknown as number;
    this.mbService.getAttackById(this.id).subscribe((s) => {
      console.log(s);
      if (!s) {
        this.extraService.redirectTo('overview');
      } else {
        this.spell = s;
      }
    });
  }

  gotoWiki(){
    window.open('https://harrypotter.fandom.com/wiki/Main_Page');
  }
}
