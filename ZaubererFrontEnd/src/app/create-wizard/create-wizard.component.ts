import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormControl, Validators } from '@angular/forms';
import { WizardService } from '../wizard.service';
import { ExtraService } from '../extra.service';
import { MagicalBeingService } from '../magical-being.service';
import { GiantService } from '../giant.service';

@Component({
  selector: 'app-create-wizard',
  templateUrl: './create-wizard.component.html',
  styleUrls: ['./create-wizard.component.css'],
})
export class CreateWizardComponent implements OnInit {
  being = this.extraService.beingType;
  wizardType = this.extraService.wizardType;
  createWizardNr = new FormControl('Headmaster', [Validators.required]);
  createBeing = new FormControl('Wizard', [Validators.required]);
  show: boolean = false;

  constructor(
    private giantService: GiantService,
    private hpService: WizardService,
    private extraService: ExtraService,
    private fb: FormBuilder
  ) {}

  ngOnInit(): void {}

  magicalBeingForm = this.fb.group({
    name: ['', [Validators.required, Validators.minLength(3)]],
    healthPoints: [
      '',
      [Validators.required, Validators.min(1), Validators.max(100)],
    ],
    description: [
      '',
      [
        Validators.required,
        Validators.minLength(10),
        Validators.maxLength(100),
      ],
    ],
  });

  submit() {
    this.show = false;
    if(this.createBeing.value === 'Wizard'){
    this.hpService
      .postWizard(this.magicalBeingForm.value, this.createWizardNr.value)
      .subscribe((a) => {
        this.show = true;
        this.extraService.redirectToWithTimeout('overview');
      });
    } else if(this.createBeing.value === 'Giant'){
      this.giantService
        .postGiant(this.magicalBeingForm.value)
        .subscribe((a) => {
          this.show = true;
          this.extraService.redirectToWithTimeout('overview');
        });
      }
  }

 
}
