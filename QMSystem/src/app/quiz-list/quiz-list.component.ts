import { Component, OnInit } from '@angular/core';
import { GetQuizzesService } from '../services/get-quizzes.service';

@Component({
  selector: 'app-quiz-list',
  templateUrl: './quiz-list.component.html',
  styleUrls: ['./quiz-list.component.scss']
})
export class QuizListComponent implements OnInit {

  constructor(private getQuizzesService: GetQuizzesService) { }

  ngOnInit() {
    this.getQuizzesService.getQuizzes();
  }

}
