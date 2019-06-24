import { ProdutoVendaDTO } from './produtoVenda.dto';

export interface ProdutoCompraDTO{
    id: any;
    quantidade: number;
    preco: number;
    produtoVenda: ProdutoVendaDTO;
    total: number;
}