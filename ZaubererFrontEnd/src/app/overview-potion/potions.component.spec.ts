import { ComponentFixture, TestBed } from '@angular/core/testing';

import { OverviewPotionComponent } from './potions.component';

describe('PotionsComponent', () => {
  let component: OverviewPotionComponent;
  let fixture: ComponentFixture<OverviewPotionComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ OverviewPotionComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(OverviewPotionComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
