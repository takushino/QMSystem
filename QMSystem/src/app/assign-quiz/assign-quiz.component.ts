import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { AuthService } from '../services/auth.service';
import { User } from '../model/user.model';
import { Subscription } from 'rxjs';
import { AssignService } from '../services/assign.service';

@Component({
  selector: 'app-assign-quiz',
  templateUrl: './assign-quiz.component.html',
  styleUrls: ['./assign-quiz.component.scss']
})
export class AssignQuizComponent implements OnInit {
  constructor(private router: Router, private authService: AuthService, private quizAssignerService: AssignService) { }

  assignment = {
    quizid: '',
    userid: '',
    attempts: 5
  };

  user: User;
  userSubscription: Subscription;

  ngOnInit() {
    this.userSubscription = this.authService.$currentUser.subscribe((user: User) => {
      this.user = user;
    });
    if (!this.user) {
      this.router.navigateByUrl('/login');
    }
  }

  return() { this.router.navigateByUrl('/mmain'); }

  Assign() {
    this.quizAssignerService.assign(this.assignment);
  }
}
