import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';

@Injectable({
  providedIn: 'root'
})
export class TakeQuizService {

  constructor(private httpClient: HttpClient) { }

  takeQuiz(quizID: any) {
    this.httpClient.post('http://localhost:8080/QMSystem/takeQuiz', quizID, {
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
    let html = '';
    // tslint:disable-next-line: prefer-for-of
    for (let i = 0; i < rows.length; i++) {
      html += '<table border=\'1|1\'>';
      html += '<tr>' + rows[i].question + '</tr>';
      html += '<tr>' + rows[i].correct + '</tr>';
      html += '<tr>' + rows[i].wrong1 + '</tr>';
      html += '<tr>' + rows[i].wrong2 + '</tr>';
      html += '<tr>' + rows[i].wrong3 + '</tr>';
      html += '</table><br>';
    }
    document.getElementById('assignedquizbox').innerHTML = html;
  }
}
