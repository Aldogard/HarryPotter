import { Component, OnInit } from '@angular/core';
import { FormControl, Validators } from '@angular/forms';
import { ExtraService } from '../services/extra.service';
import { MagicalBeingService } from '../services/magical-being.service';
import { HpMagicalBeing } from '../interfaces/hp-magical-being';

@Component({
  selector: 'app-delete-wizard',
  templateUrl: './delete.component.html',
  styleUrls: ['./delete.component.css'],
})
export class DeleteComponent implements OnInit {
  show: boolean = false;
  magicalBeings: HpMagicalBeing[] = [];
  choice2: FormControl = new FormControl(0);

  pin: number = 0;
  accessNumber: FormControl = new FormControl('', [
    Validators.required,
    Validators.min(this.pin),
    Validators.max(this.pin),
  ]);

  constructor(
    private mbService: MagicalBeingService,
    private extraService: ExtraService
  ) {}

  ngOnInit(): void {
    this.mbService.getMagicalBeings().subscribe((element) => {
      this.magicalBeings = element;
      this.getMagicalBeingByName();
    });

    this.mbService.getPin().subscribe((pin) => {
      this.pin = pin;

      this.accessNumber = new FormControl('', [
        Validators.required,
        Validators.min(this.pin),
        Validators.max(this.pin),
      ]);
    });
  }

  getMagicalBeingByName() {
    let id = (<HTMLInputElement>document.getElementById('wizardUpdate'))
      .value as unknown as number;

    if (!id) {
      id = this.magicalBeings[0].id;
    }
    this.choice2 = new FormControl(id);
  }

  deleteMagicalBeingById() {
    this.show = false;
    const response = this.mbService.deleteMagicalBeing(this.choice2.value);
    response.subscribe((x) => (this.show = true));
    this.extraService.redirectToWithTimeout('overview');
  }

  deleteAll() {
    const response = this.mbService.deleteAllMagicalBeings();
    response.subscribe();
    this.extraService.redirectToWithTimeout('create');
  }
}
