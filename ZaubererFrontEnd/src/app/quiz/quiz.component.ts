import { Component, OnInit } from '@angular/core';
import { FormControl } from '@angular/forms';
import { BehaviorSubject } from 'rxjs';
import { HpAnswer } from '../interfaces/hp-answer';
import { HpQuestion } from '../interfaces/hp-question';
import { ExtraService } from '../services/extra.service';
import { MessageService } from '../services/message.service';
import { QuizService } from '../services/quiz.service';

@Component({
  selector: 'app-quiz',
  templateUrl: './quiz.component.html',
  styleUrls: ['./quiz.component.css'],
})
export class QuizComponent implements OnInit {
  questions: HpQuestion[] = [];
  show = this.ms.showQuiz.value;
  chosenQuestions: HpQuestion[] = this.ms.chosenQuestions.value;

  question?: HpQuestion;
  randomQuestions: HpQuestion[] = [];
  chosenAnswer = new FormControl('');
  correct = new BehaviorSubject<boolean>(false);
  notCorrect = new BehaviorSubject<boolean>(false);
  correctAnswers: number = 0;
  round: number = 15;
  questionsRemaining = this.round;

  constructor(
    private qs: QuizService,
    private ms: MessageService,
    private extraService: ExtraService
  ) {}

  ngOnInit(): void {
    this.qs.postQuestion().subscribe((post) => {
      this.qs.getQuestions().subscribe((q) => {
        let sample = q;
        console.log(this.chosenQuestions);
        for (var i = 0; i < this.round; i++) {
          let random = Math.floor(Math.random() * sample.length);
          if (this.checkChosenQuestions(sample, random)) {
            i--;
          } else {
            this.randomQuestions.push(sample[random]);
            sample.splice(random, 1);
          }
        }
      });
    });

    setTimeout(() => {
      console.log(this.randomQuestions);
      this.randomQuestion();
      this.qs.deleteQuestions().subscribe();
    }, 2000);
  }

  randomQuestion() {
    this.correct.next(false);
    this.notCorrect.next(false);
    this.chosenAnswer = new FormControl('');

    let random = Math.floor(Math.random() * this.randomQuestions.length);
    this.question = this.randomQuestions[random];
    this.randomQuestions.splice(random, 1);

    this.question.answers = this.randomAnswers(this.question);
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

  randomAnswers(question: HpQuestion) {
    let randonAnswer: HpAnswer[] = [];
    const length = question.answers.length;
    for (var i = 0; i < length; i++) {
      const random = Math.floor(Math.random() * question.answers.length);
      randonAnswer.push(question.answers[random]);
      question.answers.splice(random, 1);
    }

    return randonAnswer;
  }

  checkChosenQuestions(sample: HpQuestion[], random: number) {
    let double = false;
    this.chosenQuestions.forEach((question) => {
      if (sample[random].question === question.question) {
        double = true;
        console.log("True");
      } else {
        console.log("False");
      }
    });

    return double;
  }

  gotoWarmup() {
    this.extraService.redirectTo('warmup');
  }
}
