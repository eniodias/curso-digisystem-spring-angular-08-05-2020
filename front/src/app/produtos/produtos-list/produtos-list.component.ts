import { Component, OnInit, DoCheck } from '@angular/core';
import { ProdutoService } from '../produto.service';
import { Router } from '@angular/router';
import { ToastrService } from 'ngx-toastr';
import { tokenReference } from '@angular/compiler';
import { take } from 'rxjs/operators';

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
     ) {
       //this.onTabelaClick();
     }

  ngDoCheck(){
    // console.log ( 'sou um ciclo de vida!!');
  }

  ngOnInit(): void {
    this.produtoService.getAll()
      .pipe( take(1) )
      .subscribe(
        ( resp ) => {
          //console.log( resp );
          this.produtos = resp;
        },
        ( error ) => {
          console.log ( error );
          alert (error.status);
        }
      );

      this.produtoService.getProdutoBarramento()
        .subscribe(
          ( obj ) => {
            console.log ( 'Barramento de produtos' , obj);
            this.toastr.info( 'Novo produto ' + obj.nome );
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
          this.toastr.success ('Produto deletado com sucesso!');
        },
        (error) => {
          this.toastr.error ( 'Erro ao deletar o produto!' );
        }
      );
  }

  receberEventoPai( valor ){
    alert ( valor );
  }

}
