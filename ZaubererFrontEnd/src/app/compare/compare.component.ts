import { Component, OnInit } from '@angular/core';
import { FormControl, Validators } from '@angular/forms';
import { BehaviorSubject } from 'rxjs';

import { MagicalBeingService } from '../services/magical-being.service';
import { HpWizard } from '../interfaces/hp-wizard';

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
  getMagicalBeingId: FormControl = new FormControl(1);
  numberOfRating: FormControl = new FormControl(0);
  show1 = new BehaviorSubject<boolean>(true);
  show2 = new BehaviorSubject<boolean>(true);

  magicalBeings: HpWizard[] = [];
  magicalBeingChoiceA?: HpWizard;
  magicalBeingChoiceB?: HpWizard;


  constructor(
    private mbService: MagicalBeingService,
  ) {}


  ngOnInit(): void {
    this.mbService.getMagicalBeings().subscribe((element) => {
      this.magicalBeings = element;
      this.getMagicalBeingAByName();
      this.getMagicalBeingBByName();
      this.magicalBeingChoiceA = this.magicalBeings[0];
      this.magicalBeingChoiceB = this.magicalBeings[0];
    });
  }

  getMagicalBeingAByName() {
    let id = (<HTMLInputElement>document.getElementById('magicalBeingUpdateA'))
      .value as unknown as number;

    if (!id) {
      id = this.magicalBeings[0].id;
    }

    this.choiceA = new FormControl(id);
    this.getMagicalBeingAById();
  }

  getMagicalBeingBByName() {
    let id = (<HTMLInputElement>document.getElementById('magicalBeingUpdateB'))
      .value as unknown as number;

    if (!id) {
      id = this.magicalBeings[0].id;
    }

    this.choiceB = new FormControl(id);
    this.getWizardBById();
  }

  getMagicalBeingAById() {
    this.mbService.getMagicalBeingById(this.choiceA.value).subscribe((mb) => {
      this.magicalBeingChoiceA = mb;
      this.show1.next(true);
    });
    console.log(this.choiceA);
  }

  getWizardBById() {
    this.mbService.getMagicalBeingById(this.choiceB.value).subscribe((mb) => {
      this.magicalBeingChoiceB = mb;
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
