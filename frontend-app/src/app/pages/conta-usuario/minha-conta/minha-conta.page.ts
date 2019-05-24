import { Component, OnInit } from '@angular/core';
import { NavController } from '@ionic/angular';

@Component({
  selector: 'app-minha-conta',
  templateUrl: './minha-conta.page.html',
  styleUrls: ['./minha-conta.page.scss'],
})
export class MinhaContaPage implements OnInit {

  constructor(private navCtrl: NavController) { }

  ngOnInit() {
  }

  private navEnderecos(){
    this.navCtrl.navigateForward("/meus-enderecos");
  }
}
