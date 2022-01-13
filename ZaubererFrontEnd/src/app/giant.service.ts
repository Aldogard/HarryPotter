import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { HpMagicalBeing } from './hp-magical-being';

const url: string = 'http://localhost:8080/giant';

@Injectable({
  providedIn: 'root'
})
export class GiantService {

  constructor(private http: HttpClient) {}

  postGiant(body:HpMagicalBeing){
    return this.http.post<HpMagicalBeing>(url, body);
  }
}
