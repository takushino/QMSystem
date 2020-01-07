import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';

@Injectable({
  providedIn: 'root'
})
export class GetQuestionsService {
  constructor(private httpClient: HttpClient) { }

  getQuestions() { //
    this.httpClient.get('http://localhost:8080/QMSystem/questions', {
      withCredentials: true // processes only if cedentials are filled ?
    }).subscribe( //
      data => { // if successful / 200's is returned
        console.log(data);
        this.tablemaker(data);
      },
      err => { // if successful / 400's is returned
      }
    );
  }

  tablemaker(rows: any) {
    let html = '<table border=\'1|1\'>';
    html += '<tr><td>Question<br>ID</td><td>Question</td><td>Correct<br>Answer</td>';
    html += '<td>Wrong 1</td><td>Wrong 2</td><td>Wrong 3</td><td>Explanation</td></tr>';
    // tslint:disable-next-line: prefer-for-of
    for (let i = 0; i < rows.length; i++) {
      html += '<tr>';
      html += '<td>' + rows[i].question_id + '</td>';
      html += '<td>' + rows[i].question + '</td>';
      html += '<td>' + rows[i].correct + '</td>';
      html += '<td>' + rows[i].wrong1 + '</td>';
      html += '<td>' + rows[i].wrong2 + '</td>';
      html += '<td>' + rows[i].wrong3 + '</td>';
      html += '<td>' + rows[i].explanation + '</td>';
      html += '</tr>';
    }
    html += '</table>';
    document.getElementById('box').innerHTML = html;
  }
}

