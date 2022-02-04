import { Component, OnInit } from '@angular/core';
import { Question } from '../interfaces/hp-question';
import { QuizService } from '../services/quiz.service';

@Component({
  selector: 'app-quiz',
  templateUrl: './quiz.component.html',
  styleUrls: ['./quiz.component.css']
})
export class QuizComponent implements OnInit {
  questions: Question[] = [];

  constructor(private qs: QuizService) { }

  ngOnInit(): void {
    this.qs.getQuestions().subscribe(q => {
      this.questions = q;
      this.qs.deleteQuestions().subscribe();
    })
    


  }

}
