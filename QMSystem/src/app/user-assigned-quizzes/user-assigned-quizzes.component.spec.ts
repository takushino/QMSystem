import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { UserAssignedQuizzesComponent } from './user-assigned-quizzes.component';

describe('UserAssignedQuizzesComponent', () => {
  let component: UserAssignedQuizzesComponent;
  let fixture: ComponentFixture<UserAssignedQuizzesComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ UserAssignedQuizzesComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(UserAssignedQuizzesComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
