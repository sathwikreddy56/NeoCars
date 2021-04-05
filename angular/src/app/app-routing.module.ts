import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { LoginComponent } from './auth/login/login.component';
import { SignupAdminComponent } from './auth/signup-admin/signup-admin.component';
import { SignupComponent } from './auth/signup/signup.component';
import { UserDashboardComponent } from './user-side/user-dashboard/user-dashboard.component';

const routes: Routes = [
  {path:'', component:LoginComponent},
  {path:'login', component:LoginComponent},
  {path:'user/signup', component:SignupComponent},
  {path:'user/dashboard', component:UserDashboardComponent},
  {path:'admin/signup', component:SignupAdminComponent}
  
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
