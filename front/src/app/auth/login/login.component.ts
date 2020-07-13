import { Component, OnInit } from '@angular/core';
import { Router, ActivatedRoute } from '@angular/router';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { AutenticacaoService } from '../services/autenticacao.service';



@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.scss']
})
export class LoginComponent implements OnInit {

  loginForm: FormGroup;
  loading = false;
  submitted = false;
  returnUrl: string;
  error = '';

  constructor(
    private formBuilder: FormBuilder,
    private route: ActivatedRoute,
    private router: Router,
    private autenticacaoService: AutenticacaoService
  ) {

  }

  ngOnInit(): void {
      this.loginForm = this.formBuilder.group({
        username: ['', Validators.required],
        password: ['', Validators.required]
    });

    //console.log ( this.loginForm);
    this.returnUrl = '/home';
  }

  get f() { return this.loginForm.controls; }

  onSubmit() {
    this.submitted = true;

    // stop here if form is invalid
    if (this.loginForm.invalid) {
        return;
    }
    this.loading = true;

    this.autenticacaoService
      .login ( this.loginForm.value.username, this.loginForm.value.password  )
      .subscribe(
        ( success ) => {
          console.log ( 'success');
          this.router.navigate( [ this.returnUrl ] );
          console.log ( )
        },
        ( error ) => {
          console.log ('error', error);
          this.loading = false;
        }
      );
  }

}
