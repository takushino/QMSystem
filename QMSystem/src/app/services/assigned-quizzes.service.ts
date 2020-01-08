import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';

@Injectable({
  providedIn: 'root'
})
export class AssignedQuizzesService {


  constructor(private httpClient: HttpClient) { }

  getMyQuizzes() { //
    this.httpClient.get('http://localhost:8080/QMSystem/assignedQuizzes', {
      withCredentials: true // what the heck is this line
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
    html += '<tr><td>Quiz<br>ID</td><td>Quiz<br>Title</td><td>Max Attempts</td>';
    html += '<td>Current Attempts</td><td>Take<br>Quiz</td><td>View<br>Past<br>Grades</td></tr>';
    // tslint:disable-next-line: prefer-for-of
    for (let i = 0; i < rows.length; i++) {
      html += '<tr>';
      html += '<td>' + rows[i].quiz_id + '</td>';
      html += '<td>' + rows[i].title + '</td>';
      html += '<td>' + rows[i].maxAttempts + '</td>';
      html += '<td>' + rows[i].currentAttempts + '</td>';
      html += '<td><button (click)="takeQuiz(' + rows[i].quizid + ')">Take Quiz</button></td>';
      html += '<td><button (click)="viewGrades(' + rows[i].quizid + ')">View Past Grades</button></td>';
      html += '</tr>';
    }
    html += '</table>';
    document.getElementById('assignedquizbox').innerHTML = html;
  }
}
