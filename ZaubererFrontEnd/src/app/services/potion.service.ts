import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root',
})
export class PotionService {
  potions: string[] = [
    'Baruffios Brain Elixir',
    'Exploding Potion',
    'Healing Potion',
    'Invigoration Draught',
    'Wit-Sharpening Potion',
  ];

  test: string[][] = [
    [
      'Leaping Toadstools',
      'Frog Brains',
      'Runespoor eggs',
      'Powdered dragon claw',
    ],
    ['Ice pop', 'Red spider', 'Flowers'],
    [
      'Alihotsy leaves',
      'Dried billywig stings',
      'Peppermint',
      'Stewed Mandrake',
      'Infusion of Wormwood',
      'Honeywater',
      'Vervain infusion',
      'Scurvy grass',
      'Lovage',
    ],
    [
      'Ground scarab beetles',
      'Cut ginger roots',
      'Armandillo bile',
      'Newt spleens',
    ],
  ];

  ingredients: string[] = [
    'Bubotuber pus',
    'Runespoor eggs',
    'Stewed Mandrake',
    'Ground scarab beetles',
    'Honeywater',
    'Red spider',
    'Vervain infusion',
    'Scurvy grass',
    'Lovage',
    'Wormwood',
    'Dittany',
    'Dragon liver',
    'Ice pop',
  // ];

  // ingredients2: string[] = [
    'Leaping Toadstools',
    'Infusion of Wormwood',
    'Alihotsy leaves',
    'Frog Brains',
    'Armandillo bile',
    'Peppermint',
    'Newt spleens',
    'Cut ginger roots',
    'Flowers',
    'Dried billywig stings',
    'Powdered dragon claw',
  ];

  constructor() {}
}
