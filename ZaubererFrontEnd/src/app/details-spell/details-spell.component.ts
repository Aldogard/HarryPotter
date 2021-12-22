import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { HarrypotterService } from '../harrypotter.service';
import { HpSpell } from '../hp-spell';
import { MessageService } from '../message.service';
import { ExtraService } from '../extra.service';

@Component({
  selector: 'app-details-spell',
  templateUrl: './details-spell.component.html',
  styleUrls: ['./details-spell.component.css'],
})
export class DetailsSpellComponent implements OnInit {
  id: number = 0;
  spell?: HpSpell;
  constructor(
    private hpService: HarrypotterService,
    private extraService: ExtraService,
    private ar: ActivatedRoute
  ) {}

  ngOnInit(): void {
    this.id = this.ar.snapshot.paramMap.get('id') as unknown as number;
    this.hpService.getAttackById(this.id).subscribe((s) => {
      console.log(s);
      if (!s) {
        this.extraService.redirectTo('overview');
      } else {
        this.spell = s;
      }
    });
  }
}
