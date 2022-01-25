import { Injectable } from '@angular/core';
import { ExtraService } from './extra.service';
import { MagicalBeingService } from './magical-being.service';
import { MessageService } from './message.service';

@Injectable({
  providedIn: 'root'
})
export class PotionService {
  potions: string[] = [
    'Baruffios Brain Elixir',
    'Exploding Potion',
    'Healing Potion',
    'Invigoration Draught',
    'Wit-Sharpening Potion',
  ];

  ingridients: string[] = [

    'Leaping Toadstools',
    'Frog Brains',
    'Runespoor eggs',
    'Powdered dragon claw',

    'Ice pop',
    'Red spider',
    'Flowers',

    'Wormwood',
    'Bubotuber pus',
    'Dittany',
    'Dragon liver',

    'Alihotsy leaves',
    'Dried billywig stings',
    'Peppermint',
    'Stewed Mandrake',
    'Infusion of Wormwood',
    'Honeywater',
    'Vervain infusion',
    'Scurvy grass',
    'Lovage',

    'Ground scarab beetles',
    'Cut ginger roots',
    'Armandillo bile',
    'Newt spleens',

  ];


  constructor(
    private mb: MagicalBeingService,
    private extraService: ExtraService,
    private ms: MessageService,
  ) { }

}
