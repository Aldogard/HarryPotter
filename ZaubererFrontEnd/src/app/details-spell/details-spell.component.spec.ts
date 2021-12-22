import { ComponentFixture, TestBed } from '@angular/core/testing';

import { DetailsSpellComponent } from './details-spell.component';

describe('DetailsAttackComponent', () => {
  let component: DetailsSpellComponent;
  let fixture: ComponentFixture<DetailsSpellComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ DetailsSpellComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(DetailsSpellComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
