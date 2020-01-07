import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';

@Injectable({
  providedIn: 'root'
})
export class GetQuizzesService {

  constructor(private httpClient: HttpClient) { }

  getQuizzes() { //
    this.httpClient.get('http://localhost:8080/QMSystem/quizzes', {
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
    html += '<tr><td>Quiz<br>ID</td><td>Quiz<br>Title</td><td>Quiz<br>Author</td></tr>';
    // tslint:disable-next-line: prefer-for-of
    for (let i = 0; i < rows.length; i++) {
      html += '<tr>';
      html += '<td>' + rows[i].quiz_id + '</td>';
      html += '<td>' + rows[i].title + '</td>';
      html += '<td>' + rows[i].creator + '</td>';
      html += '</tr>';
    }
    html += '</table>';
    document.getElementById('quizbox').innerHTML = html;
  }
}


