import { Component, OnInit } from '@angular/core';
import { ToastController } from '@ionic/angular';
import { EnderecoService } from 'src/services/domain/endereco.service';
import { EnderecoDTO } from 'src/models/endereco.dto';
import { UsuarioDTO } from 'src/models/usuario.dto';
import { UserRepository } from 'src/app/shared/globalData/user.service';

@Component({
  selector: 'app-meus-enderecos',
  templateUrl: './meus-enderecos.page.html',
  styleUrls: ['./meus-enderecos.page.scss'],
})
export class MeusEnderecosPage implements OnInit {

  enderecos: EnderecoDTO[];
  user: UsuarioDTO;
  constructor(private toastController: ToastController, private endService: EnderecoService, private userRepo: UserRepository) { }

  ngOnInit() {
    this.user = this.userRepo.getUser();
    this.endService.findById(this.user.id).subscribe(res => {
      this.enderecos = res;
    });
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
