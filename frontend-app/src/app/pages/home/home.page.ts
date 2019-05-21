import { Component, OnInit } from "@angular/core";
import { MenuController } from '@ionic/angular';

@Component({
  selector: "app-home",
  templateUrl: "./home.page.html",
  styleUrls: ["./home.page.scss"]
})
export class HomePage {
  searchQuery: string = "";
  items: string[];

  constructor(private menuCtrl: MenuController) {
    this.initializeItems();
  }

  initializeItems() {
    this.items = ["Amsterdam", "Bogota"];
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

  toggleMenu(){
    this.menuCtrl.toggle();
  }
}
