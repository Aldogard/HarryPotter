import { ComponentFixture, TestBed } from '@angular/core/testing';

import { OverviewMeleeComponent } from './overview-melee.component';

describe('OverviewMeleeComponent', () => {
  let component: OverviewMeleeComponent;
  let fixture: ComponentFixture<OverviewMeleeComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ OverviewMeleeComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(OverviewMeleeComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
