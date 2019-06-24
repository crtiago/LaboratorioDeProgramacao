import { Component, OnInit } from "@angular/core";
import { NavController } from "@ionic/angular";
import { UsuarioDTO } from "src/models/usuario.dto";
import { UserRepository } from "src/app/shared/globalData/user.service";

@Component({
  selector: "app-minha-conta",
  templateUrl: "./minha-conta.page.html",
  styleUrls: ["./minha-conta.page.scss"]
})
export class MinhaContaPage implements OnInit {
  user: UsuarioDTO = null;
  constructor(
    private navCtrl: NavController,
    private userRepo: UserRepository
  ) {}

  ngOnInit() {
    this.user = this.userRepo.getUser();
    if (this.user == null) {
      this.navCtrl.navigateRoot("login");
    }
  }

  private navEnderecos() {
    this.navCtrl.navigateForward("/meus-enderecos");
  }

  logOut() {
    this.userRepo.logOut();
    this.navCtrl.navigateRoot("/home");
  }
}
