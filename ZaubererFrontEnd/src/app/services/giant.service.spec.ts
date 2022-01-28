import { TestBed } from '@angular/core/testing';

import { GiantService } from './giant.service';

describe('GiantService', () => {
  let service: GiantService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(GiantService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
