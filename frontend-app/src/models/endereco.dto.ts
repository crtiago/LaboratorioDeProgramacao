import { CidadeDTO } from './cidade.dto';

export interface EnderecoDTO {
  id: any;
  rua: string;
  cep: string;
  numero: number;
  bairro: string;
  cidade: CidadeDTO;
}
