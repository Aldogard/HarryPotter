import { Component, OnInit } from '@angular/core';
import { Title } from '@angular/platform-browser';
import { HpMagicalBeing } from './services/hp-magical-being';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css'],
})
export class AppComponent implements OnInit {
  title = 'Harry Potter';
  zaubererArray: HpMagicalBeing[] = [];

  public constructor(private titleService: Title) {}
  ngOnInit(): void {
    this.titleService.setTitle('Harry Potter');
  }
}
