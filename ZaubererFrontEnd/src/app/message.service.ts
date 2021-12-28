import { Injectable } from '@angular/core';
import { BehaviorSubject } from 'rxjs';
import { HpWizard } from './hp-wizard';

@Injectable({
  providedIn: 'root'
})
export class MessageService {

  word = new BehaviorSubject<string>('');
  zaubererArray = new BehaviorSubject<HpWizard[]>([]);
  potionId = new BehaviorSubject<number>(0);
  attackId = new BehaviorSubject<number>(0);
  animalId = new BehaviorSubject<number>(0);
  show = new BehaviorSubject<boolean>(false);
  environment = new BehaviorSubject<string>('');

  constructor() { }

  sendWord(word: string){
    this.word.next(word);
  }

  sendArray(array: HpWizard[]){
    this.zaubererArray.next(array);
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

  sendShow(show: boolean){
    this.show.next(show);
  }

  sendEnvironment(environment: string){
    this.environment.next(environment);
  }




}
