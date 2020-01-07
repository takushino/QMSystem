import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { AuthService } from '../services/auth.service';
import { User } from '../model/user.model';
import { Subscription } from 'rxjs';

@Component({
  selector: 'app-user-main',
  templateUrl: './user-main.component.html',
  styleUrls: ['./user-main.component.scss']
})
export class UserMainComponent implements OnInit {

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

  viewAssigned() { this.router.navigateByUrl('/viewMyQuizzes'); }
}
