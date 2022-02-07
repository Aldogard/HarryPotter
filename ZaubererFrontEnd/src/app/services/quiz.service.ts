import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { HpQuestion } from '../interfaces/hp-question';

const url: string = 'http://localhost:8080/quiz';

@Injectable({
  providedIn: 'root'
})
export class QuizService {

  constructor(private http: HttpClient) {}

  getQuestions(){
    return this.http.get<HpQuestion[]>(url);
  }

  deleteQuestions(){
    return this.http.delete(url);
  }

  postQuestion(){
    return this.http.post(url, null);
  }

}
