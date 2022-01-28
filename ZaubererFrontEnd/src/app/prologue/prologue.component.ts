import { Component, OnInit } from '@angular/core';
import { FormControl, Validators } from '@angular/forms';
import { BehaviorSubject } from 'rxjs';
import { MessageService } from '../services/message.service';
import { ExtraService } from '../services/extra.service';
import { MagicalBeingService } from '../services/magical-being.service';
import { HpMagicalBeing } from '../interfaces/hp-magical-being';

@Component({
  selector: 'app-fight',
  templateUrl: './prologue.component.html',
  styleUrls: ['./prologue.component.css'],
})
export class PrologueComponent implements OnInit {
  magicalBeings: HpMagicalBeing[] = [];

  magicalBeingChoiceA?: HpMagicalBeing;
  choiceA = new FormControl('');
  magicalBeingChoiceB?: HpMagicalBeing;
  choiceB = new FormControl('');
  magicalBeingChoiceC?: HpMagicalBeing;
  choiceC = new FormControl('');
  magicalBeingChoiceD?: HpMagicalBeing;
  choiceD = new FormControl('');
  show2 = new BehaviorSubject<boolean>(false);
  show3 = new BehaviorSubject<boolean>(false);
  show4 = new BehaviorSubject<boolean>(false);
  environment: string = '';


  numberOfParticipants = new FormControl('', [
    Validators.required,
    Validators.min(1),
    Validators.max(3),
  ]);
  battleSize = this.extraService.battleSize;

  constructor(
    private mbService: MagicalBeingService,
    private extraService: ExtraService,
    private ms: MessageService
  ) {}

  ngOnInit(): void {
    this.environment =
      this.extraService.environment[
        Math.floor(Math.random() * this.extraService.environment.length)
      ];
    this.ms.sendEnvironment(this.environment);
    this.mbService.getMagicalBeings().subscribe((mb) => {
      this.magicalBeings = mb;
      // this.choiceA = new FormControl(wizards[0].id);
      // this.choiceB = new FormControl(wizards[0].id);
      // this.choiceC = new FormControl(wizards[0].id);
      // this.choiceD = new FormControl(wizards[0].id);
      this.magicalBeingChoiceA = mb[0];
      this.magicalBeingChoiceB = mb[0];
      this.magicalBeingChoiceC = mb[0];
      this.magicalBeingChoiceD = mb[0];
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
    this.mbService.getMagicalBeingById(this.choiceA.value).subscribe((wizard) => {
      this.magicalBeingChoiceA = wizard;
      this.show2.next(true);
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
    this.mbService.getMagicalBeingById(this.choiceB.value).subscribe((wizard) => {
      this.magicalBeingChoiceB = wizard;
      this.show2.next(true);

    });
  }

  getMagicalBeingCByName() {
    let id = (<HTMLInputElement>document.getElementById('wizardUpdateC'))
      .value as unknown as number;

    if (!id) {
      id = this.magicalBeings[2].id;
    }

    this.choiceC = new FormControl(id);
    this.getMagicalBeingCById();
  }

  getMagicalBeingCById() {
    this.mbService.getMagicalBeingById(this.choiceC.value).subscribe((wizard) => {
      this.magicalBeingChoiceC = wizard;
      this.show3.next(true);

    });
  }

  getMagicalBeingDByName() {
    let id = (<HTMLInputElement>document.getElementById('wizardUpdateD'))
      .value as unknown as number;

    if (!id) {
      id = this.magicalBeings[3].id;
    }

    this.choiceD = new FormControl(id);
    this.getMagicalBeingDById();
  }

  getMagicalBeingDById() {
    this.mbService.getMagicalBeingById(this.choiceD.value).subscribe((wizard) => {
      this.magicalBeingChoiceD = wizard;
      this.show4.next(true);

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
    if (participants.length !== 2) {
      alert('Please select different Wizards');
    } else {
      this.gotoRules(participants);
    }
  }

  send3() {
    let participants = [];
    if (
      this.magicalBeingChoiceA !== undefined &&
      this.magicalBeingChoiceB !== undefined &&
      this.magicalBeingChoiceC !== undefined
    ) {
      participants.push(this.magicalBeingChoiceA);
      if (this.magicalBeingChoiceB.id !== this.magicalBeingChoiceA.id) {
        participants.push(this.magicalBeingChoiceB);
      }
      if (
        this.magicalBeingChoiceC.id !== this.magicalBeingChoiceA.id &&
        this.magicalBeingChoiceC.id !== this.magicalBeingChoiceB.id
      ) {
        participants.push(this.magicalBeingChoiceC);
      }
    }

    if (participants.length !== 3) {
      alert('Please select different Wizards');
    } else {
      this.gotoRules(participants);
    }
  }

  send4() {
    let participants = [];
    if (
      this.magicalBeingChoiceA !== undefined &&
      this.magicalBeingChoiceB !== undefined &&
      this.magicalBeingChoiceC !== undefined &&
      this.magicalBeingChoiceD !== undefined
    ) {
      participants.push(this.magicalBeingChoiceA);
      if (this.magicalBeingChoiceB.id !== this.magicalBeingChoiceA.id) {
        participants.push(this.magicalBeingChoiceB);
      }
      if (
        this.magicalBeingChoiceC.id !== this.magicalBeingChoiceA.id &&
        this.magicalBeingChoiceC.id !== this.magicalBeingChoiceB.id
      ) {
        participants.push(this.magicalBeingChoiceC);
      }
      if (
        this.magicalBeingChoiceD.id !== this.magicalBeingChoiceA.id &&
        this.magicalBeingChoiceD.id !== this.magicalBeingChoiceB.id &&
        this.magicalBeingChoiceD.id !== this.magicalBeingChoiceC.id
      ) {
        participants.push(this.magicalBeingChoiceD);
      }
    }

    if (participants.length !== 4) {
      alert('Please select different Wizards');
    } else {
      this.gotoRules(participants);
    }
  }

  gotoRules(particitpants: HpMagicalBeing[]){
    this.ms.sendArray(particitpants);
    this.ms.sendShow(true);
    this.extraService.redirectTo('rules');
  }

  gotoDetails(){
    window.open('detail');
  }

  gotoWiki(){
    window.open('https://harrypotter.fandom.com/wiki/Main_Page');
  }



}
