import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';


@Injectable({
  providedIn: 'root'
})
export class UserServiceService {

  constructor(private http: HttpClient) { }

  _createUser(): void {
    this.http.post('', {});
  }

  _login(): void {
    this.http.post('', {});
  }

  _logOut(): void {
    this.http.get(''); 
  }
}
