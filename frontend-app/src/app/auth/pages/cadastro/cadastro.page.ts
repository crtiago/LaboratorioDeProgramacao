import { Component, OnInit } from "@angular/core";
import {
  FormGroup,
  FormBuilder,
  Validators,
  FormControl
} from "@angular/forms";
import { NavController, ToastController, MenuController } from "@ionic/angular";
import { UsuarioService } from "src/services/domain/usuario.service";
import { UsuarioDTO } from "src/models/usuario.dto";
import { UserRepository } from "src/app/shared/globalData/user.service";

@Component({
  selector: "app-cadastro",
  templateUrl: "./cadastro.page.html",
  styleUrls: ["./cadastro.page.scss"]
})
export class CadastroPage implements OnInit {
  cadastroForm: FormGroup;
  user: UsuarioDTO = { 
    id: "",
    cpf: "",
    email: "",
    nome: "",
    senha: ""
  };
  constructor(
    private fb: FormBuilder,
    private navCtrl: NavController,
    private userService: UsuarioService,
    private userRepo: UserRepository,
    private toastController: ToastController,
    private menuCtrl: MenuController,

  ) {}

  ngOnInit() {
    this.menuCtrl.enable(false);
    this.createForm();
  }

  private createForm() {
    this.cadastroForm = this.fb.group({
      name: ["", [Validators.required, Validators.minLength(5)]],
      email: ["", [Validators.required, Validators.email]],
      password: ["", [Validators.required, Validators.minLength(6)]],
      cpf: ["", [Validators.required, Validators.minLength(11)]]
    });
  }

  get name(): FormControl {
    return <FormControl>this.cadastroForm.get("name");
  }

  get email(): FormControl {
    return <FormControl>this.cadastroForm.get("email");
  }
  get cpf(): FormControl {
    return <FormControl>this.cadastroForm.get("cpf");
  }

  get password(): FormControl {
    return <FormControl>this.cadastroForm.get("password");
  }

  cadastrar(): void {
    this.setUser();
    this.userService.registerUser(this.user).subscribe(res => {
      this.userRepo.setUser(this.user);
      this.presentToast();
      this.navCtrl.navigateRoot("login");
    });
  }

  cancelar() {
    this.navCtrl.back();
  }

  async presentToast() {
    const toast = await this.toastController.create({
      message: 'Cadastro realizado com sucesso.',
      duration: 2000
    });
    toast.present();
  }



  private setUser() {
    this.user.nome = this.name.value;
    this.user.email = this.email.value;
    this.user.senha = this.password.value;
    this.user.cpf = this.cpf.value;
    console.log(this.user);
  }
}
