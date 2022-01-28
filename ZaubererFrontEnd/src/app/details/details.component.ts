import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormControl, Validators } from '@angular/forms';
import { BehaviorSubject } from 'rxjs';
import { ExtraService } from '../services/extra.service';
import { MessageService } from '../services/message.service';
import { MagicalBeingService } from '../services/magical-being.service';
import { HpMagicalBeing } from '../interfaces/hp-magical-being';

@Component({
  selector: 'app-details',
  templateUrl: './details.component.html',
  styleUrls: ['./details.component.css'],
})
export class DetailsComponent implements OnInit {
  choiceA: FormControl = new FormControl(1);
  choiceRating: FormControl = new FormControl(1);
  stars: FormControl = new FormControl('', [Validators.required]);
  getMagicalBeingId: FormControl = new FormControl(1);
  numberOfRating: FormControl = new FormControl(0);
  show1 = new BehaviorSubject<boolean>(true);

  showSaw = new BehaviorSubject<boolean>(true);
  showPotions = new BehaviorSubject<boolean>(true);
  showSpells = new BehaviorSubject<boolean>(true);
  showAnimals= new BehaviorSubject<boolean>(true);
  showComments = new BehaviorSubject<boolean>(true);


  idForComment: number = 0;
  idForRating: number = 0;

  magicalBeingChoiceA?: HpMagicalBeing;
  availableStars: number[] = [1, 2, 3, 4, 5];
  magicalBeings: HpMagicalBeing[] = [];

  magicalBeingMs?: HpMagicalBeing;
  magicalBeingsFirstPart: HpMagicalBeing[] = [];
  magicalBeingsSecondPart: HpMagicalBeing[] = [];

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
    private mbService: MagicalBeingService,
    private fb: FormBuilder,
    private ms: MessageService,
    private extraService: ExtraService,
  ) {}

  ngOnInit(): void {
    this.mbService.getMagicalBeings().subscribe((element) => {
      this.magicalBeings = element;
      this.magicalBeingMs = this.ms.magicalBeing;
      this.ms.sendMagicalBeing(undefined);
      this.getMagicalBeingAByName();
      this.getMagicalBeingByNameComment();
      this.getMagicalBeingByNameRating();
      this.magicalBeingChoiceA = this.magicalBeings[0];
    });
  }

  getMagicalBeingAByNameAndUndefined(){
    this.magicalBeingMs = undefined;
    this.getMagicalBeingAByName();
  }

  getMagicalBeingAByName() {
    let id = (<HTMLInputElement>document.getElementById('wizardUpdateA'))
      .value as unknown as number;

    if (!id) {
      id = this.magicalBeings[0].id;
    }
    if(this.magicalBeingMs !==undefined){
      id = this.magicalBeingMs.id;
    } 

    this.choiceA = new FormControl(id);
    this.getMagicalBeingAById();
  }

  getMagicalBeingAById() {
    this.mbService.getMagicalBeingById(this.choiceA.value).subscribe((mb) => {
      this.magicalBeingChoiceA = mb;
      this.show1.next(true);
    });
  }

  showHide1(status: boolean) {
    this.show1.next(status);
  }

  showHideSaw(status:boolean){
    this.showSaw.next(status);
  }

  showHideSpells(status:boolean){
    this.showSpells.next(status);
  }

  showHidePotions(status:boolean){
    this.showPotions.next(status);
  }

  showHideAnimals(status:boolean){
    this.showAnimals.next(status);
  }

  showHideComments(status:boolean){
    this.showComments.next(status);
  }


  post() {
    const response = this.mbService.postComment(
      this.commentForm.value,
      this.idForComment
    );
    response.subscribe((x) => {
      this.commentForm = this.fb.group({
        content: [
          '',
          [
            Validators.required,
            Validators.minLength(10),
            Validators.maxLength(100),
          ],
        ],
      });
    });
    this.extraService.redirectTo('detail');
  }

  getMagicalBeingByNameComment() {
    this.idForComment = (<HTMLInputElement>(
      document.getElementById('wizardComment')
    )).value as unknown as number;

    if (!this.idForComment) {
      this.idForComment = this.magicalBeings[0].id;
    }
  }

  getMagicalBeingByNameRating() {
    this.idForRating = (<HTMLInputElement>(
      document.getElementById('wizardIdRating')
    )).value as unknown as number;
    if (!this.idForRating) {
      this.idForRating = this.magicalBeings[0].id;
    }
  }

  getRating() {
    let currentAmount: number = 0;
    this.mbService.getMagicalBeingById(this.idForRating).subscribe((x) => {
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
    const response = this.mbService.postRating(
      this.ratingForm.value,
      this.idForRating
    );
    response.subscribe((x) => {
      this.stars.setValue('');
    });
    this.extraService.redirectTo('detail');
  }

  gotoPotionDetail(potionId: number) {
    this.ms.sendPotionId(potionId);
    const url = 'potiondetail/' + potionId;
    window.open(url);
    //this.zusatzService.redirectTo('potiondetail');
  }

  gotoSpellDetail(attackId: number) {
    this.ms.sendAttackId(attackId);
    const url = 'spelldetail/' + attackId;
    window.open(url);
    //this.zusatzService.redirectTo('attackdetail');
  }

  gotoAnimalDetail(animalId: number) {
    this.ms.sendAnimalId(animalId);
    const url = 'animaldetail/' + animalId;
    window.open(url);
    //this.zusatzService.redirectTo('attackdetail');
  }

  gotoRanks() {
    window.open('ranks');
    //this.zusatzService.redirectTo('attackdetail');
  }
}
