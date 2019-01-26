import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';


@Injectable({
  providedIn: 'root'
})
export class UserService {

  constructor(private http: HttpClient) { }

  _createUser(): void {
    this.http.post('', {});
  }

  _login(): void {
    this.http.get('api/login').subscribe();
  }

  _logOut(): void {
    this.http.get(''); 
  }
}
