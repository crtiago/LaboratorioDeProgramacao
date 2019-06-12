import { Injectable } from '@angular/core';
import { ProdutoVendaDTO } from 'src/models/produtoVenda.dto';

@Injectable({
  providedIn: 'root'
})
export class CartItensService {

  private cart: [{
    produto: ProdutoVendaDTO,
    quantidade: number;
  }];
  constructor() { }

  public insertItem(produto: ProdutoVendaDTO, quantidade: number) {
    this.cart.push({produto, quantidade});
  }

  public getCart() {
    return this.cart;
  }
}
