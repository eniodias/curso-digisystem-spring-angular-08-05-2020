

import { Component, OnInit } from '@angular/core';
import { ProdutoService } from '../produto.service';
import { Router } from '@angular/router';
import { ToastrModule, ToastrService } from 'ngx-toastr';

@Component({
  selector: 'app-produtos-list',
  templateUrl: './produtos-list.component.html',
  styleUrls: ['./produtos-list.component.scss']
})
export class ProdutosListComponent implements OnInit {

  isShow : boolean = true;
  minhaClasse : string = '';
  produtoSelecionadoPai : any = null;

  produtos : any;

  constructor(
    private produtoService : ProdutoService,
    private router : Router,
    private toastr: ToastrService
     ) { }

  ngOnInit(): void {
    this.produtoService.getAll()
      .subscribe(
        ( resp ) => {
          //console.log( resp );
          this.produtos = resp;
          this.toastr.success ('Get All');
        },
        ( error ) => {
          console.log ( error );
          alert (error.status);
        }
      );
  }

  onTabelaClick(){
    this.isShow = !this.isShow;
  }

  onSelectedBox( selecionado ){
    //alert ( selecionado );
    this.minhaClasse = selecionado;
  }

  maisDetalhes( produto  ){
    //alert( produto.nome );
    this.produtoSelecionadoPai = produto;
  }

  receberEventoPai( valor ){
    alert ( valor );
  }

  editar( produto ){
    this.router.navigate ([ 'produtos', produto.id  ]);
  }


  delete ( id ){
    this.produtoService
      .delete( id )
      .subscribe(
        (response) => {
          //nova requisição para todos os produtos novamente

          //achar posição do elemento no vetor de produtos
          let index = this.produtos.findIndex( x => { return ( x.id == id ) } );
          this.produtos.splice(index,1);

        }
      );
  }

}


