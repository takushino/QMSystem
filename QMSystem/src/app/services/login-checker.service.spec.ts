import { TestBed } from '@angular/core/testing';

import { LoginCheckerService } from './login-checker.service';

describe('LoginCheckerService', () => {
  beforeEach(() => TestBed.configureTestingModule({}));

  it('should be created', () => {
    const service: LoginCheckerService = TestBed.get(LoginCheckerService);
    expect(service).toBeTruthy();
  });
});
