import { Component, OnInit } from "@angular/core";
import { StorageDataService } from "src/services/storageData.service";
import { CartItem } from "src/models/cart-item";
import { EnderecoDTO } from "src/models/endereco.dto";
import { UsuarioDTO } from "src/models/usuario.dto";
import { EnderecoService } from "src/services/domain/endereco.service";
import { UserRepository } from "src/app/shared/globalData/user.service";

@Component({
  selector: "app-checkout",
  templateUrl: "./checkout.page.html",
  styleUrls: ["./checkout.page.scss"]
})
export class CheckoutPage implements OnInit {
  itens: CartItem[];
  payMethodCard: boolean = false;
  enderecos: EnderecoDTO[];
  user: UsuarioDTO;

  constructor(
    private storage: StorageDataService,
    private endService: EnderecoService,
    private userRepo: UserRepository
  ) {}

  ngOnInit() {
    this.user = this.userRepo.getUser();
    this.endService.findById(this.user.id).subscribe(res => {
      this.enderecos = res;
      console.log('end: ' + this.enderecos[0]);
      console.log('end: ' + this.enderecos[0].cidade);

    });
    this.itens = this.storage.getData(1);
  }
  

  segmentChanged(ev: any) {
    this.payMethodCard = !this.payMethodCard;
  }
}
