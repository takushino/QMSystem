import { Component, OnInit } from '@angular/core';
import { AssignedQuizzesService } from '../services/assigned-quizzes.service';
import { User } from '../model/user.model';
import { Router } from '@angular/router';
import { AuthService } from '../services/auth.service';
import { TakeQuizService } from '../services/take-quiz.service';

@Component({
  selector: 'app-user-assigned-quizzes',
  templateUrl: './user-assigned-quizzes.component.html',
  styleUrls: ['./user-assigned-quizzes.component.scss']
})
export class UserAssignedQuizzesComponent implements OnInit {
  userSubscription: any;
  user: any;

  constructor(private router: Router, private authService: AuthService,
              private assignedQuizzesService: AssignedQuizzesService, private takeQuizService: TakeQuizService) { }

  ngOnInit() {
    this.userSubscription = this.authService.$currentUser.subscribe((user: User) => {
      this.user = user;
    });
    if (!this.user) {
      this.router.navigateByUrl('/login');
    }
    this.assignedQuizzesService.getMyQuizzes();
  }

  takeQuiz(quizID: any) {
    this.takeQuizService.takeQuiz(quizID);
  }

  viewGrades(quizID: any) {

  }
}
