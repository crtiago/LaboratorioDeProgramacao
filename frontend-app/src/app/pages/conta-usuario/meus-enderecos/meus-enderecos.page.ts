import { Component, OnInit } from '@angular/core';
import { ToastController } from '@ionic/angular';

@Component({
  selector: 'app-meus-enderecos',
  templateUrl: './meus-enderecos.page.html',
  styleUrls: ['./meus-enderecos.page.scss'],
})
export class MeusEnderecosPage implements OnInit {


  constructor(private toastController: ToastController) { }

  ngOnInit() {
  }

  public deleteAd() {
    this.presentToastWithOptions();
  }

  async presentToastWithOptions() {
    const toast = await this.toastController.create({
      header: 'Excluir endereço',
      position: 'bottom',
      color: 'dark',
      buttons: [
        {
          side: 'start',
          text: 'Cancelar',
          handler: () => {
            console.log('Cancelado');
          }
        }, {
          text: 'Excluir',

          icon: 'trash',
          handler: () => {
            console.log('Excluido');
          }
        }
      ]
    });
    toast.present();
  }
}
