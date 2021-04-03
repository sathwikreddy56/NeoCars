import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {

  constructor(private router: Router) {}

  newChange(): void {
      this.router.navigateByUrl('user/signup');
  }
  adminSignUp(): void {
    this.router.navigateByUrl('admin/signup');
}
isUserPresent(): void {
  // document.getElementById
  this.router.navigateByUrl('user/dashboard');
}
isAdminPresent(): void {
this.router.navigateByUrl('admin/dashboard');
}

  ngOnInit(): void {
  }

}
