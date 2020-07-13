import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { SharedRoutingModule } from './shared-routing.module';
import { FormErrorsComponent } from './form-errors/form-errors.component';
import { HightlightDirective } from './diretivas/hightlight.directive';
import { HttpClientModule } from '@angular/common/http';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';

import { ToastrModule } from 'ngx-toastr';



@NgModule({
  declarations: [
    FormErrorsComponent,
    HightlightDirective
  ],
  imports: [
    CommonModule,
    SharedRoutingModule,
    HttpClientModule,
    FormsModule,
    ReactiveFormsModule,
    //BrowserAnimationsModule, // required animations module
    ToastrModule.forRoot() // ToastrModule added
  ],
  exports : [
    CommonModule,
    FormErrorsComponent,
    HightlightDirective,
    HttpClientModule,
    FormsModule,
    ReactiveFormsModule,

    ToastrModule
  ]
})
export class SharedModule { }
