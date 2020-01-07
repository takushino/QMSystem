import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';

@Injectable({
  providedIn: 'root'
})
export class AssignedQuizzesService {


  constructor(private httpClient: HttpClient) { }

  getQuizzes() { //
    this.httpClient.get('http://localhost:8080/QMSystem/assignedQuizzes', {
      withCredentials: true // what the heck is this line
    }).subscribe( //
      data => { // if successful / 200's is returned
        this.tablemaker(data);
      },
      err => { // if successful / 400's is returned
        console.log(err);
      }
    );
  }

  tablemaker(rows: any) {
    let html = '<table border=\'1|1\'>';
    html += '<tr><td>Quiz<br>ID</td><td>Quiz<br>Title</td><td>Max Attempts</td><td>Current Attempts</td></tr>';
    // tslint:disable-next-line: prefer-for-of
    for (let i = 0; i < rows.length; i++) {
      html += '<tr>';
      html += '<td>' + rows[i].quizid + '</td>';
      html += '<td>' + rows[i].quiztitle + '</td>';
      html += '<td>' + rows[i].attempts + '</td>';
      html += '<td>' + rows[i].takenAttempts + '</td>';
      html += '</tr>';
    }
    html += '</table>';
    document.getElementById('assignedquizbox').innerHTML = html;
  }
}
