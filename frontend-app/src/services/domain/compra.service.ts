import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { CompraDTO } from 'src/models/compra.dto';
import { API_CONFIG } from 'src/config/api.config';

@Injectable()
export class CompraService {

    constructor(public http: HttpClient){
    }

    findById(): Observable<CompraDTO> {
         return this.http.get<CompraDTO>(`${API_CONFIG.baseUrl}/vendas/1`);
    }
}