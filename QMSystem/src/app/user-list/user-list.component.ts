import { Component, OnInit } from '@angular/core';

import { GetUsersService } from '../services/get-users.service';
@Component({
  selector: 'app-user-list',
  templateUrl: './user-list.component.html',
  styleUrls: ['./user-list.component.scss']
})
export class UserListComponent implements OnInit {

  constructor(private getUsersService: GetUsersService) { }

  ngOnInit() {
    this.getUsersService.getUsers();
  }

}
