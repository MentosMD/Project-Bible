import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validator, Validators } from '@angular/forms';

@Component({
  selector: 'app-register',
  templateUrl: './register.component.html',
  styleUrls: ['./register.component.scss']
})
export class RegisterComponent implements OnInit {
  forms: FormGroup;

  constructor(private fb: FormBuilder) { }

  ngOnInit() {
    this.forms = this.fb.group({
       name: ['', [Validators.required, Validators.maxLength(255)]],
       email: ['', [Validators.required, Validators.email]],
       password: ['', [Validators.required, Validators.minLength(7), Validators.maxLength(32)]],
       repeat_password: ['', [Validators.required, Validators.minLength(7), Validators.maxLength(32)]] 
    });
  }


  onSubmit(): any {
    if (this.forms.invalid) { return false; }
    return true;
  }
}
