import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { ProdutoVendaDTO } from 'src/models/produtoVenda.dto';
import { StorageDataService } from 'src/services/storageData.service';

@Component({
  selector: 'app-produto',
  templateUrl: './produto.page.html',
  styleUrls: ['./produto.page.scss'],
})
export class ProdutoPage implements OnInit {

  produto: ProdutoVendaDTO = null;

  constructor(private ar: ActivatedRoute, private storage: StorageDataService) { }

  ngOnInit() {
    this.produto = this.storage.getData(this.ar.snapshot.paramMap.get('id'));
  }

}
