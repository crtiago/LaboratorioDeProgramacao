import { Injectable } from '@angular/core';
import { UsuarioDTO } from 'src/models/usuario.dto';

@Injectable({
  providedIn: 'root'
})
export class UserRepository {

  private user: UsuarioDTO;

  constructor() { }

  public setUser(user: UsuarioDTO) {
    this.user = user;
  }

  public getUser() {
    return this.user;
  }

  public logOut(){
    this.user = null;
  }
}
