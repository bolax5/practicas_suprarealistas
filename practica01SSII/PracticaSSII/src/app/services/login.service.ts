import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';

@Injectable()
export class LoginService {

  constructor(private http: HttpClient) { }

  sendLogin(login: {username: string, password: string}) {
    // Faltaría pasarle el id a la petición para que funcione
    const header = new HttpHeaders({
      'Content-Type': 'application/json'
    });
    return this.http.post<any>('http://localhost:8080/login', login, {headers: header});
  }

}
