import { TestBed } from '@angular/core/testing';

import { GetQuizzesService } from './get-quizzes.service';

describe('GetQuizzesService', () => {
  beforeEach(() => TestBed.configureTestingModule({}));

  it('should be created', () => {
    const service: GetQuizzesService = TestBed.get(GetQuizzesService);
    expect(service).toBeTruthy();
  });
});
