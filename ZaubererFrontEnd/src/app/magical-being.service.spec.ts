import { TestBed } from '@angular/core/testing';

import { MagicalBeingService } from './magical-being.service';

describe('MagicalBeingService', () => {
  let service: MagicalBeingService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(MagicalBeingService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
