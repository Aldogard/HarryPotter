import { Component, OnInit } from '@angular/core';
import { ExtraService } from '../extra.service';

@Component({
  selector: 'app-ranks',
  templateUrl: './ranks.component.html',
  styleUrls: ['./ranks.component.css'],
})
export class RanksComponent implements OnInit {
  ranks: string[] = []
  count10: number[] = [];
  count20: number[] = [];

  constructor(private extraService: ExtraService) {}

  ngOnInit(): void {
    this.ranks = this.extraService.ranking;
  }

  counterTill10() {
    for (let i = 0; i < 10; i++) {
      this.count10.push(i);
    }
    
    return this.count10;
  }

  counterFrom10() {
    for (let i = 10; i < 20; i++) {
      this.count20.push(i);
    }
    
    return this.count20;
  }

  round(rank: number){
    return Math.floor(rank * 5);
  }
}
