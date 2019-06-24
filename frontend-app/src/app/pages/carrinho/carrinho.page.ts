import { Component, OnInit, DoCheck } from '@angular/core';
import { CartItensService } from 'src/app/shared/globalData/cart-itens.service';

@Component({
  selector: 'app-carrinho',
  templateUrl: './carrinho.page.html',
  styleUrls: ['./carrinho.page.scss'],
})
export class CarrinhoPage implements OnInit, DoCheck {

  cartItens: any[];
  cartTotal: number = 0;
  constructor(private cartService: CartItensService) { }

  ngOnInit() {
    this.cartItens = this.cartService.getCart();
    this.checkTotalValue();
  }

  ngDoCheck(){
    this.checkTotalValue();
  }

  deleteItem(cart){
    this.cartItens = this.cartService.removeItem(cart);
    this.checkTotalValue();
    console.log(this.cartItens);
  }

  private checkTotalValue(){
    this.cartTotal = 0;
    this.cartItens.forEach(element => {
      this.cartTotal = this.cartTotal + (element.produto.valor * element.quantidade);
    });
  }

}
