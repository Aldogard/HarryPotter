import { Component, OnInit } from '@angular/core';
import { BehaviorSubject } from 'rxjs';

@Component({
  selector: 'app-chess',
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
  attackPiece: string = '';
  checkWhiteKing = new BehaviorSubject<boolean>(false);
  checkBlackKing = new BehaviorSubject<boolean>(false);

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

  constructor() {}

  ngOnInit(): void {}

  getPiece(row: string, column: string) {
    if (this.firstPiece === '') {
      this.firstPiece = this.board[this.getValue(row, column)];
      this.rowOfFirstPiece = row;
      this.columnOfFirstPiece = column;
    }
  }

  movePiece(row: string, column: string) {
    const nameOfPiece =
      this.board[this.getValue(this.rowOfFirstPiece, this.columnOfFirstPiece)];

    const legal = this.checkLegality(
      parseInt(row),
      column.charCodeAt(0) - 64,
      nameOfPiece
    );

    if (this.firstPiece !== '' && legal) {
      this.board[this.getValue(row, column)] = this.firstPiece;
      this.firstPiece = '';
      this.board[this.getValue(this.rowOfFirstPiece, this.columnOfFirstPiece)] =
        '';
      console.log(this.attackPiece);
      this.nextMove.next(!this.nextMove.value);
      this.moves.push(nameOfPiece + ' ' + column + row);
    } else {
      console.log('This move is not legal');
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
    console.log(row);
    console.log(column);
    console.log('P:' + position);
    return position;
  }

  showPiece(row: string, column: string) {
    return this.board[this.getValue(row, column)];
  }

  checkLegality(row: number, column: number, nameOfPiece: string) {
    const rowOfFirstPiece = parseInt(this.rowOfFirstPiece);
    const columnOfFirstPiece = this.columnOfFirstPiece.charCodeAt(0) - 64;

    console.log('Test');
    console.log(nameOfPiece);
    console.log(rowOfFirstPiece);
    console.log(columnOfFirstPiece);
    console.log(row);
    console.log(column);
    console.log('TestEnde');

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
      this.attackPiece = this.board[this.getValueNumbers(row, column)];
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
      return true;
    }
    if (
      (row === rowOfFirstPiece - 1 &&
        column === columnOfFirstPiece + 1 &&
        this.board[this.getValueNumbers(row, column)].substring(1) === 'W') ||
      (row === rowOfFirstPiece - 1 &&
        column === columnOfFirstPiece - 1 &&
        this.board[this.getValueNumbers(row, column)].substring(1) === 'W')
    ) {
      this.attackPiece = this.board[this.getValueNumbers(row, column)];
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
          this.attackPiece = this.board[this.getValueNumbers(row, column)];
          return true;
        }
      }
      for (var i = rowOfFirstPiece - 1; i >= row; i--) {
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
          this.attackPiece = this.board[this.getValueNumbers(row, column)];
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
          this.attackPiece = this.board[this.getValueNumbers(row, column)];
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
          this.attackPiece = this.board[this.getValueNumbers(row, column)];
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
    if (
      (row === rowOfFirstPiece + 2 || row === rowOfFirstPiece - 2) &&
      (column === columnOfFirstPiece + 1 ||
        column === columnOfFirstPiece - 1) &&
      this.board[this.getValueNumbers(row, column)].substring(1) !== color
    ) {
      this.attackPiece = this.board[this.getValueNumbers(row, column)];
      return true;
    }
    if (
      (row === rowOfFirstPiece + 1 || row === rowOfFirstPiece - 1) &&
      (column === columnOfFirstPiece + 2 ||
        column === columnOfFirstPiece - 2) &&
      this.board[this.getValueNumbers(row, column)].substring(1) !== color
    ) {
      this.attackPiece = this.board[this.getValueNumbers(row, column)];
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
          this.attackPiece = this.board[this.getValueNumbers(row, column)];
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
          console.log('Test10');
          return false;
        }
        if (
          this.board[this.getValueNumbers(i, storage)].substring(1) === color &&
          i === row
        ) {
          console.log('Test11');
          return false;
        } else if (
          this.board[this.getValueNumbers(i, storage)].substring(1) !== color &&
          i === row
        ) {
          this.attackPiece = this.board[this.getValueNumbers(row, column)];
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

      if (color === 'W') {
        return (
          (rookMove || bishopMove) &&
          !this.checkIfWhiteKingMovesIntoCheck(row, column)
        );
      }
      if (color === 'B') {
        return (
          (rookMove || bishopMove) &&
          !this.checkIfBlackKingMovesIntoCheck(row, column)
        );
      }
    }

    return false;
  }

  // checkIfCheckPawnWhite(row: number, column: number) {
  //   if (this.board[this.getValueNumbers(row + 1, column + 1)] === 'KB') {
  //     this.checkWhiteKing.next(true);
  //     alert('Check');
  //   }
  //   if (this.board[this.getValueNumbers(row + 1, column - 1)] === 'KB') {
  //     this.checkWhiteKing.next(true);
  //     alert('Check');
  //   }
  // }

  // checkIfCheckPawnBlack(row: number, column: number) {
  //   if (this.board[this.getValueNumbers(row - 1, column - 1)] === 'KW') {
  //     this.checkWhiteKing.next(true);
  //     alert('Check');
  //   }
  //   if (this.board[this.getValueNumbers(row - 1, column + 1)] === 'KW') {
  //     this.checkWhiteKing.next(true);
  //     alert('Check');
  //   }
  // }

  checkIfWhiteKingInCheck(row: number, column: number) {
    let rowKing = this.findRowandColumn('KW')[0];
    let columnKing = this.findRowandColumn('KW')[1];

    console.log('Test123');
    console.log(rowKing);
    console.log(columnKing);
    console.log('TestEnde');

    if (
      this.board[this.getValueNumbers(rowKing + 1, columnKing + 1)] === 'PB' ||
      this.board[this.getValueNumbers(rowKing + 1, columnKing - 1)] === 'PB'
    ) {
      alert('Check');
      this.checkWhiteKing.next(true);
      return true;
    }
    return false;
  }

  checkIfWhiteKingMovesIntoCheck(row: number, column: number) {
    if (
      this.board[this.getValueNumbers(row + 1, column + 1)] === 'PB' ||
      this.board[this.getValueNumbers(row + 1, column - 1)] === 'PB'
    ) {
      alert('Check');
      return true;
    }
    return false;
  }
  checkIfBlackKingInCheck(row: number, column: number) {
    let rowKing = this.findRowandColumn('KB')[0];
    let columnKing = this.findRowandColumn('KB')[1];

    console.log('Test123');
    console.log(rowKing);
    console.log(columnKing);
    console.log('TestEnde');

    if (
      this.board[this.getValueNumbers(rowKing - 1, columnKing + 1)] === 'PW' ||
      this.board[this.getValueNumbers(rowKing - 1, columnKing - 1)] === 'PW'
    ) {
      alert('Check');
      this.checkWhiteKing.next(true);
      return true;
    }
    return false;
  }

  checkIfBlackKingMovesIntoCheck(row: number, column: number) {
    console.log("TEST")
    if (
      this.board[this.getValueNumbers(row - 1, column + 1)] === 'PW' ||
      this.board[this.getValueNumbers(row - 1, column - 1)] === 'PW'
    ) {
      alert('Check');
      this.checkBlackKing.next(true);
      return true;
    }
    return false;
  }

  findRowandColumn(king: string) {
    let place = 0;
    let row = 0;
    let column = 0;
    for (var i = 0; i < 64; i++) {
      if (this.board[i] === king) {
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
}
