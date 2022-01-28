import { Component, OnInit } from '@angular/core';
import { ExtraService } from '../services/extra.service';
import { MessageService } from '../services/message.service';

@Component({
  selector: 'app-rules-chess',
  templateUrl: './information.component.html',
  styleUrls: ['./information.component.css']
})
export class InformationComponent implements OnInit {
  show: boolean = false;

  constructor(
    private extraService: ExtraService,
    private ms: MessageService
  ) {}

  ngOnInit(): void {
    this.ms.showChess.subscribe(bool => this.show = bool);
  }

  gotoChess() {
    this.extraService.redirectTo('chess');
  }
}
