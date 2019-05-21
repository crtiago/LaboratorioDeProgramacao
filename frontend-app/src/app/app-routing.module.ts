import { NgModule } from '@angular/core';
import { PreloadAllModules, RouterModule, Routes } from '@angular/router';

const routes: Routes = [
  { path: '', redirectTo: 'login', pathMatch: 'full' },
  { path: 'login', loadChildren: './auth/pages/login/login.module#LoginPageModule' },
  { path: 'cadastro', loadChildren: './auth/pages/cadastro/cadastro.module#CadastroPageModule' },  { path: 'home', loadChildren: './pages/home/home.module#HomePageModule' },
  { path: 'carrinho', loadChildren: './pages/carrinho/carrinho.module#CarrinhoPageModule' },
  { path: 'minha-conta', loadChildren: './pages/minha-conta/minha-conta.module#MinhaContaPageModule' },


];

@NgModule({
  imports: [
    RouterModule.forRoot(routes, { preloadingStrategy: PreloadAllModules })
  ],
  exports: [RouterModule]
})
export class AppRoutingModule { }
