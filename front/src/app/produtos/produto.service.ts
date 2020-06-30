import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';

@Injectable({
  providedIn: 'root'
})
export class ProdutoService {


  constructor(private http : HttpClient  ) { }

  getAll(){
    // return  [
    //   { id : 1, nome: 'Produto 1', preco: 100 },
    //   { id : 2, nome: 'Produto 2', preco: 200 },
    //   { id : 3, nome: 'Produto 3', preco: 300 },
    //   { id : 4, nome: 'Produto 4', preco: 400 }
    // ];


    //return this.http.get ( 'http://localhost:8080/produtos' );
    return this.http.get ( 'https://api.fabrizioborelli.com.br/digisystem/produtos' );
  }

  // get( id ){
  //   return this.http.get ( 'http://localhost:8080/produtos/' + id );
  // }

  get( id ){
    //return this.http.get ( `http://localhost:8080/produtos/${id}` );
    return this.http.get ( `https://api.fabrizioborelli.com.br/digisystem/produtos/${id}` );
  }
}
