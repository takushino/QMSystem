import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Subject } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class AssignService {

  constructor(private httpClient: HttpClient) { }

  private responseMessageStream = new Subject<string>();
  $response = this.responseMessageStream.asObservable();

  assign(assignment: any) {
    console.log(assignment);
    this.httpClient.post('http://localhost:8080/QMSystem/assignQuiz', assignment, {
      withCredentials: true // processes only if cedentials are filled ?
    }).subscribe( //
      data => { // if successful / 200's is returned
        console.log(data);
        console.log('Quiz Created'); // prints error, not required
      },
      err => { // if successful / 400's is returned
        console.log(err);
        console.log('Quiz Creation Failed'); // sets error message?
      }
    );
  }
}
