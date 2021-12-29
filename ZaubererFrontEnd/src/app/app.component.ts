import { Component, OnInit } from '@angular/core';
import { Title } from '@angular/platform-browser';
import { HpWizard } from './hp-wizard';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css'],
})
export class AppComponent implements OnInit {
  title = 'Harry Potter';
  zaubererArray: HpWizard[] = [];

  public constructor(private titleService: Title) {}
  ngOnInit(): void {
    this.titleService.setTitle('Harry Potter');
  }
}
