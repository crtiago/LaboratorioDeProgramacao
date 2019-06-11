import { EnderecoDTO } from './endereco.dto';

export interface UsuarioDTO {
    id:any;
    login:string;
    senha:string;
    nome:string;
    cpf:any
    telefones: any[];
    enderecos: EnderecoDTO;
}