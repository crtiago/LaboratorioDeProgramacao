import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { StorageDataService } from 'src/services/storageData.service';
import { CompraDTO } from 'src/models/compra.dto';
import { ProdutoVendaDTO } from 'src/models/produtoVenda.dto';

@Component({
  selector: 'app-pedido',
  templateUrl: './pedido.page.html',
  styleUrls: ['./pedido.page.scss'],
})
export class PedidoPage implements OnInit {
  pedido: CompraDTO = null;
  itens: ProdutoVendaDTO[] = [];
  constructor(private ar: ActivatedRoute, private storage: StorageDataService) { }

  ngOnInit() {
    this.pedido = this.storage.getData(this.ar.snapshot.paramMap.get('id'));
    this.itens = this.pedido.itens;
    console.log(this.pedido);
    console.log('itens:' + this.itens);
  }

}
