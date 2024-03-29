import { Injectable } from '@angular/core';
import { BehaviorSubject } from 'rxjs';
import { HpMagicalBeing } from '../interfaces/hp-magical-being';
import { HpQuestion } from '../interfaces/hp-question';

@Injectable({
  providedIn: 'root'
})
export class MessageService  {

  word = new BehaviorSubject<string>('');
  magicalBeingArray = new BehaviorSubject<HpMagicalBeing[]>([]);
  magicalBeingArrayChess = new BehaviorSubject<HpMagicalBeing[]>([]);
  potionId = new BehaviorSubject<number>(0);
  attackId = new BehaviorSubject<number>(0);
  animalId = new BehaviorSubject<number>(0);
  meleeId = new BehaviorSubject<number>(0);
  show = new BehaviorSubject<boolean>(false);
  showChess = new BehaviorSubject<boolean>(false);
  environment = new BehaviorSubject<string>('');
  magicalBeing?: HpMagicalBeing;
  participants = new BehaviorSubject<HpMagicalBeing[]>([]);
  showTraining = new BehaviorSubject<boolean>(false);
  showQuiz = new BehaviorSubject<boolean>(false);
  chosenQuestions = new BehaviorSubject<HpQuestion[]>([]);
  

  constructor() { }

  sendWord(word: string){
    this.word.next(word);
  }

  sendArray(array: HpMagicalBeing[]){
    this.magicalBeingArray.next(array);
  }

  sendArrayChess(array: HpMagicalBeing[]){
    this.magicalBeingArrayChess.next(array);
  }

  sendPotionId(id: number){
    this.potionId.next(id);
  }

  sendAttackId(id: number){
    this.attackId.next(id);
  }

  sendAnimalId(id: number){
    this.animalId.next(id);
  }

  sendMeleeId(id: number){
    this.meleeId.next(id);
  }

  sendShow(show: boolean){
    this.show.next(show);
  }

  sendShowChess(show: boolean){
    this.showChess.next(show);
  }

  sendEnvironment(environment: string){
    this.environment.next(environment);
  }

  sendMagicalBeing(mb: HpMagicalBeing | undefined){
    this.magicalBeing = mb;
  }

  sendArrayTraining(array: HpMagicalBeing[]){
    this.participants.next(array);
  }

  sendShowTraining(show: boolean){
    this.showTraining.next(show);
  }

  sendShowQuiz(show: boolean){
    this.showQuiz.next(show);
  }

  sendChosenQuestions(questions: HpQuestion[]){
    this.chosenQuestions.next(questions);
  }




}
