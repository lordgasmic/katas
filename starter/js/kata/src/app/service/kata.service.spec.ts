import { TestBed } from '@angular/core/testing';

import { KataService } from './kata.service';

describe('KataService', () => {
  let service: KataService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(KataService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
