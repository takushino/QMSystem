import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { AuthService } from '../services/auth.service';
import { User } from '../model/user.model';
import { Subscription } from 'rxjs';

@Component({
  selector: 'app-manager-main',
  templateUrl: './manager-main.component.html',
  styleUrls: ['./manager-main.component.scss']
})
export class ManagerMainComponent implements OnInit {

  constructor(private router: Router, private authService: AuthService) { }

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

  makequestion() { this.router.navigateByUrl('/makeQuestion'); }
  makequiz() { this.router.navigateByUrl('/makeQuiz'); }
  assignquiz() { this.router.navigateByUrl('/AssignQuiz'); }
}
