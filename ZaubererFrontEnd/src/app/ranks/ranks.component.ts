import { Component, OnInit } from '@angular/core';
import { ExtraService } from '../extra.service';

@Component({
  selector: 'app-ranks',
  templateUrl: './ranks.component.html',
  styleUrls: ['./ranks.component.css'],
})
export class RanksComponent implements OnInit {
  ranks: string[] = []
  count: number[] = [];

  constructor(private extraService: ExtraService) {}

  ngOnInit(): void {
    this.ranks = this.extraService.ranking;
  }

  counter() {
    for (let i = 0; i < 20; i++) {
      this.count.push(i);
    }
    
    return this.count;
  }

  round(rank: number){
    return Math.floor(Math.pow(rank, 2));
  }
}
