import { NgModule } from '@angular/core';
import { PreloadAllModules, RouterModule, Routes } from '@angular/router';

const routes: Routes = [
  { path: '', redirectTo: 'login', pathMatch: 'full' },
  { path: 'login', loadChildren: './auth/pages/login/login.module#LoginPageModule' },
  { path: 'cadastro', loadChildren: './auth/pages/cadastro/cadastro.module#CadastroPageModule' },
  { path: 'home', loadChildren: './pages/home/home.module#HomePageModule' },
  { path: 'carrinho', loadChildren: './pages/carrinho/carrinho.module#CarrinhoPageModule' },
  { path: 'produto/:id', loadChildren: './pages/produto/produto.module#ProdutoPageModule' },
  { path: 'checkout', loadChildren: './pages/pagamentos/checkout/checkout.module#CheckoutPageModule' },
  { path: 'minha-conta', loadChildren: './pages/conta-usuario/minha-conta/minha-conta.module#MinhaContaPageModule' },
  { path: 'meus-pedidos', loadChildren: './pages/conta-usuario/meus-pedidos/meus-pedidos.module#MeusPedidosPageModule' },
  { path: 'meus-enderecos', loadChildren: './pages/conta-usuario/meus-enderecos/meus-enderecos.module#MeusEnderecosPageModule' },
// tslint:disable-next-line: max-line-length
  { path: 'manutencao-lista', loadChildren: './pages/conta-usuario/manutencao/manutencao-lista/manutencao-lista.module#ManutencaoListaPageModule' },
// tslint:disable-next-line: max-line-length
  { path: 'manutencao-item', loadChildren: './pages/conta-usuario/manutencao/manutencao-item/manutencao-item.module#ManutencaoItemPageModule' },
  { path: 'pedido/:id', loadChildren: './pages/conta-usuario/pedido/pedido.module#PedidoPageModule' },  { path: 'meus-dados', loadChildren: './pages/conta-usuario/meus-dados/meus-dados.module#MeusDadosPageModule' },
  { path: 'endereco', loadChildren: './pages/conta-usuario/endereco/endereco.module#EnderecoPageModule' },




];

@NgModule({
  imports: [
    RouterModule.forRoot(routes, { preloadingStrategy: PreloadAllModules })
  ],
  exports: [RouterModule]
})
export class AppRoutingModule { }
