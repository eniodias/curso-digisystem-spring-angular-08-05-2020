import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import { ProdutosRoutingModule } from './produtos-routing.module';
import { ProdutosListComponent } from './produtos-list/produtos-list.component';
import { ProdutoDetalheComponent } from './produto-detalhe/produto-detalhe.component';


@NgModule({
  declarations: [ProdutosListComponent, ProdutoDetalheComponent],
  imports: [
    CommonModule,
    ProdutosRoutingModule
  ],
  exports:[
    ProdutosListComponent
  ]
})
export class ProdutosModule { }
