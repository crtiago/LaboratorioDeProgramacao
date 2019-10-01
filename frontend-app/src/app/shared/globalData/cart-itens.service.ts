import { Injectable } from '@angular/core';
import { ProdutoVendaDTO } from 'src/models/produtoVenda.dto';
import { CartItem } from 'src/models/cart-item';

@Injectable({
  providedIn: 'root'
})
export class CartItensService {

  public cart: CartItem[] = [];
  constructor() { }

  public insertItem(prod: ProdutoVendaDTO) {
    const position = this.cart.findIndex(x => x.produto.id == prod.id);
    if(position == -1){
      this.cart.push({quantidade: 1, produto: prod});
    }
    else{
      this.cart[position].quantidade ++;
    }
  }

  public getCart() {
    return this.cart;
  }

  public removeItem(prod: ProdutoVendaDTO):CartItem[] {
    let index = this.cart.indexOf({quantidade: 1,produto: prod});
    this.cart.splice(index,1);
    return this.cart;
  }
}
