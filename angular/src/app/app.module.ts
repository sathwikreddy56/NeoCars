import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { FormsModule } from '@angular/forms';
import{MatCardModule} from '@angular/material/card';
import{MatTabsModule} from '@angular/material/tabs';
import{MatFormFieldModule,} from '@angular/material/form-field';
import{MatInputModule} from '@angular/material/input';
import{ MatButtonModule} from '@angular/material/button';
import {MatCheckboxModule} from '@angular/material/checkbox'
import{ MatIconModule} from '@angular/material/icon';

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
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { ITS_JUST_ANGULAR } from '@angular/core/src/r3_symbols';
import { SignupAdminComponent } from './auth/signup-admin/signup-admin.component';

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
    SignupAdminComponent,
   
  ],
  imports: [
    BrowserModule,
    FormsModule,
    MatInputModule,
    MatCardModule,
    MatTabsModule,
    MatFormFieldModule,
    MatButtonModule,
    MatCheckboxModule,
    MatIconModule,
    AppRoutingModule,
    BrowserAnimationsModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
