import { Component, OnInit } from '@angular/core';
import { FormControl } from '@angular/forms';
import { ExtraService } from '../extra.service';
import { WizardService } from '../wizard.service';
import { HpWizard } from '../hp-wizard';
import { MessageService } from '../message.service';
import { MagicalBeingService } from '../magical-being.service';
import { HpMagicalBeing } from '../hp-magical-being';

@Component({
  selector: 'app-search',
  templateUrl: './result.component.html',
  styleUrls: ['./result.component.css'],
})
export class ResultComponent implements OnInit {
  magicalBeings: HpMagicalBeing[] = [];
  magicalBeingsResults: HpMagicalBeing[] = [];
  searchTerm: string = '';

  constructor(
    private mbService: MagicalBeingService,
    private ms: MessageService,
    private extraService: ExtraService,
  ) {}

  ngOnInit(): void {
    this.mbService
      .getMagicalBeings()
      .subscribe((element) => (this.magicalBeings = element));
      
    this.ms.word.subscribe((search) => {
      this.searchTerm = search;
      this.mbService
        .getMagicalBeingSearch(this.searchTerm)
        .subscribe((results) => (this.magicalBeingsResults = results));
      if(this.magicalBeingsResults.length===0){
        this.mbService
        .getMagicalBeingSearchKlasse(this.searchTerm)
        .subscribe(results => this.magicalBeingsResults = results);
      }
    });
  }

  goToDetail(wizard: HpWizard) {
    this.ms.sendMagicalBeing(wizard);
    this.extraService.redirectToWithTimeout('/detail')
  }


}
