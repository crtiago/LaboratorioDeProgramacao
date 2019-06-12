import { EnderecoDTO } from './endereco.dto';

export interface UsuarioDTO{

    tipo:any;
    id: any;
    email: string;
    senha: string;
    nome: string;
    cpf:string;
    enderecos: EnderecoDTO[];
    telefones: any[];

}