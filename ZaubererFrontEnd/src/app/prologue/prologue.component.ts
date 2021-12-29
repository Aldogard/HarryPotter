import { Component, OnInit } from '@angular/core';
import { FormControl, Validators } from '@angular/forms';
import { BehaviorSubject } from 'rxjs';
import { HarrypotterService } from '../harrypotter.service';
import { HpWizard } from '../hp-wizard';
import { MessageService } from '../message.service';
import { ExtraService } from '../extra.service';

@Component({
  selector: 'app-fight',
  templateUrl: './prologue.component.html',
  styleUrls: ['./prologue.component.css'],
})
export class PrologueComponent implements OnInit {
  zauberer: HpWizard[] = [];

  wizardChoiceA?: HpWizard;
  choiceA = new FormControl('');
  wizardChoiceB?: HpWizard;
  choiceB = new FormControl('');
  wizardChoiceC?: HpWizard;
  choiceC = new FormControl('');
  wizardChoiceD?: HpWizard;
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
    private hpService: HarrypotterService,
    private extraService: ExtraService,
    private ms: MessageService
  ) {}

  ngOnInit(): void {
    this.environment =
      this.extraService.environment[
        Math.floor(Math.random() * this.extraService.environment.length)
      ];
    this.ms.sendEnvironment(this.environment);
    this.hpService.getWizards().subscribe((wizards) => {
      this.zauberer = wizards;
      this.choiceA = new FormControl(wizards[0].id);
      this.choiceB = new FormControl(wizards[0].id);
      this.choiceC = new FormControl(wizards[0].id);
      this.choiceD = new FormControl(wizards[0].id);
      this.wizardChoiceA = wizards[0];
      this.wizardChoiceB = wizards[0];
      this.wizardChoiceC = wizards[0];
      this.wizardChoiceD = wizards[0];
    });
  }


  getWizardAByName() {
    let id = (<HTMLInputElement>document.getElementById('wizardUpdateA'))
      .value as unknown as number;

    if (!id) {
      id = this.zauberer[0].id;
    }

    this.choiceA = new FormControl(id);
    this.getWizardAById();
  }

  getWizardAById() {
    this.hpService.getWizardById(this.choiceA.value).subscribe((wizard) => {
      this.wizardChoiceA = wizard;
      this.show2.next(true);
    });
  }

  getWizardBByName() {
    let id = (<HTMLInputElement>document.getElementById('wizardUpdateB'))
      .value as unknown as number;

    if (!id) {
      id = this.zauberer[1].id;
    }

    this.choiceB = new FormControl(id);
    this.getWizardBById();
  }

  getWizardBById() {
    this.hpService.getWizardById(this.choiceB.value).subscribe((wizard) => {
      this.wizardChoiceB = wizard;
      this.show2.next(true);

    });
  }

  getWizardCByName() {
    let id = (<HTMLInputElement>document.getElementById('wizardUpdateC'))
      .value as unknown as number;

    if (!id) {
      id = this.zauberer[2].id;
    }

    this.choiceC = new FormControl(id);
    this.getWizardCById();
  }

  getWizardCById() {
    this.hpService.getWizardById(this.choiceC.value).subscribe((wizard) => {
      this.wizardChoiceC = wizard;
      this.show3.next(true);

    });
  }

  getWizardDByName() {
    let id = (<HTMLInputElement>document.getElementById('wizardUpdateD'))
      .value as unknown as number;

    if (!id) {
      id = this.zauberer[3].id;
    }

    this.choiceD = new FormControl(id);
    this.getWizardDById();
  }

  getWizardDById() {
    this.hpService.getWizardById(this.choiceD.value).subscribe((wizard) => {
      this.wizardChoiceD = wizard;
      this.show4.next(true);

    });
  }
  send2() {
    let participants = [];
    if (
      this.wizardChoiceA !== undefined &&
      this.wizardChoiceB !== undefined
    ) {
      participants.push(this.wizardChoiceA);
      if (this.wizardChoiceB.id !== this.wizardChoiceA.id) {
        participants.push(this.wizardChoiceB);
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
      this.wizardChoiceA !== undefined &&
      this.wizardChoiceB !== undefined &&
      this.wizardChoiceC !== undefined
    ) {
      participants.push(this.wizardChoiceA);
      if (this.wizardChoiceB.id !== this.wizardChoiceA.id) {
        participants.push(this.wizardChoiceB);
      }
      if (
        this.wizardChoiceC.id !== this.wizardChoiceA.id &&
        this.wizardChoiceC.id !== this.wizardChoiceB.id
      ) {
        participants.push(this.wizardChoiceC);
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
      this.wizardChoiceA !== undefined &&
      this.wizardChoiceB !== undefined &&
      this.wizardChoiceC !== undefined &&
      this.wizardChoiceD !== undefined
    ) {
      participants.push(this.wizardChoiceA);
      if (this.wizardChoiceB.id !== this.wizardChoiceA.id) {
        participants.push(this.wizardChoiceB);
      }
      if (
        this.wizardChoiceC.id !== this.wizardChoiceA.id &&
        this.wizardChoiceC.id !== this.wizardChoiceB.id
      ) {
        participants.push(this.wizardChoiceC);
      }
      if (
        this.wizardChoiceD.id !== this.wizardChoiceA.id &&
        this.wizardChoiceD.id !== this.wizardChoiceB.id &&
        this.wizardChoiceD.id !== this.wizardChoiceC.id
      ) {
        participants.push(this.wizardChoiceD);
      }
    }

    if (participants.length !== 4) {
      alert('Please select different Wizards');
    } else {
      this.gotoRules(participants);
    }
  }

  gotoRules(particitpants: HpWizard[]){
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
