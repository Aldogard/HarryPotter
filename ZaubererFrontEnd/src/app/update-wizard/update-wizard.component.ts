import { Component, EventEmitter, OnInit } from '@angular/core';
import { FormBuilder, FormControl, NgForm, Validators } from '@angular/forms';
import { HarrypotterService } from '../harrypotter.service';
import { Hptype } from '../hptype';
import { ExtraService } from '../extra.service';

@Component({
  selector: 'app-update-wizard',
  templateUrl: './update-wizard.component.html',
  styleUrls: ['./update-wizard.component.css'],
})
export class UpdateWizardComponent implements OnInit {
  show: boolean = false;
  getWizardId: FormControl = new FormControl(0);
  wizards: Hptype[] = [];
  wizardChoice?: Hptype;
  wizardId: number = 0;

  constructor(
    private hpService: HarrypotterService,
    private fb: FormBuilder,
    private extraService: ExtraService
  ) {}

  ngOnInit(): void {
    this.hpService.getWizards().subscribe((element) => {
      this.wizards = element;
      this.getWizardByName();
    });
  }

  getWizardByName() {
    this.wizardId = (<HTMLInputElement>(
      document.getElementById('wizardUpdate')
    )).value as unknown as number;

    if (!this.wizardId) {
      this.wizardId = this.wizards[0].id;
    }

    this.hpService
      .getWizardById(this.wizardId)
      .subscribe((x) => (this.wizardChoice = x));
  }

  update(form: NgForm) {
    const response = this.hpService.updateWizard(form.value, this.wizardId);
    response.subscribe((x) => {
      this.show = true;
      this.extraService.redirectToWithTimeout('overview');
    });
    console.log(form.value);
  }
}
