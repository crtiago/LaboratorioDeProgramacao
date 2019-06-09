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
  { path: 'manutencao-lista', loadChildren: './pages/conta-usuario/manutencao/manutencao-lista/manutencao-lista.module#ManutencaoListaPageModule' },
  { path: 'manutencao-item', loadChildren: './pages/conta-usuario/manutencao/manutencao-item/manutencao-item.module#ManutencaoItemPageModule' },
  { path: 'pedido', loadChildren: './pages/conta-usuario/pedido/pedido.module#PedidoPageModule' },



];

@NgModule({
  imports: [
    RouterModule.forRoot(routes, { preloadingStrategy: PreloadAllModules })
  ],
  exports: [RouterModule]
})
export class AppRoutingModule { }
