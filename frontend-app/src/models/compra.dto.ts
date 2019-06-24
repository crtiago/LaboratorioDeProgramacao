import { PagamentoDTO } from './pagamento.dto';
import { ProdutoCompraDTO } from './produtoCompra.dto';

export class CompraDTO{
    id: any;
    dataVenda: Date;
    pagamento: PagamentoDTO;
    itens: ProdutoCompraDTO[];
    valorTotal: number;

}