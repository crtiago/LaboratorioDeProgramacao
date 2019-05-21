import { Component, OnInit } from "@angular/core";
import {
  FormGroup,
  FormBuilder,
  Validators,
  FormControl
} from "@angular/forms";
import { NavController } from '@ionic/angular';

@Component({
  selector: "app-cadastro",
  templateUrl: "./cadastro.page.html",
  styleUrls: ["./cadastro.page.scss"]
})
export class CadastroPage implements OnInit {
  cadastroForm: FormGroup;

  constructor(private fb: FormBuilder, private navCtrl: NavController) {}

  ngOnInit() {
     this.createForm();
  }

  private createForm() {
    this.cadastroForm = this.fb.group({
      name: ["", [Validators.required, Validators.minLength(10)]],
      email: ["", [Validators.required, Validators.email]],
      password: ["", [Validators.required, Validators.minLength(6)]],
      fone: ["", [Validators.required, Validators.minLength(11)]]
    });
  }

  get name(): FormControl {
    return <FormControl>this.cadastroForm.get("name");
  }

  get email(): FormControl {
    return <FormControl>this.cadastroForm.get("email");
  }
  get fone(): FormControl {
    return <FormControl>this.cadastroForm.get("fone");
  }

  get password(): FormControl {
    return <FormControl>this.cadastroForm.get("password");
  }

  cancelar(){
    this.navCtrl.back();
  }
}
