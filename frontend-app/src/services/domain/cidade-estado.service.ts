import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { CidadeDTO } from 'src/models/cidade.dto';
import { API_CONFIG } from 'src/config/api.config';
import { EstadoDTO } from 'src/models/estado.dto';
import { EnderecoDTO } from 'src/models/endereco.dto';

@Injectable()
export class CidadeEstadoService {
    constructor(private http: HttpClient){}

    public findCidadeAll(estadoId): Observable<CidadeDTO[]> {
        return this.http.get<CidadeDTO[]>(`${API_CONFIG.baseUrl}/estados/${estadoId}/cidades`);
    }

    public findEstado(): Observable<EstadoDTO[]>{
        return this.http.get<EstadoDTO[]>(`${API_CONFIG.baseUrl}/estados`);
    }
}