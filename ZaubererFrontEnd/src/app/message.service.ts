import { Injectable } from '@angular/core';
import { BehaviorSubject } from 'rxjs';
import { Hptype } from './hptype';

@Injectable({
  providedIn: 'root'
})
export class MessageService {

  word = new BehaviorSubject<string>('');
  zaubererArray = new BehaviorSubject<Hptype[]>([]);
  potionId = new BehaviorSubject<number>(0);
  attackId = new BehaviorSubject<number>(0);
  show = new BehaviorSubject<boolean>(false);

  constructor() { }

  sendWord(word: string){
    this.word.next(word);
  }

  sendArray(array: Hptype[]){
    this.zaubererArray.next(array);
  }

  sendPotionId(id: number){
    this.potionId.next(id);
  }

  sendAttackId(id: number){
    this.attackId.next(id);
  }

  sendShow(show: boolean){
    this.show.next(show);
  }




}
