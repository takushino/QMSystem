import { TestBed } from '@angular/core/testing';

import { QuizMakerService } from './quiz-maker.service';

describe('QuizMakerService', () => {
  beforeEach(() => TestBed.configureTestingModule({}));

  it('should be created', () => {
    const service: QuizMakerService = TestBed.get(QuizMakerService);
    expect(service).toBeTruthy();
  });
});
