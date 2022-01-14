import { Component, OnInit } from '@angular/core';

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
    ' ',
    ' ',
    ' ',
    ' ',
    ' ',
    ' ',
    ' ',
    ' ',
    ' ',
    ' ',
    ' ',
    ' ',
    ' ',
    ' ',
    ' ',
    ' ',
    ' ',
    ' ',
    ' ',
    ' ',
    ' ',
    ' ',
    ' ',
    ' ',
    ' ',
    ' ',
    ' ',
    ' ',
    ' ',
    ' ',
    ' ',
    ' ',
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
    const legal = this.checkLegality(parseInt(row), column.charCodeAt(0) - 64, nameOfPiece)
    console.log(legal);
    if (this.firstPiece !== '' && legal) {
      this.board[this.getValue(row, column)] = this.firstPiece;
      this.firstPiece = '';
      this.board[this.getValue(this.rowOfFirstPiece, this.columnOfFirstPiece)] =
        '';
    } else {
      console.log("This move is not legal")
    }
  }

  getValue(row: string, column: string) {
    const value = (parseInt(row) - 1) * 8;
    const value2 = column.charCodeAt(0) - 64;
    const position = value + value2 - 1;
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
    console.log(rowOfFirstPiece + 2 === row);
    console.log(columnOfFirstPiece === column);
    console.log(rowOfFirstPiece === 2);
    console.log('TestEnde');

    if (nameOfPiece === 'PW') {
      return this.checkPW(row, rowOfFirstPiece, column, columnOfFirstPiece);
    }

    if (nameOfPiece === 'PB') {
      return this.checkPB(row, rowOfFirstPiece, column, columnOfFirstPiece);
    }

    return false;


  }

  checkPW(
    row: number,
    rowOfFirstPiece: number,
    column: number,
    columnOfFirstPiece: number
  ) {
    if (row === rowOfFirstPiece + 1 && column === columnOfFirstPiece) {
      return true;
    }
    if (
      row === rowOfFirstPiece + 2 &&
      rowOfFirstPiece === 2 &&
      column === columnOfFirstPiece
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
    if (row === rowOfFirstPiece - 1 && column === columnOfFirstPiece) {
      return true;
    }
    if (
      row === rowOfFirstPiece - 2 &&
      rowOfFirstPiece === 7 &&
      column === columnOfFirstPiece
    ) {
      return true;
    }
    return false;
  }
}
