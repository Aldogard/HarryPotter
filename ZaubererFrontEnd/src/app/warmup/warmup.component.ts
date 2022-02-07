import { Component, OnInit } from '@angular/core';
import { FormControl } from '@angular/forms';
import { BehaviorSubject } from 'rxjs';
import { HpQuestion } from '../interfaces/hp-question';
import { ExtraService } from '../services/extra.service';
import { MessageService } from '../services/message.service';
import { QuizService } from '../services/quiz.service';

@Component({
  selector: 'app-warmup',
  templateUrl: './warmup.component.html',
  styleUrls: ['./warmup.component.css'],
})
export class WarmupComponent implements OnInit {
  question?: HpQuestion;
  randomQuestions: HpQuestion[] = [];
  chosenAnswer = new FormControl('');
  correct = new BehaviorSubject<boolean>(false);
  notCorrect = new BehaviorSubject<boolean>(false);
  correctAnswers: number = 0;
  questionsRemaining: number = 3;

  constructor(
    private qs: QuizService,
    private extraService: ExtraService,
    private ms: MessageService
  ) {}

  ngOnInit(): void {
    this.qs.postQuestion().subscribe((post) => {
      this.qs.getQuestions().subscribe((q) => {
        let sample = q;

        for (var i = 0; i < 3; i++) {
          let random = Math.floor(Math.random() * sample.length);
          this.randomQuestions.push(sample[random]);
          sample.splice(random, 1);
        }
      });
    });
    setTimeout(() => {
      this.randomQuestion();
      this.qs.deleteQuestions().subscribe();
    }, 700);
  }

  randomQuestion() {
    this.correct.next(false);
    this.notCorrect.next(false);
    this.chosenAnswer = new FormControl('');

    let random = Math.floor(Math.random() * this.randomQuestions.length);
    this.question = this.randomQuestions[random];
    this.randomQuestions.splice(random, 1);
  }

  checkAnswer() {
    this.questionsRemaining = this.questionsRemaining - 1;
    if (this.question !== undefined) {
      let answer = this.question.answers[0];
      this.question?.answers.forEach((a) => {
        if (a.answer === this.chosenAnswer.value) {
          answer = a;
        }
      });

      if (answer.correct) {
        this.correct.next(true);
        this.correctAnswers = this.correctAnswers + 1;
      } else {
        this.notCorrect.next(true);
      }

      setTimeout(() => {
        if (this.questionsRemaining !== 0) {
          this.randomQuestion();
        } else {
          this.correct.next(false);
          this.notCorrect.next(false);
          this.chosenAnswer = new FormControl('');
        }
      }, 1000);
    }
  }

  gotoQuiz() {
    this.ms.sendShowQuiz(true);
    this.extraService.redirectTo('quiz');
  }

  gotoWarmup() {
    this.extraService.redirectTo('warmup');
  }
}
