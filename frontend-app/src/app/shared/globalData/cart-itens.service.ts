import { Injectable } from '@angular/core';
import { ProdutoVendaDTO } from 'src/models/produtoVenda.dto';

@Injectable({
  providedIn: 'root'
})
export class CartItensService {

  public cart: ProdutoVendaDTO[] = [];
  constructor() { }

  public insertItem(prod: ProdutoVendaDTO) {
    this.cart.push(prod);
  }

  public getCart() {
    return this.cart;
  }
}
