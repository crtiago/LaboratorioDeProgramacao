import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { EnderecoDTO } from 'src/models/endereco.dto';
import { API_CONFIG } from 'src/config/api.config';

@Injectable()
export class EnderecoService{

    constructor(public http: HttpClient) {
    }

    findById(id: number): Observable<EnderecoDTO[]> {
        return this.http.get<EnderecoDTO[]>(`${API_CONFIG.baseUrl}/clientes/` + id + `/enderecos`);
    }

    registerAdress(endereco: EnderecoDTO, userId: number){
        return this.http.post(`${API_CONFIG.baseUrl}/clientes/${userId}/endereco`, endereco, {
          observe: 'response',
          responseType: 'text'
        });
      }

}