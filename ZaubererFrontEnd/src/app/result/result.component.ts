import { Component, OnInit } from '@angular/core';
import { FormControl } from '@angular/forms';
import { ExtraService } from '../extra.service';
import { HarrypotterService } from '../harrypotter.service';
import { HpWizard } from '../hp-wizard';
import { MessageService } from '../message.service';

@Component({
  selector: 'app-search',
  templateUrl: './result.component.html',
  styleUrls: ['./result.component.css'],
})
export class ResultComponent implements OnInit {
  wizards: HpWizard[] = [];
  wizardsResults: HpWizard[] = [];
  searchTerm: string = '';

  constructor(
    private hpService: HarrypotterService,
    private ms: MessageService,
    private extraService: ExtraService,
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

  goToDetail(wizard: HpWizard) {
    this.ms.sendWizard(wizard);
    this.extraService.redirectToWithTimeout('/detail')
  }


}
