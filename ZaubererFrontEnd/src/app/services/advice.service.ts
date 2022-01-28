import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class AdviceService {
  adviceRook: string[] = [
    'I want to attack right now',
    'You better listen to my advice',
    'Open up some lines',
    'I am not trusting you',
    'I hope your duelling skills are better than your chess skills',
    'Are you sure you understood the game?',
    'I want to attack the back rank',
    'Let us grab some pawns',
  ];

  adviceQueen: string[] = [
    'I am the most powerful piece',
    'Be aware of possible forks',
    'The rooks are two cheeky',
    'You should protect me and the king',
    'Time to smash the opponents defence'
  ];

  adviceBishop: string[] = [
    'I want to slice over the whole field',
    'Bishops are worth more than knights',
    'Do not hide me behind some pawns',
    'We should pin a piece, preferably a rook',
    'Give me a pawn for protection',
  ];

  adviceKnight: string[] = [
    'Do not mind trading away a bishop or two',
    'A fork will definitely help you',
    'A knight on the rim is grim',
    'Do not leave me hanging',
    'In my opinion, you are playing to passive',
  ]

  adviceKing: string[] = [
    'I am not feeling very well protected',
    'Always keep some pawns in front of me',
    'I am by far the most important piece',
    'Keep me out of the opponents sight',
    'Are you sure there are no threats?'
  ];

  constructor() { }
}
