import { ComponentFixture, TestBed } from '@angular/core/testing';

import { DetailsMeleeComponent } from './details-melee.component';

describe('DetailsMeleeComponent', () => {
  let component: DetailsMeleeComponent;
  let fixture: ComponentFixture<DetailsMeleeComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ DetailsMeleeComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(DetailsMeleeComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
