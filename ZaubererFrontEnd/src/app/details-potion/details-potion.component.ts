import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { WizardService } from '../wizard.service';
import { HpPotion } from '../hp-potion';
import { MessageService } from '../message.service';
import { ExtraService } from '../extra.service';
import { MagicalBeingService } from '../magical-being.service';

@Component({
  selector: 'app-details-potion',
  templateUrl: './details-potion.component.html',
  styleUrls: ['./details-potion.component.css'],
})
export class DetailsPotionComponent implements OnInit {
  id: number = 0;
  potion?: HpPotion;
  constructor(
    private mbService: MagicalBeingService,
    private extraService: ExtraService,
    private ar: ActivatedRoute
  ) {}

  ngOnInit(): void {
    this.id = this.ar.snapshot.paramMap.get('id') as unknown as number;
    this.mbService.getPotionById(this.id).subscribe((p) => {
      if (!p) {
        this.extraService.redirectTo('overview');
      } else {
        this.potion = p;
      }
    });
  }

  gotoWiki(){
    window.open('https://harrypotter.fandom.com/wiki/Main_Page');
  }
}
