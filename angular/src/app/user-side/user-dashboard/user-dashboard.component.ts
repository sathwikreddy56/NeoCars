import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Observable } from 'rxjs';
import { tile } from './tile';

@Component({
  selector: 'app-user-dashboard',
  templateUrl: './user-dashboard.component.html',
  styleUrls: ['./user-dashboard.component.css']
})
export class UserDashboardComponent implements OnInit {
  companies!: tile[];
  constructor(private http: HttpClient,private router: Router) { }
  ngOnInit(): void {
    this.getCompanies();
  }
  getCompanies():void {
    var token = localStorage.getItem('token')||"a"
    const headers = new HttpHeaders().set('Authorization', token);
     this.fetch(headers).subscribe(h=>{
      this.companies=h;
    })
  }
  fetch(headers:HttpHeaders):Observable<tile[]>{
    return this.http.get<tile[]>('http://localhost:8080/user/dashboard',{headers});
  }
}
