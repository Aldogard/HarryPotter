import { Component, OnInit } from '@angular/core';
import { FormControl } from '@angular/forms';
import { ExtraService } from '../services/extra.service';
import { HpMagicalBeing } from '../interfaces/hp-magical-being';
import { MagicalBeingService } from '../services/magical-being.service';
import { MessageService } from '../services/message.service';

@Component({
  selector: 'app-preparation',
  templateUrl: './preparation.component.html',
  styleUrls: ['./preparation.component.css'],
})
export class PreparationComponent implements OnInit {
  magicalBeings: HpMagicalBeing[] = [];
  magicalBeingChoiceA?: HpMagicalBeing;
  choiceA = new FormControl('');
  magicalBeingChoiceB?: HpMagicalBeing;
  choiceB = new FormControl('');

  constructor(
    private mbService: MagicalBeingService,
    private extraService: ExtraService,
    private ms: MessageService,
  ) {}

  ngOnInit(): void {
    this.mbService.getMagicalBeings().subscribe((mb) => {
      this.magicalBeings = mb;
      this.magicalBeingChoiceA = mb[0];
      this.magicalBeingChoiceB = mb[0];
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

  getMagicalBeingBByName() {
    let id = (<HTMLInputElement>document.getElementById('wizardUpdateB'))
      .value as unknown as number;

    if (!id) {
      id = this.magicalBeings[1].id;
    }

    this.choiceB = new FormControl(id);
    this.getMagicalBeingBById();
  }

  getMagicalBeingBById() {
    this.mbService
      .getMagicalBeingById(this.choiceB.value)
      .subscribe((wizard) => {
        this.magicalBeingChoiceB = wizard;
      });
  }


  send2() {
    let participants = [];
    if (
      this.magicalBeingChoiceA !== undefined &&
      this.magicalBeingChoiceB !== undefined
    ) {
      participants.push(this.magicalBeingChoiceA);
      if (this.magicalBeingChoiceB.id !== this.magicalBeingChoiceA.id) {
        participants.push(this.magicalBeingChoiceB);
      }
    }
    if (participants.length === 2) {
      this.gotoInformation(participants);
    }
  }

  gotoInformation(particitpants: HpMagicalBeing[]){
    this.ms.sendArrayChess(particitpants);
    this.ms.sendShowChess(true);
    this.extraService.redirectTo('information');
  }

  gotoDetails(){
    window.open('detail');
  }

  gotoWiki(){
    window.open('https://harrypotter.fandom.com/wiki/Main_Page');
  }


}
