import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { HpAnimal } from "../interfaces/hp-animal";
import { HpPotion } from "../interfaces/hp-potion";
import { HpSpell } from "../interfaces/hp-spell";
import { HpMagicalBeing } from '../interfaces/hp-magical-being';
import { HpMelee } from '../interfaces/hp-melee';

const url: string = 'http://localhost:8080/mb';

@Injectable({
  providedIn: 'root'
})
export class MagicalBeingService {

  constructor(private http: HttpClient) {}


  getMagicalBeings(){
    return this.http.get<HpMagicalBeing[]>(url);
  }

  getMagicalBeingById(id: number) {
    const urlId: string = url + '/' + id;
    return this.http.get<HpMagicalBeing>(urlId);
  }

  getMagicalBeingByName(name: string) {
    const urlName: string = url + '/name/' + name;
    return this.http.get<HpMagicalBeing>(urlName);
  }

  deleteMagicalBeing(id: number) {
    const urlId: string = url + '/' + id;
    return this.http.delete(urlId);
  }

  updateMagicalBeing(body: HpMagicalBeing, id: number) {
    const urlUpdate = url + '/' + id 
    return this.http.put<HpMagicalBeing>(urlUpdate, body);
  }

  deleteAllMagicalBeings() {
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

  postRating(body: HpMagicalBeing, id: number) {
    const urlRating = url + '/rating/' + id;
    return this.http.put<HpMagicalBeing>(urlRating, body);
  }

  getMagicalBeingSearch(search: string) {
    let urlSearch = url + '/?name=' + search;
    let answer = this.http.get<HpMagicalBeing[]>(urlSearch);
    return answer;
  }

  getMagicalBeingSearchKlasse(search: string) {
    let urlSearch = url + '/?klasse=' + search;
    let answer = this.http.get<HpMagicalBeing[]>(urlSearch);
    return answer;
  }

  getMagicalBeingSearchSpecies(species: string) {
    let urlSearchSpecies = url + '/?species=' + species;
    let answer = this.http.get<HpMagicalBeing[]>(urlSearchSpecies);
    return answer;
  }


  getHealthpointsMax(max: number) {
    let urlSearch = url + '/hp/?max=' + max;
    let answer = this.http.get<HpMagicalBeing[]>(urlSearch);
    return answer;
  }


  getHealthpointsMin(min: number) {
    let urlSearch = url + '/hp/?min=' + min;
    let answer = this.http.get<HpMagicalBeing[]>(urlSearch);
    return answer;
  }

  getVictoriesMin(min: number){
    let urlSearch = url + '/victory/?victories=' + min;
    let answer = this.http.get<HpMagicalBeing[]>(urlSearch);
    return answer;
  }

  getVoldemort(){
    const urlVoldemort = url + '/voldemort';
    return this.http.get<HpMagicalBeing>(urlVoldemort);
  }

  updateVictories(body: HpMagicalBeing){
    const urlVictory = url + '/victory';
    return this.http.put<HpMagicalBeing>(urlVictory, body);
  }

  updateVictoriesChess(body: HpMagicalBeing){
    console.log("Check")
    console.log(body.victoriesChess);
    const urlVictoryChess = url + '/victorychess';
    return this.http.put<HpMagicalBeing>(urlVictoryChess, body);
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

  getMeleeById(id: number){
    const urlMeleeId = url + '/melee/' + id;
    return this.http.get<HpMelee>(urlMeleeId);
  }
 
}
