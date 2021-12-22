import { Injectable } from '@angular/core';
import { Router } from '@angular/router';

@Injectable({
  providedIn: 'root',
})
export class ExtraService {
  wizardType: string[] = [
    'Headmaster',
    'Voldemort',
    'Hufflepuff',
    'Slytherin',
    'Ravenclaw',
    'Gryffindor',
    'Deatheater',
    'Alumni',
    'Professor',
    'Dumbledore',
    'Potionsmaster',
  ];

  options: string[] = ['Spell', 'Potion', 'Animal'];

  environment: string[] = [
    'Main Gate',
    'Wooden Bridge',
    'Boat House',
    'Edge of the Forbidden Forest',
    'Seventh Floor',
  ];

  ranking: string[] = [
    'Dursley',
    'Ordinary Muggle',
    'Hogwarts Caretaker',
    'Gurg',
    'Ron with a broken wand',
    'First Year',
    'Duelling Club Participant',
    'Gilderoy Lockhart',
    'Triwizard Champion',
    'More OWLs than Hermione',
    'Exocitic Symbol Analyst',
    'Junior Assisstent to the Minister of Magic',
    'British Youth Representative to the Wizengamot',
    'Wandmaker',
    'Auror',
    'Professor', // Eventuell nochmal ändern, um Verwirrung mit der Klasse zu vermeiden
    'Headmaster', // Eventuell nochmal ändern, um Verwirrung mit der Klasse zu vermeiden
    'Chief Warlock',
    'Most Dangerous Dark Wizard of All Time',
    'Master of Death',
  ];

  battleSize: number[] = [1, 2, 3];

  constructor(private router: Router) {}

  redirectTo(url: string) {
    this.router
      .navigateByUrl('/', { skipLocationChange: true })
      .then(() => this.router.navigate([url]));
  }

  redirectToWithTimeout(url: string) {
    setTimeout(() => {
      this.router
        .navigateByUrl('/', { skipLocationChange: true })
        .then(() => this.router.navigate([url]));
    }, 500);
  }
}
