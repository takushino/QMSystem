import { Injectable } from '@angular/core';
import { Question } from '../model/question.model';
import { Subject } from 'rxjs';
import { HttpClient } from '@angular/common/http';

@Injectable({
  providedIn: 'root'
})
export class QuestionMakerService {

  constructor(private httpClient: HttpClient) { }

  private responseMessageStream = new Subject<string>();
  $response = this.responseMessageStream.asObservable();

  create(question: any) {
    console.log(question);
    this.httpClient.post<Question>('http://localhost:8080/QMSystem/makeQuestion', question, {
      withCredentials: true // processes only if cedentials are filled ?
    }).subscribe( //
      // tslint:disable-next-line: no-shadowed-variable
      question => { // if successful / 200's is returned
        console.log(question);
        console.log('Question Created'); // prints error, not required
      },
      err => { // if successful / 400's is returned
        console.log(err);
        console.log('Question Creation Failed'); // sets error message?
      }
    );
  }

}
