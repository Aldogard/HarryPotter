import { Component, OnInit } from '@angular/core';
import { FormControl } from '@angular/forms';
import { ExtraService } from '../extra.service';
import { HpMagicalBeing } from '../hp-magical-being';
import { MagicalBeingService } from '../magical-being.service';
import { MessageService } from '../message.service';

@Component({
  selector: 'app-selection',
  templateUrl: './selection.component.html',
  styleUrls: ['./selection.component.css']
})
export class SelectionComponent implements OnInit {
  magicalBeings: HpMagicalBeing[] = [];
  magicalBeingChoiceA?: HpMagicalBeing;
  choiceA = new FormControl('');

  constructor(
    private mbService: MagicalBeingService,
    private extraService: ExtraService,
    private ms: MessageService,
  ) { }

  ngOnInit(): void {
    this.mbService.getMagicalBeings().subscribe((mb) => {
      this.magicalBeings = mb;
      this.magicalBeingChoiceA = mb[0];
    });
  }

  getMagicalBeingAByName() {
    let id = (<HTMLInputElement>document.getElementById('wizardUpdateA'))
      .value as unknown as number;

    if (!id) {
      id = this.magicalBeings[0].id;
    }

    this.choiceA = new FormControl(id);
    this.getMagicalBeingAById();
  }

  getMagicalBeingAById() {
    this.mbService
      .getMagicalBeingById(this.choiceA.value)
      .subscribe((wizard) => {
        this.magicalBeingChoiceA = wizard;
      });
  }

  send() {
    let participants = [];
    if (
      this.magicalBeingChoiceA !== undefined
    ) {
      participants.push(this.magicalBeingChoiceA);
      this.gotoTraining(participants);
    }
    
  }

  gotoTraining(particitpants: HpMagicalBeing[]){
    this.ms.sendArrayTraining(particitpants);
    this.ms.sendShowTraining(true);
    this.extraService.redirectTo('training');
  }


  gotoDetails(){
    window.open('detail');
  }

  gotoWiki(){
    window.open('https://harrypotter.fandom.com/wiki/Main_Page');
  }
}
