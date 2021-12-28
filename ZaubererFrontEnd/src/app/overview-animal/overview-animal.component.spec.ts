import { ComponentFixture, TestBed } from '@angular/core/testing';

import { OverviewAnimalComponent } from './overview-animal.component';

describe('OverviewAnimalComponent', () => {
  let component: OverviewAnimalComponent;
  let fixture: ComponentFixture<OverviewAnimalComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ OverviewAnimalComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(OverviewAnimalComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
