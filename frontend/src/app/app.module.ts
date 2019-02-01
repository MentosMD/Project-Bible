import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { MDBBootstrapModule } from 'angular-bootstrap-md';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { CookieService } from 'ngx-cookie-service';
import { HTTP_INTERCEPTORS, HttpClientModule } from '@angular/common/http';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { LoginComponent } from './login/login.component';
import { RegisterComponent } from './register/register.component';
import { ProfileSettingsComponent } from './profile-settings/profile-settings.component';
import { HeaderComponent } from './core/header/header.component';
import { AddNoteComponent } from './add-note/add-note.component';

import { HTTPInterceptor } from './core/interceptors/http-interceptor.service';

@NgModule({
  declarations: [
    AppComponent,
    LoginComponent,
    RegisterComponent,
    ProfileSettingsComponent,
    HeaderComponent,
    AddNoteComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    FormsModule,
    ReactiveFormsModule,
    HttpClientModule,
    MDBBootstrapModule.forRoot()
  ],
  providers: [CookieService, {
    provide: HTTP_INTERCEPTORS,
    useClass: HTTPInterceptor,
    multi: true
  }],
  bootstrap: [AppComponent]
})
export class AppModule { }
