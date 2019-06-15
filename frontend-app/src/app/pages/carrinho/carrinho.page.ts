import { Component, OnInit } from '@angular/core';
import { CartItensService } from 'src/app/shared/globalData/cart-itens.service';

@Component({
  selector: 'app-carrinho',
  templateUrl: './carrinho.page.html',
  styleUrls: ['./carrinho.page.scss'],
})
export class CarrinhoPage implements OnInit {

  cartItens: any[];
  constructor(private cartService: CartItensService) { }

  ngOnInit() {
    this.cartItens = this.cartService.getCart();
  }

}
