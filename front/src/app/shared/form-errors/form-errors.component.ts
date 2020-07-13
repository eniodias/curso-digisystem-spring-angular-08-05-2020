import { Component, OnInit, Input } from '@angular/core';

@Component({
  selector: 'app-form-errors',
  templateUrl: './form-errors.component.html',
  styleUrls: ['./form-errors.component.scss']
})
export class FormErrorsComponent implements OnInit {

  @Input()
  isError : boolean = false;

  @Input()
  message : string = "a minha mensagem padrão";

  constructor() { }

  ngOnInit(): void {
  }

}
