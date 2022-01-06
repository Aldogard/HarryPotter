import { Component, OnInit } from '@angular/core';
import { FormControl } from '@angular/forms';
import { Router } from '@angular/router';
import { MessageService } from '../message.service';
import { ExtraService } from '../extra.service';

@Component({
  selector: 'app-search-connection',
  templateUrl: './search.component.html',
  styleUrls: ['./search.component.css'],
})
export class SearchComponent implements OnInit {
  content: FormControl = new FormControl('');
  constructor(
    private ms: MessageService,
    private extraService: ExtraService,
  ) {}

  ngOnInit(): void {}

  search(event: any) {
    this.ms.sendWord(this.content.value);
    this.extraService.redirectTo('result');
  }
}
