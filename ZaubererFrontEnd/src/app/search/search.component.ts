import { Component, OnInit } from '@angular/core';
import { FormControl } from '@angular/forms';
import { HarrypotterService } from '../harrypotter.service';
import { Hptype } from '../hptype';
import { MessageService } from '../message.service';

@Component({
  selector: 'app-search',
  templateUrl: './search.component.html',
  styleUrls: ['./search.component.css'],
})
export class SearchComponent implements OnInit {
  wizards: Hptype[] = [];
  wizardsResults: Hptype[] = [];
  searchTerm: string = '';

  constructor(
    private hpService: HarrypotterService,
    private ms: MessageService
  ) {}

  ngOnInit(): void {
    this.hpService
      .getWizards()
      .subscribe((element) => (this.wizards = element));
      
    this.ms.word.subscribe((search) => {
      this.searchTerm = search;
      this.hpService
        .getWizardSearch(this.searchTerm)
        .subscribe((results) => (this.wizardsResults = results));
      if(this.wizardsResults.length===0){
        this.hpService
        .getWizardSearchKlasse(this.searchTerm)
        .subscribe(results => this.wizardsResults = results);
      }
    });
  }
}
