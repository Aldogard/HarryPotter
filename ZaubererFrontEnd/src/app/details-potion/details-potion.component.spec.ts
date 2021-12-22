import { ComponentFixture, TestBed } from '@angular/core/testing';

import { DetailsPotionComponent } from './details-potion.component';

describe('DetailsPotionComponent', () => {
  let component: DetailsPotionComponent;
  let fixture: ComponentFixture<DetailsPotionComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ DetailsPotionComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(DetailsPotionComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
