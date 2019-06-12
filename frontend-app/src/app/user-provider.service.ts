import { Injectable } from '@angular/core';
import { UsuarioDTO } from 'src/models/usuario.dto';

@Injectable({
  providedIn: 'root'
})
export class UserProviderService {

  constructor(public user: UsuarioDTO) { }


  public saveUser(usuario){
    this.user = usuario;
  }

  public getUser(){
    return this.user;
  }

}
