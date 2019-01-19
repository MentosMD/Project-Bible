import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';

import { AuthGuard } from './core/guard/auth-guard.service';

import { LoginComponent } from './login/login.component';
import { RegisterComponent } from './register/register.component';
import { ProfileSettingsComponent } from './profile-settings/profile-settings.component';
import { AddNoteComponent } from './add-note/add-note.component';


const routes: Routes = [
   {
     path: '',
     component: LoginComponent
   },
   {
     path: 'register',
     component: RegisterComponent
   },
   {
    path: 'profile/settings',
    component: ProfileSettingsComponent,
    canActivate: [AuthGuard]
   },
   {
    path: 'profile/note/add',
    component: AddNoteComponent,
    canActivate: [AuthGuard]
   }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
