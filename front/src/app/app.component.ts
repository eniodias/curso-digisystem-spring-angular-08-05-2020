import { Component } from '@angular/core';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.scss']
})
export class AppComponent {
  title = 'front alterado com sucesso';
  minhavariavel = "angular 9";
  meuTexto;

  site = 'http://grandeporte.com.br';

  getMinhaVariavel(){

    return "texto";

  };

  onClick(){
    alert ('Event Bidind');
  }

  
  onKeyup( inputText ){
    //let cor = 'yellow';
    this.meuTexto = inputText;
    console.log ( inputText );
  }

}
