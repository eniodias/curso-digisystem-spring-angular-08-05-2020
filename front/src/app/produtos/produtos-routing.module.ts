import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { ProdutosListComponent } from './produtos-list/produtos-list.component';
import { ProdutoFormComponent } from './produto-form/produto-form.component';

const routes: Routes = [

  { path: 'produtos' , component: ProdutosListComponent },
  { path: 'produtos/novo' , component: ProdutoFormComponent },
  { path: 'produtos/:id' , component: ProdutoFormComponent }


];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class ProdutosRoutingModule { }
