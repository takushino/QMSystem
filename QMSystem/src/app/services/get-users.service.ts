import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';

@Injectable({
  providedIn: 'root'
})
export class GetUsersService {
  constructor(private httpClient: HttpClient) { }

  getUsers() { //
    this.httpClient.get('http://localhost:8080/QMSystem/users', {
      withCredentials: true // processes only if cedentials are filled ?
    }).subscribe( //
      data => { // if successful / 200's is returned
        console.log(data);
        this.tablemaker(data);
      },
      err => { // if successful / 400's is returned
        console.log(err);
      }
    );
  }

  tablemaker(rows: any) {
    let html = '<table border=\'1|1\'>';
    html += '<tr><td>User<br>ID</td><td>User<br>Name</td></tr>';
    // tslint:disable-next-line: prefer-for-of
    for (let i = 0; i < rows.length; i++) {
      html += '<tr>';
      html += '<td>' + rows[i].user_id + '</td>';
      html += '<td>' + rows[i].username + '</td>';
      html += '</tr>';
    }
    html += '</table>';
    document.getElementById('userbox').innerHTML = html;
  }
}
