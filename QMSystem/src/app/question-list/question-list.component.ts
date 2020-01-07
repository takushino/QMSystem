import { Component, OnInit } from '@angular/core';
import { GetQuestionsService } from '../services/get-questions.service';

@Component({
  selector: 'app-question-list',
  templateUrl: './question-list.component.html',
  styleUrls: ['./question-list.component.scss']
})
export class QuestionListComponent implements OnInit {

  constructor(private getQuestionsService: GetQuestionsService) { }

  ngOnInit() {
    this.getQuestionsService.getQuestions();
  }

}
