import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { LoginComponent } from './login/login.component';
import { ManagerMainComponent } from './manager-main/manager-main.component';
import { UserMainComponent } from './user-main/user-main.component';
import { MakeQuestionComponent } from './make-question/make-question.component';
import { MakeQuizComponent } from './make-quiz/make-quiz.component';
import { AssignQuizComponent } from './assign-quiz/assign-quiz.component';
import { UserAssignedQuizzesComponent } from './user-assigned-quizzes/user-assigned-quizzes.component';


const routes: Routes = [{
  path: 'login',
  component: LoginComponent
}, {
  path: 'mmain',
  component: ManagerMainComponent
}, {
  path: 'umain',
  component: UserMainComponent
}, {
  path: 'makeQuestion',
  component: MakeQuestionComponent
}, {
  path: 'makeQuiz',
  component: MakeQuizComponent
}, {
  path: 'AssignQuiz',
  component: AssignQuizComponent
}, {
  path: 'viewMyQuizzes',
  component: UserAssignedQuizzesComponent
}, {
  path: '**',
  redirectTo: 'login'
}];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
