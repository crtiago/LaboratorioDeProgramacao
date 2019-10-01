import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { ProdutoVendaDTO } from 'src/models/produtoVenda.dto';
import { Observable } from 'rxjs';
import { API_CONFIG } from 'src/config/api.config';

@Injectable()
export class ProdutoVendaService{

    constructor(public http: HttpClient){
    }

    findAll(): Observable<ProdutoVendaDTO[]> {
         return this.http.get<ProdutoVendaDTO[]>(`${API_CONFIG.baseUrl}/produtosvenda`);
    }
}