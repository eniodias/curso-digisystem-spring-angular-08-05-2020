import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { SegundoComponent } from './segundo/segundo.component';
import { PrimeiroComponent } from './primeiro/primeiro.component';
//import { ProdutosModule } from './produtos/produtos.module';
import { HomeComponent } from './home/home.component';
import { NavbarComponent } from './navbar/navbar.component';
import { FooterComponent } from './footer/footer.component';
import { SharedModule } from './shared/shared.module';
import { CommonModule } from '@angular/common';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { CicloComponent } from './ciclo/ciclo.component';

import { HTTP_INTERCEPTORS } from '@angular/common/http';
import { JwtInterceptorService } from './auth/services/jwt-interceptor.service';

@NgModule({
  declarations: [
    AppComponent,
    SegundoComponent,
    PrimeiroComponent,
    HomeComponent,
    NavbarComponent,
    FooterComponent,
    CicloComponent
  ],
  imports: [
    BrowserModule,
    CommonModule,
    BrowserAnimationsModule,
    AppRoutingModule,
    //ProdutosModule,
    SharedModule,

    //RouterModule
  ],
  providers: [
    { provide : HTTP_INTERCEPTORS, useClass : JwtInterceptorService, multi: true }
  ],
  bootstrap: [AppComponent]
})
export class AppModule { }
