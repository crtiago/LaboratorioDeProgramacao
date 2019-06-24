import { Component, DoCheck } from "@angular/core";

import { Platform } from "@ionic/angular";
import { SplashScreen } from "@ionic-native/splash-screen/ngx";
import { StatusBar } from "@ionic-native/status-bar/ngx";
import { CartItensService } from "./shared/globalData/cart-itens.service";
import { UserRepository } from "./shared/globalData/user.service";
import { UsuarioDTO } from "src/models/usuario.dto";

@Component({
  selector: "app-root",
  templateUrl: "app.component.html"
})
export class AppComponent implements DoCheck {
  cart: any[] = [];
  user: UsuarioDTO;

  ngDoCheck(): void {
    this.user = this.userRepo.getUser();
  }
  constructor(
    private platform: Platform,
    private splashScreen: SplashScreen,
    private statusBar: StatusBar,
    private cartS: CartItensService,
    private userRepo: UserRepository
  ) {
    this.initializeApp();
    this.cart = cartS.getCart();
  }

  initializeApp() {
    this.platform.ready().then(() => {
      this.statusBar.styleDefault();
      this.splashScreen.hide();
    });
  }
}
