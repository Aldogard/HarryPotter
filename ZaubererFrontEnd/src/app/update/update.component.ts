import { Component, OnInit } from '@angular/core';
import { FormControl, NgForm } from '@angular/forms';
import { ExtraService } from '../services/extra.service';
import { HpMagicalBeing } from '../interfaces/hp-magical-being';
import { MagicalBeingService } from '../services/magical-being.service';

@Component({
  selector: 'app-update-wizard',
  templateUrl: './update.component.html',
  styleUrls: ['./update.component.css'],
})
export class UpdateComponent implements OnInit {
  show: boolean = false;
  getMagicalBeingId: FormControl = new FormControl(0);
  magicalBeings: HpMagicalBeing[] = [];
  magicalBeingChoice?: HpMagicalBeing;
  magicalBeingId: number = 0;

  constructor(
    private mbService: MagicalBeingService,
    private extraService: ExtraService
  ) {}

  ngOnInit(): void {
    this.mbService.getMagicalBeings().subscribe((element) => {
      this.magicalBeings = element;
      this.getMagicalBeingByName();
    });
  }

  getMagicalBeingByName() {
    this.magicalBeingId = (<HTMLInputElement>(
      document.getElementById('wizardUpdate')
    )).value as unknown as number;

    if (!this.magicalBeingId) {
      this.magicalBeingId = this.magicalBeings[0].id;
    }

    this.mbService
      .getMagicalBeingById(this.magicalBeingId)
      .subscribe((x) => (this.magicalBeingChoice = x));
  }

  update(form: NgForm) {
    const response = this.mbService.updateMagicalBeing(form.value, this.magicalBeingId);
    response.subscribe((x) => {
      this.show = true;
      this.extraService.redirectToWithTimeout('overview');
    });
    console.log(form.value);
  }
}
