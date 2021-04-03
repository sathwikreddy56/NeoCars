import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { AdminSideComponent } from './admin-side/admin-side.component';
import { AdminDashboardComponent } from './admin-side/admin-dashboard/admin-dashboard.component';
import { AdminNavbarComponent } from './admin-side/admin-navbar/admin-navbar.component';
import { AdminProfileComponent } from './admin-side/admin-profile/admin-profile.component';
import { UserSideComponent } from './user-side/user-side.component';
import { UserDashboardComponent } from './user-side/user-dashboard/user-dashboard.component';
import { UserNavbarComponent } from './user-side/user-navbar/user-navbar.component';
import { UserProfileComponent } from './user-side/user-profile/user-profile.component';
import { SuperAdminSideComponent } from './super-admin-side/super-admin-side.component';
import { SuperAdminDashboardComponent } from './super-admin-side/super-admin-dashboard/super-admin-dashboard.component';
import { SuperAdminNavbarComponent } from './super-admin-side/super-admin-navbar/super-admin-navbar.component';
import { LoginComponent } from './auth/login/login.component';
import { SignupComponent } from './auth/signup/signup.component';

@NgModule({
  declarations: [
    AppComponent,
    AdminSideComponent,
    AdminDashboardComponent,
    AdminNavbarComponent,
    AdminProfileComponent,
    UserSideComponent,
    UserDashboardComponent,
    UserNavbarComponent,
    UserProfileComponent,
    SuperAdminSideComponent,
    SuperAdminDashboardComponent,
    SuperAdminNavbarComponent,
    LoginComponent,
    SignupComponent,
   
  ],
  imports: [
    BrowserModule,
    AppRoutingModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
