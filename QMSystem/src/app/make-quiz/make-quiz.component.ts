import { Component, OnInit } from '@angular/core';
import { QuizMakerService } from '../services/quiz-maker.service';
import { Router } from '@angular/router';
import { AuthService } from '../services/auth.service';
import { User } from '../model/user.model';
import { Subscription } from 'rxjs';

@Component({
  selector: 'app-make-quiz',
  templateUrl: './make-quiz.component.html',
  styleUrls: ['./make-quiz.component.scss']
})
export class MakeQuizComponent implements OnInit {
  constructor(private router: Router, private authService: AuthService, private quizMakerService: QuizMakerService) { }

  quiz = {
    title: '',
    questionSequence: '',
    creator: 0
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
    this.quiz.creator = this.user.user_id;
    this.quizMakerService.create(this.quiz);
  }
}
