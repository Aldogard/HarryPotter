import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable, of } from 'rxjs';
import { HpSpell } from './hp-spell';
import { HpPotion } from './hp-potion';
import { HpWizard } from './hp-wizard';
import { HpAnimal } from './hp-animal';
const url: string = 'http://localhost:8080/wizard';

@Injectable({
  providedIn: 'root',
})
export class HarrypotterService {
  constructor(private http: HttpClient) {}

  getWizards(): Observable<HpWizard[]> {
    return this.http.get<HpWizard[]>(url);
  }

  getWizardById(id: number): Observable<HpWizard> {
    const urlId: string = url + '/' + id;
    return this.http.get<HpWizard>(urlId);
  }

  getWizardByName(name: string): Observable<HpWizard> {
    const urlName: string = url + '/name/' + name;
    return this.http.get<HpWizard>(urlName);
  }

  postWizard(body: HpWizard, house: string){
    if(house === 'Potions Master'){
      house = 'potionsmaster'
    }
    const stringLowercase = house.charAt(0).toLowerCase() + house.slice(1);
    const urlWizard = url + '/' + stringLowercase;
    console.log(urlWizard);
    return this.http.post<HpWizard>(urlWizard, body);
  }

  deleteWizard(id: number): Observable<unknown> {
    const urlId: string = url + '/' + id;
    return this.http.delete(urlId);
  }

  updateWizard(body: HpWizard, id: number) {
    const urlUpdate = url + '/' + id 
    return this.http.put<HpWizard>(urlUpdate, body);
  }

  deleteAllWizards() {
    const urlDelAll = url + '/deleteall';
    return this.http.delete(urlDelAll);
  }

  getPin() {
    const urlNr = url + '/pin';
    return this.http.get<number>(urlNr);
  }

  postComment(body: string, id: number) {
    const urlCom = url + '/comment/' + id;
    return this.http.post<string>(urlCom, body);
  }

  getQuote() {
    const urlQuote = url + '/quote';
    return this.http.get(urlQuote, { responseType: 'text' });
  }

  postRating(body: HpWizard, id: number) {
    const urlRating = url + '/rating/' + id;
    return this.http.put<HpWizard>(urlRating, body);
  }

  getWizardSearch(search: string) {
    let urlSearch = url + '/?name=' + search;
    let answer = this.http.get<HpWizard[]>(urlSearch);
    return answer;
  }

  getWizardSearchKlasse(search: string) {
    let urlSearch = url + '/?klasse=' + search;
    let answer = this.http.get<HpWizard[]>(urlSearch);
    return answer;
  }


  getHealthpointsMax(max: number) {
    let urlSearch = url + '/hp/?max=' + max;
    let answer = this.http.get<HpWizard[]>(urlSearch);
    return answer;
  }


  getHealthpointsMin(min: number) {
    let urlSearch = url + '/hp/?min=' + min;
    let answer = this.http.get<HpWizard[]>(urlSearch);
    return answer;
  }

  getVictoriesMin(min: number){
    let urlSearch = url + '/victory/?victories=' + min;
    let answer = this.http.get<HpWizard[]>(urlSearch);
    return answer;
  }

  getVoldemort(){
    const urlVoldemort = url + '/voldemort';
    return this.http.get<HpWizard>(urlVoldemort);
  }

  updateVictories(body: HpWizard){
    const urlVictory = url + '/victory';
    return this.http.put<HpWizard>(urlVictory, body);
  }

  getPotionById(id: number){
    const urlPotionId = url + '/potion/' + id;
    return this.http.get<HpPotion>(urlPotionId);
  }

  getAttackById(id: number){
    const urlAttackId = url + '/attack/' + id;
    return this.http.get<HpSpell>(urlAttackId);
  }

  getAnimalById(id: number){
    const urlAnimalId = url + '/animal/' + id;
    return this.http.get<HpAnimal>(urlAnimalId);
  }


}
