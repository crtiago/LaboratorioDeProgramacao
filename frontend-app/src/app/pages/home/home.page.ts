import { Component, OnInit } from "@angular/core";
import { MenuController } from '@ionic/angular';
import { ProdutoVendaDTO } from 'src/models/produtoVenda.dto';
import { ProdutoVendaService } from 'src/services/domain/produtoVenda.service';
import { StorageDataService } from 'src/services/storageData.service';
import { UsuarioService } from 'src/services/domain/usuario.service';
import { UsuarioDTO } from 'src/models/usuario.dto';
import { UserRepository } from 'src/app/shared/globalData/user.service';

@Component({
  selector: "app-home",
  templateUrl: "./home.page.html",
  styleUrls: ["./home.page.scss"]
})
export class HomePage implements OnInit {
  searchQuery: string = "";
  items: string[];
  produtos: ProdutoVendaDTO[];
  user: UsuarioDTO




  constructor(private menuCtrl: MenuController,
    private prodService: ProdutoVendaService, 
    private storage: StorageDataService,
    private userService: UsuarioService,
    private userRepos: UserRepository
    ) {
    this.initializeItems();
    this.menuCtrl.enable(true);
  }

  initializeItems() {
    this.items = ["Amsterdam", "Bogota"];
  }

  ngOnInit() {
    this.prodService.findAll().subscribe(res => {
      this.produtos = res;
      console.log(this.produtos);
    })

    this.userService.findById(1).subscribe(res =>{
      this.user = res;
      console.log(this.user);
      this.userRepos.setUser(this.user);
    })
  }

  getItems(ev: any) {
    // Reset items back to all of the items
    this.initializeItems();

    // set val to the value of the searchbar
    const val = ev.target.value;

    // if the value is an empty string don't filter the items
    if (val && val.trim() != "") {
      this.items = this.items.filter(item => {
        return item.toLowerCase().indexOf(val.toLowerCase()) > -1;
      });
    }
  }

  toggleMenu() {
    this.menuCtrl.toggle();
  }

  passData(prod: ProdutoVendaDTO) {
    this.storage.setData(prod.id, prod);
  }
}
