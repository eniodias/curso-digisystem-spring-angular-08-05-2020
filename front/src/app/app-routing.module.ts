import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { HomeComponent } from './home/home.component';
import { PrimeiroComponent } from './primeiro/primeiro.component';


const routes: Routes = [
  { path:'', component : HomeComponent },
  { path:'home', component : HomeComponent },
  { path:'primeiro', component : PrimeiroComponent }
 
];


@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
