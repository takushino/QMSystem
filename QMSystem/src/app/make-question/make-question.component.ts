import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { AuthService } from '../services/auth.service';
import { User } from '../model/user.model';
import { Subscription } from 'rxjs';
import { QuestionMakerService } from '../services/question-maker.service';

@Component({
  selector: 'app-make-question',
  templateUrl: './make-question.component.html',
  styleUrls: ['./make-question.component.scss']
})
export class MakeQuestionComponent implements OnInit {

  constructor(private router: Router, private authService: AuthService, private questionMakerService: QuestionMakerService) { }

  question = {
    question: '',
    correct: '',
    wrong1: '',
    wrong2: '',
    wrong3: '',
    explanation: '',
    userid: 0
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

  Create() {
    this.question.userid = this.user.user_id;
    this.questionMakerService.create(this.question);
  }
}
