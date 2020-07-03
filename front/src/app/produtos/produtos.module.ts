import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import { ProdutosRoutingModule } from './produtos-routing.module';
import { ProdutosListComponent } from './produtos-list/produtos-list.component';
import { ProdutoDetalheComponent } from './produto-detalhe/produto-detalhe.component';
import { HttpClientModule } from '@angular/common/http';
import { ProdutoService } from './produto.service';
import { ProdutoFormComponent } from './produto-form/produto-form.component';
import { FormsModule, ReactiveFormsModule, FormBuilder } from '@angular/forms';
import { FormErrorsComponent } from './form-errors/form-errors.component';

@NgModule({
  declarations: [ProdutosListComponent, ProdutoDetalheComponent, ProdutoFormComponent, FormErrorsComponent],
  imports: [
    CommonModule,
    ProdutosRoutingModule,
    HttpClientModule,
    FormsModule,
    ReactiveFormsModule
  ],
  exports:[
    ProdutosListComponent
  ],providers:[ProdutoService,FormBuilder]
})
export class ProdutosModule { }
