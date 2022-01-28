import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { HpMagicalBeing } from '../interfaces/hp-magical-being';

const url: string = 'http://localhost:8080/giant';

@Injectable({
  providedIn: 'root'
})
export class GiantService {

  constructor(private http: HttpClient) {}

  postGiant(body:HpMagicalBeing, house: string){
    if(house === 'Half Giant'){
      house = 'halfGiant'
    }
    const stringLowercase = house.charAt(0).toLowerCase() + house.slice(1);
    const urlGiant = url + '/' + stringLowercase;
    return this.http.post<HpMagicalBeing>(urlGiant, body);
  }

 
}
