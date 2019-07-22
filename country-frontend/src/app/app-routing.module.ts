import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';

import { CountryComponent } from './country/country.component'
import { AddCountryComponent } from './add-country/add-country.component'
import { LoginComponent } from './login/login.component'
import { LogoutComponent } from './logout/logout.component'

import { AuthGuardService } from './service/auth-guard.service'

const routes: Routes = [
  { component: CountryComponent, path: '', canActivate: [AuthGuardService]},
  { component: AddCountryComponent, path: 'addCountry', canActivate: [AuthGuardService]},
  { component: LoginComponent, path: 'login'},
  { component: LogoutComponent, path: 'logout', canActivate: [AuthGuardService]}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
