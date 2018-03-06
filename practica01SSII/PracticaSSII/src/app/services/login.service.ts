import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';

@Injectable()
export class LoginService {

  constructor(private http: HttpClient) { }

  sendLogin(login: {user: string, password: string}) {
    // Faltaría pasarle el id a la petición para que funcione
    return this.http.post<any>('http://localhost:8080/login', login);
  }

}
