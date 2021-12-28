import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormControl, Validators } from '@angular/forms';
import { BehaviorSubject } from 'rxjs';
import { HarrypotterService } from '../harrypotter.service';
import { HpWizard } from '../hp-wizard';
import { MessageService } from '../message.service';
import { ExtraService } from '../extra.service';

@Component({
  selector: 'app-details',
  templateUrl: './details.component.html',
  styleUrls: ['./details.component.css'],
})
export class DetailsComponent implements OnInit {
  choiceA: FormControl = new FormControl(1);
  choiceB: FormControl = new FormControl(1);
  choiceRating: FormControl = new FormControl(1);
  stars: FormControl = new FormControl('', [Validators.required]);
  getZaubererId: FormControl = new FormControl(1);
  numberOfRating: FormControl = new FormControl(0);
  show1 = new BehaviorSubject<boolean>(true);
  show2 = new BehaviorSubject<boolean>(true);

  idForComment: number = 0;
  idForRating: number = 0;

  wizardChoiceA?: HpWizard;
  wizardChoiceB?: HpWizard;
  availableStars: number[] = [1, 2, 3, 4, 5];

  wizards: HpWizard[] = [];
  commentForm = this.fb.group({
    content: [
      '',
      [
        Validators.required,
        Validators.minLength(10),
        Validators.maxLength(100),
      ],
    ],
  });
  ratingForm = this.fb.group({});

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
      this.getWizardByNameComment();
      this.getWizardByNameRating();
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

  post() {
    const response = this.hpService.postComment(this.commentForm.value, this.idForComment);
    response.subscribe((x) => {
      this.zusatzService.redirectTo('detail');
    });
  }

  getWizardByNameComment() {
    this.idForComment = (<HTMLInputElement>(
      document.getElementById('wizardComment')
    )).value as unknown as number;

    if (!this.idForComment) {
      this.idForComment = this.wizards[0].id;
    }
  }

  getWizardByNameRating() {
    this.idForRating = (<HTMLInputElement>document.getElementById('wizardIdRating'))
      .value as unknown as number;

    if (!this.idForRating) {
      this.idForRating = this.wizards[0].id;
    }

  }

  getRating() {
    let currentAmount: number = 0;
    this.hpService.getWizardById(this.idForRating).subscribe((x) => {
      currentAmount = x.amount + 1;
      this.numberOfRating = new FormControl(currentAmount);
      const newRating: number =
        (x.amount * x.rating + 1 * this.stars.value) / currentAmount;
      const newRatingRound = Math.round(newRating * 100) / 100;
      const newRatingFC = new FormControl(newRatingRound);

      this.ratingForm = this.fb.group({
        name: x.name,
        healthPoints: x.healthPoints,
        description: x.description,
        rating: newRatingFC,
        amount: this.numberOfRating,
      });
    });
  }

  passOnRating() {
    const response = this.hpService.postRating(this.ratingForm.value, this.idForRating );
    response.subscribe((x) => {
      this.stars.setValue('');
    });
  }

  gotoPotionDetail(potionId: number) {
    this.mss.sendPotionId(potionId);
    const url = 'potiondetail/' + potionId;
    window.open(url);
    //this.zusatzService.redirectTo('potiondetail');
  }

  gotoSpellDetail(attackId: number) {
    this.mss.sendAttackId(attackId);
    const url = 'spelldetail/' + attackId;
    window.open(url);
    //this.zusatzService.redirectTo('attackdetail');
  }

  gotoRanks() {
    window.open('ranks');
    //this.zusatzService.redirectTo('attackdetail');
  }


}
