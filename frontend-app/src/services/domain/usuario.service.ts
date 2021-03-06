import { Injectable } from "@angular/core";
import { HttpClient } from "@angular/common/http";
import { Observable } from "rxjs";
import { UsuarioDTO } from "src/models/usuario.dto";
import { API_CONFIG } from "src/config/api.config";

@Injectable()
export class UsuarioService {
  // tslint:disable-next-line: align
  constructor(public http: HttpClient) {}

  findById(id: number): Observable<UsuarioDTO> {
    return this.http.get<UsuarioDTO>(`${API_CONFIG.baseUrl}/clientes/id/${id}`);
  }

  findByEmail(email: string): Observable<UsuarioDTO> {
     return this.http.get<UsuarioDTO>(`${API_CONFIG.baseUrl}/clientes/email/${email}`);
  }

  registerUser(user: UsuarioDTO){
    return this.http.post(`${API_CONFIG.baseUrl}/clientes`, user, {
      observe: 'response',
      responseType: 'text'
    });
  }
}
