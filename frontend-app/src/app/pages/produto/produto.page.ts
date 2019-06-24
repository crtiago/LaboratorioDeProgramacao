import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { ProdutoVendaDTO } from 'src/models/produtoVenda.dto';
import { StorageDataService } from 'src/services/storageData.service';
import { CartItensService } from 'src/app/shared/globalData/cart-itens.service';
import { ToastController } from '@ionic/angular';

@Component({
  selector: 'app-produto',
  templateUrl: './produto.page.html',
  styleUrls: ['./produto.page.scss'],
})
export class ProdutoPage implements OnInit {

  produto: ProdutoVendaDTO = null;

  constructor(private ar: ActivatedRoute, private storage: StorageDataService, private cartService: CartItensService, private toastController: ToastController) { }

  ngOnInit() {
    this.produto = this.storage.getData(this.ar.snapshot.paramMap.get('id'));
  }

  addCart() {
    this.cartService.insertItem(this.produto);
    this.presentToast();
  }

  async presentToast() {
    const toast = await this.toastController.create({
      message: 'Produto inserido no carrinho',
      duration: 2000,
      position: 'top'
    });
    toast.present();
  }

}
