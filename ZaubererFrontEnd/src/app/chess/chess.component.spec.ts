import { ComponentFixture, TestBed } from '@angular/core/testing';
import { ChessComponent } from './chess.component';

describe('ChessComponent', () => {
  let component: ChessComponent;
  let fixture: ComponentFixture<ChessComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ ChessComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(ChessComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });

  it("Should find a piece", () => {
    const getColumn = component.getColumn(0);
    expect(getColumn).toBe(1);
  })
});
