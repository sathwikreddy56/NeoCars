import { Component, OnInit } from '@angular/core';
import {  NgModel } from '@angular/forms';

import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Router } from '@angular/router';
import { Injectable } from '@angular/core';
@Injectable({
  providedIn: 'root'
})
@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {
  constructor(private http: HttpClient,private router: Router) {}
  isUserPresent(email:NgModel,password:NgModel): void { 
    this.generateToken({"email":email.value,"password":password.value})
      .subscribe(data=>{
        if(data.isAuth){
          let tokenStr = 'Bearer ' + data.token;
          localStorage.setItem('token',tokenStr)
          this.router.navigateByUrl('user/dashboard');
        }else{
          alert("invalid creadentials")
          this.router.navigateByUrl('user/login');
        }
        
      }
    );
  }
  public generateToken(request: any) {
    return this.http.post<{isAuth:boolean,token:string}>("http://localhost:8080/user/login", request, {  responseType: 'json' });
  }
  isAdminPresent(): void {
  this.router.navigateByUrl('admin/dashboard');
  }
  ngOnInit(): void {}
}
