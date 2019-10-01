import { Component, OnInit } from '@angular/core';
import { CompraService } from 'src/services/domain/compra.service';
import { CompraDTO } from 'src/models/compra.dto';
import { StorageDataService } from 'src/services/storageData.service';

@Component({
  selector: 'app-meus-pedidos',
  templateUrl: './meus-pedidos.page.html',
  styleUrls: ['./meus-pedidos.page.scss'],
})
export class MeusPedidosPage implements OnInit {

  compras: CompraDTO;
  constructor(private compraServ: CompraService,private storage: StorageDataService,) { }

  ngOnInit() {
    this.compraServ.findById().subscribe(res => {
      this.compras = res;
      console.log('compra:' + res);
    });
  }

  passData(compras){
    this.storage.setData(compras.id, compras);
    this.storage.setData(999, compras.itens);

  }

}
