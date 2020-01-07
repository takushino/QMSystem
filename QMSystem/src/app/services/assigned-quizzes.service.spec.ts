import { TestBed } from '@angular/core/testing';

import { AssignedQuizzesService } from './assigned-quizzes.service';

describe('AssignedQuizzesService', () => {
  beforeEach(() => TestBed.configureTestingModule({}));

  it('should be created', () => {
    const service: AssignedQuizzesService = TestBed.get(AssignedQuizzesService);
    expect(service).toBeTruthy();
  });
});
