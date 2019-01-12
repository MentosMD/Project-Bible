import { Injectable } from '@angular/core';
import { Http } from '@angular/http';
import { HttpClient } from 'selenium-webdriver/http';

@Injectable({
  providedIn: 'root'
})
export class LoginServiceService {

  constructor(private http: Http) { }

  _login() {
    this.http.post('', {});
  }

  _logOut() {
    this.http.get(''); 
  }
}
