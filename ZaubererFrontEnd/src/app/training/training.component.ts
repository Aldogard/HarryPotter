import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormControl, Validators } from '@angular/forms';
import { ExtraService } from '../extra.service';
import { HpMagicalBeing } from '../hp-magical-being';
import { MagicalBeingService } from '../magical-being.service';
import { WizardService } from '../wizard.service';

@Component({
  selector: 'app-training',
  templateUrl: './training.component.html',
  styleUrls: ['./training.component.css'],
})
export class TrainingComponent implements OnInit {
  show: boolean = false;
  dummy?: HpMagicalBeing;

  magicalBeingForm = this.fb.group({
    name: new FormControl('Dummy'),
    healthPoints: new FormControl(25),
    description: new FormControl('Test dummy for pratice'),
  });

  constructor(
    private mbService: MagicalBeingService,
    private extraService: ExtraService,
    private fb: FormBuilder,
    private ws: WizardService
  ) {}

  ngOnInit(): void {
    this.ws
      .postWizard(this.magicalBeingForm.value, 'Alumni')
      .subscribe((post) => {
        this.mbService.getMagicalBeingByName('Dummy').subscribe((mb) => {
          this.dummy = mb;
          this.mbService.deleteDummy().subscribe();
        });
      });
  }


  
}
