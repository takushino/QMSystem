import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { AppRoutingModule } from './app-routing.module';
import { HttpClientModule } from '@angular/common/http';
import { AppComponent } from './app.component';
import { LoginComponent } from './login/login.component';
import { ManagerMainComponent } from './manager-main/manager-main.component';
import { UserMainComponent } from './user-main/user-main.component';
import { QuestionListComponent } from './question-list/question-list.component';
import { QuizListComponent } from './quiz-list/quiz-list.component';
import { MakeQuestionComponent } from './make-question/make-question.component';
import { MakeQuizComponent } from './make-quiz/make-quiz.component';
import { AssignQuizComponent } from './assign-quiz/assign-quiz.component';
import { UserListComponent } from './user-list/user-list.component';
import { UserAssignedQuizzesComponent } from './user-assigned-quizzes/user-assigned-quizzes.component';

@NgModule({
  declarations: [
    AppComponent,
    LoginComponent,
    ManagerMainComponent,
    UserMainComponent,
    QuestionListComponent,
    QuizListComponent,
    MakeQuestionComponent,
    MakeQuizComponent,
    AssignQuizComponent,
    UserListComponent,
    UserAssignedQuizzesComponent
  ],
  imports: [
    FormsModule,
    BrowserModule,
    AppRoutingModule,
    HttpClientModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
