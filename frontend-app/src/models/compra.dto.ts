import { ProdutoVendaDTO } from './produtoVenda.dto';
import { PagamentoDTO } from './pagamento.dto';

export class CompraDTO{
    id: any;
    dataVenda: Date;
    pagamento: PagamentoDTO;
    itens: ProdutoVendaDTO[];
    valorTotal: number;

}