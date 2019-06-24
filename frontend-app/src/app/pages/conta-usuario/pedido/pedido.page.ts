import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { StorageDataService } from 'src/services/storageData.service';
import { CompraDTO } from 'src/models/compra.dto';
import { ProdutoCompraDTO } from 'src/models/produtoCompra.dto';

@Component({
  selector: 'app-pedido',
  templateUrl: './pedido.page.html',
  styleUrls: ['./pedido.page.scss'],
})
export class PedidoPage implements OnInit {
  pedido: CompraDTO = null;
  itens: ProdutoCompraDTO[] = [];
  constructor(private ar: ActivatedRoute, private storage: StorageDataService) { }

  ngOnInit() {
    this.pedido = this.storage.getData(this.ar.snapshot.paramMap.get('id'));
    this.itens = this.storage.getData(999);
    console.log('pedido:' + this.pedido.itens);
    console.log('itens:' + this.itens);
  }

}
