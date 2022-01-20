import { Component, OnInit } from '@angular/core';
import { BehaviorSubject } from 'rxjs';
import { HpMagicalBeing } from '../hp-magical-being';
import { MagicalBeingService } from '../magical-being.service';
import { MessageService } from '../message.service';

@Component({
  selector: 'app-chess-test2',
  templateUrl: './chess.component.html',
  styleUrls: ['./chess.component.css'],
})
export class ChessComponent implements OnInit {
  rows: string[] = ['8', '7', '6', '5', '4', '3', '2', '1'];
  columns: string[] = ['A', 'B', 'C', 'D', 'E', 'F', 'G', 'H'];
  firstPiece: string = '';
  rowOfFirstPiece: string = '';
  columnOfFirstPiece: string = '';
  nextMove = new BehaviorSubject<boolean>(true);
  moves: string[] = [];
  amountOfMoves: number[] = [];
  attackPiece: string = '';
  checkWhiteKing = new BehaviorSubject<boolean>(false);
  checkBlackKing = new BehaviorSubject<boolean>(false);
  adviceMb1 = new BehaviorSubject<string>('');
  adviceMb2 = new BehaviorSubject<string>('');

  whiteKingMoved = false;
  whiteRookMoved1 = false;
  whiteRookMoved8 = false;
  blackKingMoved = false;
  blackRookMoved1 = false;
  blackRookMoved8 = false;
  castleWhiteGreat = false;
  castleWhiteSmall = false;
  castleBlackGreat = false;
  castleBlackSmall = false;
  enPassantWhite = false;
  enPassantBlack = false;
  enPassentValues: number[] = [];
  endOfGame = false;
  winner = new BehaviorSubject<string>('');
  drawMb1 = false;
  drawMb2 = false;

  board: string[] = [
    'RW',
    'SW',
    'BW',
    'QW',
    'KW',
    'BW',
    'SW',
    'RW',
    'PW',
    'PW',
    'PW',
    'PW',
    'PW',
    'PW',
    'PW',
    'PW',
    '',
    '',
    '',
    '',
    '',
    '',
    '',
    '',
    '',
    '',
    '',
    '',
    '',
    '',
    '',
    '',
    '',
    '',
    '',
    '',
    '',
    '',
    '',
    '',
    '',
    '',
    '',
    '',
    '',
    '',
    '',
    '',
    'PB',
    'PB',
    'PB',
    'PB',
    'PB',
    'PB',
    'PB',
    'PB',
    'RB',
    'SB',
    'BB',
    'QB',
    'KB',
    'BB',
    'SB',
    'RB',
  ];

  magicalBeing1?: HpMagicalBeing;
  magicalBeing2?: HpMagicalBeing;

  constructor(
    private ms: MessageService,
    private mbService: MagicalBeingService
  ) {}

  ngOnInit(): void {
    this.ms.magicalBeingArrayChess.subscribe((mb) => {
      this.magicalBeing1 = mb[0];
      this.magicalBeing2 = mb[1];
    });
    // this.mbService.getMagicalBeings().subscribe((mb) => {
    //   this.magicalBeing1 = mb[0];
    //   this.magicalBeing2 = mb[1];
    // });
  }

  giveAdvice() {
    if (this.nextMove.value && this.magicalBeing1 !== undefined) {
      if (Math.random() > 0.7) {
        const hint =
          this.magicalBeing1.hints[
            Math.floor(Math.random() * this.magicalBeing1.hints.length)
          ];
        if (
          this.magicalBeing1.name !== 'Ron' &&
          !hint.ron &&
          this.magicalBeing1.klasse !== 'Ravenclaw' &&
          !hint.ravenlaw
        ) {
          this.adviceMb1.next(hint.content);
          this.adviceMb2.next('');
        }
      } else {
        this.adviceMb1.next('');
        this.adviceMb2.next('');
      }
    }

    if (!this.nextMove.value && this.magicalBeing2 !== undefined) {
      if (Math.random() > 0.7) {
        const hint =
          this.magicalBeing2.hints[
            Math.floor(Math.random() * this.magicalBeing2.hints.length)
          ];
        if (
          !(this.magicalBeing2.name === 'Ron' && hint.ron) &&
          !(this.magicalBeing2.klasse === 'Ravenclaw' && hint.ravenlaw)
        ) {
          this.adviceMb2.next(hint.content);
          this.adviceMb1.next('');
        }
      } else {
        this.adviceMb2.next('');
        this.adviceMb1.next('');
      }
    }
  }

  resign(loser: HpMagicalBeing, winner: HpMagicalBeing) {
    this.endOfGame = true;
    this.winner.next(winner.name);
    winner.victoriesChess = winner.victoriesChess + 1;
    this.mbService.updateVictoriesChess(winner).subscribe();
  }

  draw(mb: HpMagicalBeing, mb2: HpMagicalBeing) {
    if (mb === this.magicalBeing1) {
      this.drawMb1 = true;
    }
    if (mb === this.magicalBeing2) {
      this.drawMb2 = true;
    }
    if (this.drawMb1 && this.drawMb2) {
      this.endOfGame = true;
      mb.victoriesChess = mb.victoriesChess + 0.5;
      mb2.victoriesChess = mb2.victoriesChess + 0.5;
      this.mbService.updateVictoriesChess(mb).subscribe();
      this.mbService.updateVictoriesChess(mb2).subscribe();
    }
  }

  getPiece(row: string, column: string) {
    if (this.firstPiece === '') {
      this.firstPiece = this.board[this.getValue(row, column)];
      this.rowOfFirstPiece = row;
      this.columnOfFirstPiece = column;
      this.giveAdvice();
    }
  }

  movePiece(rowString: string, columnString: string) {
    let row = parseInt(rowString);
    let column = columnString.charCodeAt(0) - 64;
    this.board[this.getValue(this.rowOfFirstPiece, this.columnOfFirstPiece)] =
      '';
    const legal = this.checkLegality(row, column, this.firstPiece);

    if (this.firstPiece !== '' && legal) {
      this.attackPiece = this.board[this.getValueNumbers(row, column)];
      this.board[this.getValueNumbers(row, column)] = this.firstPiece;

      const noCheck = this.checkIfCheck(this.nextMove.value);
      console.log('Check: ' + noCheck);
      if (this.firstPiece !== '' && !noCheck) {
        this.moves.push(this.firstPiece + ' ' + columnString + rowString);
        this.amountOfMoves.push(this.moves.length);
        this.castle(this.columnOfFirstPiece);
        this.performCastle();
        this.performEnPassant(row, column);
        this.queening(row, column);

        this.nextMove.next(!this.nextMove.value);
        this.resetDraw();
        this.changeEnPassant();
        this.firstPiece = '';
      } else {
        console.log('This move is not legal');
        this.board[
          this.getValue(this.rowOfFirstPiece, this.columnOfFirstPiece)
        ] = this.firstPiece;
        this.board[this.getValueNumbers(row, column)] = this.attackPiece;
        this.firstPiece = '';
        this.castleBlackGreat = false;
        this.castleWhiteGreat = false;
        this.castleBlackSmall = false;
        this.castleWhiteSmall = false;
      }
    } else {
      console.log('This move is not legal');
      this.board[this.getValue(this.rowOfFirstPiece, this.columnOfFirstPiece)] =
        this.firstPiece;
      this.firstPiece = '';
    }
  }

  getValue(row: string, column: string) {
    const value = (parseInt(row) - 1) * 8;
    const value2 = column.charCodeAt(0) - 64;
    const position = value + value2 - 1;
    return position;
  }

  getValueNumbers(row: number, column: number) {
    const position = (row - 1) * 8 + column - 1;
    if (position < 0 || position > 63) {
      console.log('Fehler fffffffffffffffffffff');
    }
    return position;
  }

  showPiece2(row: string, column: string) {
    if (this.board[this.getValue(row, column)] === 'PW') {
      return 'assets/whitepawn.png';
    }
    if (this.board[this.getValue(row, column)] === 'RW') {
      return 'assets/whiterook.png';
    }
    if (this.board[this.getValue(row, column)] === 'SW') {
      return 'assets/whiteknight.png';
    }
    if (this.board[this.getValue(row, column)] === 'BW') {
      return 'assets/whitebishop.png';
    }
    if (this.board[this.getValue(row, column)] === 'QW') {
      return 'assets/whitequeen.png';
    }
    if (this.board[this.getValue(row, column)] === 'KW') {
      return 'assets/whiteking.png';
    }
    if (this.board[this.getValue(row, column)] === 'PB') {
      return 'assets/blackpawn.png';
    }
    if (this.board[this.getValue(row, column)] === 'RB') {
      return 'assets/blackrook.png';
    }
    if (this.board[this.getValue(row, column)] === 'SB') {
      return 'assets/blackknight.png';
    }
    if (this.board[this.getValue(row, column)] === 'BB') {
      return 'assets/blackbishop.png';
    }
    if (this.board[this.getValue(row, column)] === 'QB') {
      return 'assets/blackqueen.png';
    }
    if (this.board[this.getValue(row, column)] === 'KB') {
      return 'assets/blackking.png';
    }
    return '';
  }

  castle(columnString: string) {
    let column = columnString.charCodeAt(0) - 64;
    if (this.firstPiece === 'KW') {
      this.whiteKingMoved = true;
    }
    if (this.firstPiece === 'KB') {
      this.blackKingMoved = true;
    }
    if (this.firstPiece === 'RW' && column === 1) {
      this.whiteRookMoved8 = true;
    }
    if (this.firstPiece === 'RB' && column === 1) {
      this.blackRookMoved8 = true;
    }
    if (this.firstPiece === 'RW' && column === 8) {
      this.whiteRookMoved8 = true;
    }
    if (this.firstPiece === 'RB' && column === 8) {
      this.blackRookMoved8 = true;
    }
  }

  performCastle() {
    if (this.castleWhiteGreat) {
      this.board[0] = '';
      this.board[3] = 'RW';
      this.castleWhiteGreat = false;
    }
    if (this.castleWhiteSmall) {
      this.board[7] = '';
      this.board[5] = 'RW';
      this.castleWhiteSmall = false;
    }
    if (this.castleBlackGreat) {
      this.board[56] = '';
      this.board[59] = 'RB';
      this.castleBlackGreat = false;
    }
    if (this.castleBlackSmall) {
      this.board[63] = '';
      this.board[61] = 'RB';
      this.castleBlackSmall = false;
    }
  }

  changeEnPassant() {
    if (this.nextMove.value) {
      this.enPassantWhite = false;
    } else {
      this.enPassantBlack = false;
    }
  }

  performEnPassant(row: number, column: number) {
    if (
      this.nextMove.value &&
      this.enPassantBlack &&
      this.firstPiece === 'PW'
    ) {
      this.board[this.getValueNumbers(row - 1, column)] = '';
    }

    if (
      !this.nextMove.value &&
      this.enPassantWhite &&
      this.firstPiece === 'PB'
    ) {
      this.board[this.getValueNumbers(row + 1, column)] = '';
    }
  }

  queening(row: number, column: number) {
    if (this.firstPiece === 'PW' && row === 8) {
      this.board[this.getValueNumbers(row, column)] = 'QW';
    }
    if (this.firstPiece === 'PB' && row === 1) {
      this.board[this.getValueNumbers(row, column)] = 'QB';
    }
  }

  resetDraw() {
    if (this.nextMove.value) {
      this.drawMb1 = false;
    } else {
      this.drawMb2 = false;
    }
  }

  checkLegality(row: number, column: number, nameOfPiece: string) {
    console.log('E');
    const rowOfFirstPiece = parseInt(this.rowOfFirstPiece);
    const columnOfFirstPiece = this.columnOfFirstPiece.charCodeAt(0) - 64;

    if (nameOfPiece === 'PW' && this.nextMove.value) {
      return this.checkPW(row, rowOfFirstPiece, column, columnOfFirstPiece);
    }

    if (nameOfPiece === 'PB' && !this.nextMove.value) {
      return this.checkPB(row, rowOfFirstPiece, column, columnOfFirstPiece);
    }

    if (nameOfPiece === 'RW' && this.nextMove.value) {
      return this.checkRook(
        row,
        rowOfFirstPiece,
        column,
        columnOfFirstPiece,
        'W'
      );
    }

    if (nameOfPiece === 'RB' && !this.nextMove.value) {
      return this.checkRook(
        row,
        rowOfFirstPiece,
        column,
        columnOfFirstPiece,
        'B'
      );
    }

    if (nameOfPiece === 'SW' && this.nextMove.value) {
      return this.checkKnight(
        row,
        rowOfFirstPiece,
        column,
        columnOfFirstPiece,
        'W'
      );
    }

    if (nameOfPiece === 'SB' && !this.nextMove.value) {
      return this.checkKnight(
        row,
        rowOfFirstPiece,
        column,
        columnOfFirstPiece,
        'B'
      );
    }

    if (nameOfPiece === 'BW' && this.nextMove.value) {
      return this.checkBishop(
        row,
        rowOfFirstPiece,
        column,
        columnOfFirstPiece,
        'W'
      );
    }

    if (nameOfPiece === 'BB' && !this.nextMove.value) {
      return this.checkBishop(
        row,
        rowOfFirstPiece,
        column,
        columnOfFirstPiece,
        'B'
      );
    }

    if (nameOfPiece === 'QW' && this.nextMove.value) {
      return this.checkQueen(
        row,
        rowOfFirstPiece,
        column,
        columnOfFirstPiece,
        'W'
      );
    }

    if (nameOfPiece === 'QB' && !this.nextMove.value) {
      return this.checkQueen(
        row,
        rowOfFirstPiece,
        column,
        columnOfFirstPiece,
        'B'
      );
    }

    if (nameOfPiece === 'KW' && this.nextMove.value) {
      return this.checkKing(
        row,
        rowOfFirstPiece,
        column,
        columnOfFirstPiece,
        'W'
      );
    }

    if (nameOfPiece === 'KB' && !this.nextMove.value) {
      return this.checkKing(
        row,
        rowOfFirstPiece,
        column,
        columnOfFirstPiece,
        'B'
      );
    }

    return false;
  }

  checkPW(
    row: number,
    rowOfFirstPiece: number,
    column: number,
    columnOfFirstPiece: number
  ) {
    console.log('F');
    if (
      row === rowOfFirstPiece + 1 &&
      column === columnOfFirstPiece &&
      this.board[this.getValueNumbers(row, column)] === ''
    ) {
      return true;
    }

    if (
      row === rowOfFirstPiece + 2 &&
      rowOfFirstPiece === 2 &&
      column === columnOfFirstPiece &&
      this.board[this.getValueNumbers(row - 1, column)] === '' &&
      this.board[this.getValueNumbers(row, column)] === ''
    ) {
      this.enPassantWhite = true;
      this.enPassentValues[0] = row;
      this.enPassentValues[1] = column;
      return true;
    }
    if (
      (row === rowOfFirstPiece + 1 &&
        column === columnOfFirstPiece + 1 &&
        this.board[this.getValueNumbers(row, column)].substring(1) === 'B') ||
      (row === rowOfFirstPiece + 1 &&
        column === columnOfFirstPiece - 1 &&
        this.board[this.getValueNumbers(row, column)].substring(1) === 'B')
    ) {
      return true;
    }

    // console.log('TestEP');
    // console.log(row);
    // console.log(Math.abs(column - columnOfFirstPiece));
    // console.log(this.enPassantBlack);
    // console.log(row === this.enPassentValues[0] + 1);
    // console.log(column === this.enPassentValues[1]);
    // console.log('TestEPEnde');

    if (
      row === rowOfFirstPiece + 1 &&
      row === 6 &&
      Math.abs(column - columnOfFirstPiece) === 1 &&
      this.enPassantBlack &&
      row === this.enPassentValues[0] + 1 &&
      column === this.enPassentValues[1]
    ) {
      return true;
    }
    return false;
  }

  checkPB(
    row: number,
    rowOfFirstPiece: number,
    column: number,
    columnOfFirstPiece: number
  ) {
    if (
      row === rowOfFirstPiece - 1 &&
      column === columnOfFirstPiece &&
      this.board[this.getValueNumbers(row, column)] === ''
    ) {
      return true;
    }
    if (
      row === rowOfFirstPiece - 2 &&
      rowOfFirstPiece === 7 &&
      column === columnOfFirstPiece &&
      this.board[this.getValueNumbers(row + 1, column)] === '' &&
      this.board[this.getValueNumbers(row, column)] === ''
    ) {
      this.enPassantBlack = true;
      this.enPassentValues[0] = row;
      this.enPassentValues[1] = column;
      return true;
    }
    if (
      (row === rowOfFirstPiece - 1 &&
        column === columnOfFirstPiece + 1 &&
        this.board[this.getValueNumbers(row, column)].substring(1) === 'W') ||
      (row === rowOfFirstPiece - 1 && column === columnOfFirstPiece - 1)
    ) {
      return true;
    }

    if (
      row === rowOfFirstPiece - 1 &&
      row === 4 &&
      Math.abs(column - columnOfFirstPiece) === 1 &&
      this.enPassantWhite &&
      row === this.enPassentValues[0] - 1 &&
      column === this.enPassentValues[1]
    ) {
      return true;
    }
    return false;
  }

  checkRook(
    row: number,
    rowOfFirstPiece: number,
    column: number,
    columnOfFirstPiece: number,
    color: string
  ) {
    let king;
    if (color === 'W') {
      king = 'KW';
    } else if (color === 'B') {
      king = 'KB';
    }

    if (column === columnOfFirstPiece || row === rowOfFirstPiece) {
      for (var i = rowOfFirstPiece + 1; i <= row; i++) {
        if (this.board[this.getValueNumbers(i, column)] !== '' && i < row) {
          return false;
        }
        if (
          this.board[this.getValueNumbers(i, column)].substring(1) === color &&
          i === row
        ) {
          return false;
        } else if (
          this.board[this.getValueNumbers(i, column)].substring(1) !== color &&
          i === row
        ) {
          return true;
        }
      }
      for (var i = rowOfFirstPiece - 1; i >= row; i--) {
        // console.log('XTest');
        // console.log(
        //   this.board[this.getValueNumbers(i, column)].substring(1) !== color
        // );
        // console.log(i === row);
        // console.log(rowOfFirstPiece);
        // console.log(row);
        // console.log(color);
        // console.log('XtestEnde');
        if (this.board[this.getValueNumbers(i, column)] !== '' && i > row) {
          return false;
        }
        if (
          this.board[this.getValueNumbers(i, column)].substring(1) === color &&
          i === row
        ) {
          return false;
        } else if (
          this.board[this.getValueNumbers(i, column)].substring(1) !== color &&
          i === row
        ) {
          return true;
        }
      }
      for (var i = columnOfFirstPiece + 1; i <= column; i++) {
        if (this.board[this.getValueNumbers(row, i)] !== '' && i < column) {
          return false;
        }
        if (
          this.board[this.getValueNumbers(row, i)].substring(1) === color &&
          i === column
        ) {
          return false;
        } else if (
          this.board[this.getValueNumbers(row, i)].substring(1) !== color &&
          i === column
        ) {
          return true;
        }
      }
      for (var i = columnOfFirstPiece - 1; i >= column; i--) {
        if (this.board[this.getValueNumbers(row, i)] !== '' && i > column) {
          return false;
        }
        if (
          this.board[this.getValueNumbers(row, i)].substring(1) === color &&
          i === column
        ) {
          return false;
        } else if (
          this.board[this.getValueNumbers(row, i)].substring(1) !== color &&
          i === column
        ) {
          return true;
        }
      }
    }
    return false;
  }

  checkKnight(
    row: number,
    rowOfFirstPiece: number,
    column: number,
    columnOfFirstPiece: number,
    color: string
  ) {
    let king;
    if (color === 'W') {
      king = 'KW';
    } else if (color === 'B') {
      king = 'KB';
    }
    if (
      (row === rowOfFirstPiece + 2 || row === rowOfFirstPiece - 2) &&
      (column === columnOfFirstPiece + 1 ||
        column === columnOfFirstPiece - 1) &&
      this.board[this.getValueNumbers(row, column)].substring(1) !== color
    ) {
      {
        return true;
      }
    }
    if (
      (row === rowOfFirstPiece + 1 || row === rowOfFirstPiece - 1) &&
      (column === columnOfFirstPiece + 2 ||
        column === columnOfFirstPiece - 2) &&
      this.board[this.getValueNumbers(row, column)].substring(1) !== color
    ) {
      return true;
    }
    return false;
  }

  checkBishop(
    row: number,
    rowOfFirstPiece: number,
    column: number,
    columnOfFirstPiece: number,
    color: string
  ) {
    let king;
    if (color === 'W') {
      king = 'KW';
    } else if (color === 'B') {
      king = 'KB';
    }
    if (
      (row - column === rowOfFirstPiece - columnOfFirstPiece ||
        row + column === rowOfFirstPiece + columnOfFirstPiece) &&
      row !== rowOfFirstPiece
    ) {
      let storage = columnOfFirstPiece;
      for (let i = rowOfFirstPiece + 1; i <= row; i++) {
        if (column > columnOfFirstPiece) {
          storage = storage + 1;
        } else {
          storage = storage - 1;
        }
        if (this.board[this.getValueNumbers(i, storage)] !== '' && i < row) {
          return false;
        }
        if (
          this.board[this.getValueNumbers(i, storage)].substring(1) === color &&
          i === row
        ) {
          return false;
        } else if (
          this.board[this.getValueNumbers(i, storage)].substring(1) !== color &&
          i === row
        ) {
          return true;
        }
      }
      for (let i = rowOfFirstPiece - 1; i >= row; i--) {
        if (column > columnOfFirstPiece) {
          storage = storage + 1;
        } else {
          storage = storage - 1;
        }
        if (this.board[this.getValueNumbers(i, storage)] !== '' && i > row) {
          return false;
        }
        if (
          this.board[this.getValueNumbers(i, storage)].substring(1) === color &&
          i === row
        ) {
          return false;
        } else if (
          this.board[this.getValueNumbers(i, storage)].substring(1) !== color &&
          i === row
        ) {
          return true;
        }
      }
      return true;
    }

    return false;
  }

  checkQueen(
    row: number,
    rowOfFirstPiece: number,
    column: number,
    columnOfFirstPiece: number,
    color: string
  ) {
    const rookMove = this.checkRook(
      row,
      rowOfFirstPiece,
      column,
      columnOfFirstPiece,
      color
    );
    const bishopMove = this.checkBishop(
      row,
      rowOfFirstPiece,
      column,
      columnOfFirstPiece,
      color
    );

    return rookMove || bishopMove;
  }

  checkKing(
    row: number,
    rowOfFirstPiece: number,
    column: number,
    columnOfFirstPiece: number,
    color: string
  ) {
    if (
      Math.abs(row - rowOfFirstPiece) === 1 ||
      Math.abs(column - columnOfFirstPiece) === 1
    ) {
      const rookMove = this.checkRook(
        row,
        rowOfFirstPiece,
        column,
        columnOfFirstPiece,
        color
      );

      const bishopMove = this.checkBishop(
        row,
        rowOfFirstPiece,
        column,
        columnOfFirstPiece,
        color
      );

      return rookMove || bishopMove;
    }

    if (color === 'W') {
      if (
        !this.whiteKingMoved &&
        !this.whiteRookMoved1 &&
        this.board[1] === '' &&
        this.board[2] === '' &&
        this.board[3] === '' &&
        row === 1 &&
        column === 3
      ) {
        this.castleWhiteGreat = true;
        return true;
      }
      if (
        !this.whiteKingMoved &&
        !this.whiteRookMoved8 &&
        this.board[5] === '' &&
        this.board[6] === '' &&
        row === 1 &&
        column === 7
      ) {
        this.castleWhiteSmall = true;
        return true;
      }
    }
    if (color === 'B') {
      if (
        !this.blackKingMoved &&
        !this.blackRookMoved1 &&
        this.board[57] === '' &&
        this.board[58] === '' &&
        this.board[59] === '' &&
        row === 8 &&
        column === 3
      ) {
        this.castleBlackGreat = true;
        return true;
      }
      if (
        !this.blackKingMoved &&
        !this.blackRookMoved8 &&
        this.board[61] === '' &&
        this.board[62] === '' &&
        row === 8 &&
        column === 7
      ) {
        this.castleBlackSmall = true;
        return true;
      }
    }

    return false;
  }

  findRowandColumn(piece: string | undefined) {
    let place = 0;
    let row = 0;
    let column = 0;
    for (var i = 0; i < 64; i++) {
      if (this.board[i] === piece) {
        place = i + 1;
      }
    }
    if (place % 8 === 0) {
      row = place / 8;
      column = 8;
    } else {
      column = place % 8;
      row = Math.ceil(place / 8);
    }
    return [row, column];
  }

  getRow(position: number) {
    const positionPlusOne = position + 1;
    if (positionPlusOne % 8 === 0) {
      return positionPlusOne / 8;
    } else {
      return Math.ceil(positionPlusOne / 8);
    }
  }

  getColumn(position: number) {
    const positionPlusOne = position + 1;
    if (positionPlusOne % 8 === 0) {
      return 8;
    } else {
      return positionPlusOne % 8;
    }
  }

  checkIfCheck(nextMove: boolean) {
    let color = 'B';
    let piece = 'KW';
    if (!nextMove) {
      color = 'W';
      piece = 'KB';
    }

    const pawn = 'P' + color;
    const rook = 'R' + color;
    const knight = 'S' + color;
    const bishop = 'B' + color;
    const queen = 'Q' + color;
    const king = 'K' + color;

    console.log(rook, knight, bishop, queen, king, piece);

    for (var i = 0; i < 64; i++) {
      if (this.board[i] === pawn) {
        if (nextMove) {
          console.log('Check' + i);
          console.log(
            this.possibleCheckByPB(this.getRow(i), this.getColumn(i))
          );
          console.log(this.getRow(i));
          console.log(this.getColumn(i));
          if (this.possibleCheckByPB(this.getRow(i), this.getColumn(i))) {
            return true;
          }
        } else {
          console.log('Check' + i);
          console.log(
            this.possibleCheckByPW(this.getRow(i), this.getColumn(i))
          );
          console.log(this.getRow(i));
          console.log(this.getColumn(i));
          if (this.possibleCheckByPW(this.getRow(i), this.getColumn(i))) {
            return true;
          }
        }
      }
      if (this.board[i] === rook) {
        console.log('Check' + i);
        console.log(
          this.possibleCheckByRook(this.getRow(i), this.getColumn(i), piece)
        );
        console.log(this.getRow(i));
        console.log(this.getColumn(i));
        if (
          this.possibleCheckByRook(this.getRow(i), this.getColumn(i), piece)
        ) {
          return true;
        }
      }

      if (this.board[i] === knight) {
        console.log('Check' + i);
        console.log(
          this.possibleCheckByKnight(this.getRow(i), this.getColumn(i), piece)
        );
        console.log(this.getRow(i));
        console.log(this.getColumn(i));
        if (
          this.possibleCheckByKnight(this.getRow(i), this.getColumn(i), piece)
        ) {
          return true;
        }
      }

      if (this.board[i] === bishop) {
        console.log('Check' + i);
        console.log(
          this.possibleCheckByBishop(this.getRow(i), this.getColumn(i), piece)
        );
        console.log(this.getRow(i));
        console.log(this.getColumn(i));
        if (
          this.possibleCheckByBishop(this.getRow(i), this.getColumn(i), piece)
        ) {
          return true;
        }
      }

      if (this.board[i] === queen) {
        console.log('Check' + i);
        console.log(
          this.possibleCheckByQueen(this.getRow(i), this.getColumn(i), piece)
        );
        console.log(this.getRow(i));
        console.log(this.getColumn(i));
        if (
          this.possibleCheckByQueen(this.getRow(i), this.getColumn(i), piece)
        ) {
          return true;
        }
      }

      if (this.board[i] === king) {
        console.log('Check' + i);
        console.log(
          this.possibleCheckByKing(this.getRow(i), this.getColumn(i), piece)
        );
        console.log(this.getRow(i));
        console.log(this.getColumn(i));
        if (
          this.possibleCheckByKing(this.getRow(i), this.getColumn(i), piece)
        ) {
          return true;
        }
      }
    }

    return false;
  }

  possibleCheckByPW(row: number, column: number) {
    if (
      (column < 8 &&
        row < 8 &&
        this.board[this.getValueNumbers(row + 1, column + 1)] === 'KB') ||
      (column > 1 &&
        row < 8 &&
        this.board[this.getValueNumbers(row + 1, column - 1)] === 'KB')
    ) {
      return true;
    }
    return false;
  }

  possibleCheckByPB(row: number, column: number) {
    if (
      (column < 8 &&
        row > 1 &&
        this.board[this.getValueNumbers(row - 1, column + 1)] === 'KW') ||
      (column > 1 &&
        row > 1 &&
        this.board[this.getValueNumbers(row - 1, column - 1)] === 'KW')
    ) {
      return true;
    }
    return false;
  }

  possibleCheckByRook(row: number, column: number, piece: string) {
    let noBlockade = true;
    const rowKing = this.findRowandColumn(piece)[0];
    const columnKing = this.findRowandColumn(piece)[1];

    if (row !== rowKing && column !== columnKing) {
      return false;
    }

    if (row === rowKing) {
      if (column > columnKing) {
        for (var i = column - 1; i > columnKing; i--) {
          if (this.board[this.getValueNumbers(row, i)] !== '') {
            noBlockade = false;
          }
        }
      }
      if (column < columnKing) {
        for (var i = column + 1; i < columnKing; i++) {
          if (this.board[this.getValueNumbers(row, i)] !== '') {
            noBlockade = false;
          }
        }
      }
    }

    if (column === columnKing) {
      if (row > rowKing) {
        for (var i = row - 1; i > rowKing; i--) {
          if (this.board[this.getValueNumbers(i, column)] !== '') {
            noBlockade = false;
          }
        }
      }
      if (row < rowKing) {
        for (var i = row + 1; i < rowKing; i++) {
          if (this.board[this.getValueNumbers(i, column)] !== '') {
            noBlockade = false;
          }
        }
      }
    }
    if (noBlockade) {
      return true;
    } else {
      return false;
    }
  }

  possibleCheckByKnight(row: number, column: number, piece: string) {
    if (
      (row < 7 &&
        column < 8 &&
        this.board[this.getValueNumbers(row + 2, column + 1)] === piece) ||
      (row < 7 &&
        column > 1 &&
        this.board[this.getValueNumbers(row + 2, column - 1)] === piece) ||
      (row < 8 &&
        column < 7 &&
        this.board[this.getValueNumbers(row + 1, column + 2)] === piece) ||
      (row < 8 &&
        column > 2 &&
        this.board[this.getValueNumbers(row + 1, column - 2)] === piece) ||
      (row > 1 &&
        column < 7 &&
        this.board[this.getValueNumbers(row - 1, column + 2)] === piece) ||
      (row > 1 &&
        column > 2 &&
        this.board[this.getValueNumbers(row - 1, column - 2)] === piece) ||
      (row > 2 &&
        column < 8 &&
        this.board[this.getValueNumbers(row - 2, column + 1)] === piece) ||
      (row > 2 &&
        column > 1 &&
        this.board[this.getValueNumbers(row - 2, column - 1)] === piece)
    ) {
      return true;
    }

    return false;
  }

  possibleCheckByBishop(row: number, column: number, piece: string) {
    let noBlockade = true;
    const rowKing = this.findRowandColumn(piece)[0];
    const columnKing = this.findRowandColumn(piece)[1];

    if (
      row - column !== rowKing - columnKing &&
      row + column !== rowKing + columnKing
    ) {
      return false;
    }

    if (row - column === rowKing - columnKing) {
      if (row > rowKing) {
        let storage = column;
        for (var i = row - 1; i > rowKing; i--) {
          if (storage <= 1) {
            noBlockade = false;
            break;
          }
          storage = storage - 1;
          if (this.board[this.getValueNumbers(i, storage)] !== '') {
            noBlockade = false;
          }
        }
      }

      if (row < rowKing) {
        let storage = column;
        for (var i = row + 1; i < rowKing; i++) {
          if (storage >= 8) {
            noBlockade = false;
            break;
          }
          storage = storage + 1;
          if (this.board[this.getValueNumbers(i, storage)] !== '') {
            noBlockade = false;
          }
        }
      }
    }

    if (row + column === rowKing + columnKing) {
      if (column > columnKing) {
        let storage = row;
        for (var i = column - 1; i > columnKing; i--) {
          if (storage >= 8) {
            noBlockade = false;
            break;
          }
          storage = storage + 1;
          if (this.board[this.getValueNumbers(storage, i)] !== '') {
            noBlockade = false;
          }
        }
      }
      if (column < columnKing) {
        let storage = row;
        for (var i = column + 1; i < columnKing; i++) {
          if (storage <= 1) {
            noBlockade = false;
            break;
          }
          storage = storage - 1;
          if (this.board[this.getValueNumbers(storage, i)] !== '') {
            noBlockade = false;
          }
        }
      }
    }
    if (noBlockade) {
      return true;
    } else {
      return false;
    }
  }

  possibleCheckByQueen(row: number, column: number, piece: string) {
    const checkBishop = this.possibleCheckByBishop(row, column, piece);
    const checkRook = this.possibleCheckByRook(row, column, piece);
    return checkBishop || checkRook;
  }

  possibleCheckByKing(row: number, column: number, piece: string) {
    if (
      (column < 8 &&
        row > 1 &&
        this.board[this.getValueNumbers(row - 1, column + 1)] === piece) ||
      (column > 1 &&
        row > 1 &&
        this.board[this.getValueNumbers(row - 1, column - 1)] === piece) ||
      (column < 8 &&
        row < 8 &&
        this.board[this.getValueNumbers(row + 1, column + 1)] === piece) ||
      (column > 1 &&
        row < 8 &&
        this.board[this.getValueNumbers(row + 1, column - 1)] === piece) ||
      (row < 8 &&
        this.board[this.getValueNumbers(row + 1, column)] === piece) ||
      (row > 1 &&
        this.board[this.getValueNumbers(row - 1, column)] === piece) ||
      (column < 8 &&
        this.board[this.getValueNumbers(row, column + 1)] === piece) ||
      (column > 1 &&
        this.board[this.getValueNumbers(row, column - 1)] === piece)
    ) {
      return true;
    }
    return false;
  }
}
