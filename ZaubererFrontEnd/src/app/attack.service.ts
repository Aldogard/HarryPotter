import { Injectable } from '@angular/core';
import { FormControl } from '@angular/forms';
import { ExtraService } from './extra.service';
import { HpSpell } from './hp-spell';
import { MagicalBeingService } from './magical-being.service';
import { MessageService } from './message.service';

@Injectable({
  providedIn: 'root'
})
export class AttackService {

  constructor(
    private mb: MagicalBeingService,
    private extraService: ExtraService,
    private ms: MessageService,
  ) { }

}
