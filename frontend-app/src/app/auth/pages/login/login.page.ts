import { Component, OnInit } from "@angular/core";
import {
  FormGroup,
  FormBuilder,
  Validators,
  FormControl
} from "@angular/forms";
import { NavController, MenuController } from "@ionic/angular";
import { UsuarioService } from "src/services/domain/usuario.service";
import { UsuarioDTO } from "src/models/usuario.dto";
import { UserRepository } from "src/app/shared/globalData/user.service";

@Component({
  selector: "app-login",
  templateUrl: "./login.page.html",
  styleUrls: ["./login.page.scss"]
})
export class LoginPage implements OnInit {
  authForm: FormGroup;
  user: UsuarioDTO;

  constructor(
    private fb: FormBuilder,
    private navCtrl: NavController,
    private menuCtrl: MenuController,
    private userService: UsuarioService,
    private userRepos: UserRepository
  ) {}

  ngOnInit(): void {
    this.createForm();
    this.menuCtrl.enable(false);
  }

  ionViewWillLeave() {
    this.menuCtrl.enable(true);

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
    this.userService.findByEmail(this.email.value).subscribe(res => {
      if (res.senha == this.password.value) {
        this.user = res;
        this.userRepos.setUser(this.user);
        this.navCtrl.navigateRoot("/home");
      }
    });
  }
}
