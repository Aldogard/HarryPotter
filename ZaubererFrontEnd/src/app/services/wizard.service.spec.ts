import { TestBed } from '@angular/core/testing';

import { WizardService } from './wizard.service';

describe('HarrypotterService', () => {
  let service: WizardService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(WizardService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
