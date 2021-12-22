import { Component, OnInit } from '@angular/core';
import { FormControl, Validators } from '@angular/forms';
import { HarrypotterService } from '../harrypotter.service';
import { Hptype } from '../hptype';
import { ExtraService } from '../extra.service';

@Component({
  selector: 'app-delete-wizard',
  templateUrl: './delete-wizard.component.html',
  styleUrls: ['./delete-wizard.component.css'],
})
export class DeleteWizardComponent implements OnInit {
  show: boolean = false;
  wizards: Hptype[] = [];
  choice2: FormControl = new FormControl(0);

  pin: number = 0;
  accessNumber: FormControl = new FormControl('', [
    Validators.required,
    Validators.min(this.pin),
    Validators.max(this.pin),
  ]);

  constructor(
    private hpService: HarrypotterService,
    private extraService: ExtraService
  ) {}

  ngOnInit(): void {
    this.hpService.getWizards().subscribe((element) => {
      this.wizards = element;
      this.getWizardByName();
    });

    this.hpService.getPin().subscribe((pin) => {
      this.pin = pin;

      this.accessNumber = new FormControl('', [
        Validators.required,
        Validators.min(this.pin),
        Validators.max(this.pin),
      ]);
    });
  }

  getWizardByName() {
    let id = (<HTMLInputElement>document.getElementById('wizardUpdate'))
      .value as unknown as number;

    if (!id) {
      id = this.wizards[0].id;
    }
    this.choice2 = new FormControl(id);
  }

  deleteZaubererById() {
    this.show = false;
    const response = this.hpService.deleteWizard(this.choice2.value);
    response.subscribe((x) => (this.show = true));
    this.extraService.redirectToWithTimeout('overview');
  }

  deleteAll() {
    const response = this.hpService.deleteAllWizards();
    response.subscribe();
  }
}
