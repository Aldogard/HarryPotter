import { Component, OnInit } from '@angular/core';
import { HpQuestion } from '../interfaces/hp-question';
import { MessageService } from '../services/message.service';
import { QuizService } from '../services/quiz.service';

@Component({
  selector: 'app-quiz',
  templateUrl: './quiz.component.html',
  styleUrls: ['./quiz.component.css']
})
export class QuizComponent implements OnInit {
  questions: HpQuestion[] = [];
  show = this.ms.showQuiz.value;

  constructor(private qs: QuizService, private ms: MessageService) { }

  ngOnInit(): void {
    this.qs.getQuestions().subscribe(q => {
      this.questions = q;
      this.qs.deleteQuestions().subscribe();
    })
    


  }

}
