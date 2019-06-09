import { Component, OnInit } from "@angular/core";
import { MenuController } from '@ionic/angular';
import { ProdutoVendaDTO } from 'src/models/produtoVenda.dto';
import { ProdutoVendaService } from 'src/services/domain/produtoVenda.service';
import { StorageDataService } from 'src/services/storageData.service';

@Component({
  selector: "app-home",
  templateUrl: "./home.page.html",
  styleUrls: ["./home.page.scss"]
})
export class HomePage implements OnInit {
  searchQuery: string = "";
  items: string[];
  produtos: ProdutoVendaDTO[];



  constructor(private menuCtrl: MenuController, private prodService: ProdutoVendaService, private storage: StorageDataService) {
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
