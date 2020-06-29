import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { ProdutosListComponent } from './produtos/produtos-list/produtos-list.component';
import { HomeComponent } from './home/home.component';
import { PrimeiroComponent } from './primeiro/primeiro.component';


const routes: Routes = [
  { path:'', component : HomeComponent },
  { path:'home', component : HomeComponent },
  { path:'primeiro', component : PrimeiroComponent },
  { path: 'produtos' , component: ProdutosListComponent }
];


@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
