import { Component, OnInit } from '@angular/core';
import { Question } from '../interfaces/hp-question';
import { QuizService } from '../services/quiz.service';

@Component({
  selector: 'app-warmup',
  templateUrl: './warmup.component.html',
  styleUrls: ['./warmup.component.css']
})
export class WarmupComponent implements OnInit {
  questions: Question[] = [];
  randomQuestions: Question[] = [];

  constructor(private qs: QuizService) { }

  ngOnInit(): void {
    this.qs.getQuestions().subscribe(q => {
      this.questions = q;
      let sample = q;
      for(var i = 0; i < 3; i++){
        let random = Math.floor(Math.random() * sample.length);
        this.randomQuestions.push(sample[random]);
        console.log(sample[random]);
        sample.splice(random);

      }
      this.qs.deleteQuestions().subscribe();
    })

  }

}
