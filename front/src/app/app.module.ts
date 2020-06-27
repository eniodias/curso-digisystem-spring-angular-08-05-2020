import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { FormsModule } from '@angular/forms';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { SegundoComponent } from './segundo/segundo.component';
import { PrimeiroComponent } from './primeiro/primeiro.component';
import { ProdutosModule } from './produtos/produtos.module';
import { HightlightDirective } from './diretivas/hightlight.directive';

@NgModule({
  declarations: [
    AppComponent,
    SegundoComponent,
    PrimeiroComponent,
    HightlightDirective
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    FormsModule,
    ProdutosModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
