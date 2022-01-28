import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { HpAnimal } from '../interfaces/hp-animal';
import { ExtraService } from '../services/extra.service';
import { MagicalBeingService } from '../services/magical-being.service';

@Component({
  selector: 'app-details-animal',
  templateUrl: './details-animal.component.html',
  styleUrls: ['./details-animal.component.css']
})
export class DetailsAnimalComponent implements OnInit {
  id: number = 0;
  animal?: HpAnimal;
  constructor(
    private mbService: MagicalBeingService,
    private extraService: ExtraService,
    private ar: ActivatedRoute
  ) {}

  ngOnInit(): void {
    this.id = this.ar.snapshot.paramMap.get('id') as unknown as number;
    this.mbService.getAnimalById(this.id).subscribe((a) => {
      if (!a) {
        this.extraService.redirectTo('overview');
      } else {
        console.log("Check")
        this.animal = a;
      }
    });
  }

  gotoWiki(){
    window.open('https://harrypotter.fandom.com/wiki/Main_Page');
  }
}
