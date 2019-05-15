import { Component, OnInit } from "@angular/core";
import {
  FormGroup,
  FormBuilder,
  Validators,
  FormControl
} from "@angular/forms";

@Component({
  selector: "app-login",
  templateUrl: "./login.page.html",
  styleUrls: ["./login.page.scss"]
})
export class LoginPage implements OnInit {
  authForm: FormGroup;

  constructor(private fb: FormBuilder) {}

  ngOnInit(): void {
    this.createForm();
  }

  private createForm() {
    this.authForm = this.fb.group({
      email: ["", [Validators.required, Validators.email]],
      password: ["", [Validators.required, Validators.minLength(6)]]
    });
  }

  get email(): FormControl {
    return <FormControl>this.authForm.get("email");
  }

  get password(): FormControl {
    return <FormControl>this.authForm.get("password");
  }

  onSubmit(): void {
    console.log("authForm", this.authForm.value);
  }
}
