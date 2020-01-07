import { TestBed } from '@angular/core/testing';

import { QuestionMakerService } from './question-maker.service';

describe('QuestionMakerService', () => {
  beforeEach(() => TestBed.configureTestingModule({}));

  it('should be created', () => {
    const service: QuestionMakerService = TestBed.get(QuestionMakerService);
    expect(service).toBeTruthy();
  });
});
