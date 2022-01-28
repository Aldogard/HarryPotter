import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { HpMelee } from '../interfaces/hp-melee';
import { ExtraService } from '../services/extra.service';
import { MagicalBeingService } from '../services/magical-being.service';

@Component({
  selector: 'app-details-melee',
  templateUrl: './details-melee.component.html',
  styleUrls: ['./details-melee.component.css']
})
export class DetailsMeleeComponent implements OnInit {
  id: number = 0;
  melee?: HpMelee;
  constructor(
    private mbService: MagicalBeingService,
    private extraService: ExtraService,
    private ar: ActivatedRoute
  ) {}

  ngOnInit(): void {
    this.id = this.ar.snapshot.paramMap.get('id') as unknown as number;
    this.mbService.getMeleeById(this.id).subscribe((m) => {
      if (!m) {
        this.extraService.redirectTo('overview');
      } else {
        console.log("Check")
        this.melee = m;
      }
    });
  }

  gotoWiki(){
    window.open('https://harrypotter.fandom.com/wiki/Main_Page');
  }

}
