import { ComponentFixture, TestBed } from '@angular/core/testing';

import { OverviewSpellComponent } from './spells.component';

describe('AttacksComponent', () => {
  let component: OverviewSpellComponent;
  let fixture: ComponentFixture<OverviewSpellComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ OverviewSpellComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(OverviewSpellComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
