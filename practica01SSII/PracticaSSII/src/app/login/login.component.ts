import { Component, OnInit } from '@angular/core';
import { NgForm } from '@angular/forms';
import { LoginService } from '../services/login.service';


@Component({
  // tslint:disable-next-line:component-selector
  selector: 'PSSII-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.scss']
})
export class LoginComponent implements OnInit {
  public password: string;
  public user: string;
  constructor(private loginService: LoginService) { }

  ngOnInit() {
  }
  public submit(form: NgForm) {
    console.log(form.value);
    this.loginService.sendLogin(form.value).subscribe(data => {
      console.log(data);
    });
  }
}
