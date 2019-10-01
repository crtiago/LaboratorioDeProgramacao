import { ProdutoVendaDTO } from './produtoVenda.dto';

export interface CartItem {
    quantidade: number;
    produto: ProdutoVendaDTO;
}
