import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { HpDummy } from '../interfaces/hp-dummy';

const url: string = 'http://localhost:8080/dummy';

@Injectable({
  providedIn: 'root',
})
export class DummyService {
  constructor(private http: HttpClient) {}

  getDummyByName(name: string) {
    const urlName: string = url + '/name/' + name;
    return this.http.get<HpDummy>(urlName);
  }

  deleteDummy() {
    const urlDeleteDummy = url + '//deleteall';
    return this.http.delete(urlDeleteDummy);
  }

  postDummy(body: HpDummy){
    return this.http.post<HpDummy>(url, body);
  }
}
