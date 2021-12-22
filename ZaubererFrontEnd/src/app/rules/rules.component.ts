import { Component, OnInit } from '@angular/core';
import { MessageService } from '../message.service';
import { ExtraService } from '../extra.service';

@Component({
  selector: 'app-rules',
  templateUrl: './rules.component.html',
  styleUrls: ['./rules.component.css'],
})
export class RulesComponent implements OnInit {
  show: boolean = false;

  constructor(
    private extraService: ExtraService,
    private ms: MessageService
  ) {}

  ngOnInit(): void {
    this.ms.show.subscribe(bool => this.show = bool);
  }

  gotoFight() {
    this.extraService.redirectTo('battle');
  }
}
