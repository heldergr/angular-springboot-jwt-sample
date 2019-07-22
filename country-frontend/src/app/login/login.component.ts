import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router'

import { AuthenticationService } from '../service/authentication.service'

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {
  username: 'helder'
  password: ''
  invalidLogin = false

  constructor(private loginService: AuthenticationService,
    private router: Router) { }

  ngOnInit() {
  }

  checkLogin() {
    (this.loginService.authenticate(this.username, this.password).subscribe(
      data => {
        this.router.navigate([''])
        this.invalidLogin = false
      },
      error => {
        this.invalidLogin = true

      }
    )
    );
  }
}
