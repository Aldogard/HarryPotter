import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormControl, Validators } from '@angular/forms';
import { BehaviorSubject } from 'rxjs';
import { ExtraService } from '../extra.service';
import { HarrypotterService } from '../harrypotter.service';
import { HpWizard } from '../hp-wizard';
import { MessageService } from '../message.service';

@Component({
  selector: 'app-compare',
  templateUrl: './compare.component.html',
  styleUrls: ['./compare.component.css']
})
export class CompareComponent implements OnInit {
  choiceA: FormControl = new FormControl(1);
  choiceB: FormControl = new FormControl(1);
  choiceRating: FormControl = new FormControl(1);
  stars: FormControl = new FormControl('', [Validators.required]);
  getZaubererId: FormControl = new FormControl(1);
  numberOfRating: FormControl = new FormControl(0);
  show1 = new BehaviorSubject<boolean>(true);
  show2 = new BehaviorSubject<boolean>(true);

  wizards: HpWizard[] = [];
  wizardChoiceA?: HpWizard;
  wizardChoiceB?: HpWizard;


  constructor(
    private hpService: HarrypotterService,
    private zusatzService: ExtraService,
    private fb: FormBuilder,
    private mss: MessageService
  ) {}


  ngOnInit(): void {
    this.hpService.getWizards().subscribe((element) => {
      this.wizards = element;
      this.getWizardAByName();
      this.getWizardBByName();
      this.wizardChoiceA = this.wizards[0];
      this.wizardChoiceB = this.wizards[0];
    });
  }

  getWizardAByName() {
    let id = (<HTMLInputElement>document.getElementById('wizardUpdateA'))
      .value as unknown as number;

    if (!id) {
      id = this.wizards[0].id;
    }

    this.choiceA = new FormControl(id);
    this.getWizardAById();
  }

  getWizardBByName() {
    let id = (<HTMLInputElement>document.getElementById('wizardUpdateB'))
      .value as unknown as number;

    if (!id) {
      id = this.wizards[0].id;
    }

    this.choiceB = new FormControl(id);
    this.getWizardBById();
  }

  getWizardAById() {
    this.hpService.getWizardById(this.choiceA.value).subscribe((zauberer) => {
      this.wizardChoiceA = zauberer;
      this.show1.next(true);
    });
    console.log(this.choiceA);
  }

  getWizardBById() {
    this.hpService.getWizardById(this.choiceB.value).subscribe((zauberer) => {
      this.wizardChoiceB = zauberer;
      this.show2.next(true);
    });
    console.log(this.choiceB);
  }

  showHide1(status: boolean) {
    this.show1.next(status);
  }

  showHide2(status: boolean) {
    this.show2.next(status);
  }

  gotoRanks() {
    window.open('ranks');
    //this.zusatzService.redirectTo('attackdetail');
  }


}
