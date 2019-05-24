import { Component, OnInit } from "@angular/core";
import {
  FormGroup,
  FormBuilder,
  Validators,
  FormControl
} from "@angular/forms";
import { CategoriaService } from "src/services/domain/categoria.service";
import { NavController, MenuController } from "@ionic/angular";

@Component({
  selector: "app-login",
  templateUrl: "./login.page.html",
  styleUrls: ["./login.page.scss"]
})
export class LoginPage implements OnInit {
  authForm: FormGroup;
  // authProviders = AuthProvider;

  constructor(
    private fb: FormBuilder,
    public catServ: CategoriaService,
    private navCtrl: NavController,
    private menuCtrl: MenuController
  ) {}

  ngOnInit(): void {
    this.createForm();
    this.catServ.findAll().subscribe(res => {
      console.log(res);
    });
    this.menuCtrl.enable(false);
  }

  private createForm() {
    this.authForm = this.fb.group({
      email: ["", [Validators.required, Validators.email]],
      password: ["", [Validators.required, Validators.minLength(6)]]
    });
  }

  get name(): FormControl {
    return <FormControl>this.authForm.get("name");
  }

  get email(): FormControl {
    return <FormControl>this.authForm.get("email");
  }

  get password(): FormControl {
    return <FormControl>this.authForm.get("password");
  }

  onSubmit(): void {
    console.log("authForm", this.authForm.value);
    this.navCtrl.navigateRoot("/home");
  }
}
