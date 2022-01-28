import { TestBed } from '@angular/core/testing';

import { ExtraService } from './extra.service';

describe('ZusatzService', () => {
  let service: ExtraService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(ExtraService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
