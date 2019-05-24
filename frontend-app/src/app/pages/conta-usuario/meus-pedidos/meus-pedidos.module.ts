import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { FormsModule } from '@angular/forms';
import { Routes, RouterModule } from '@angular/router';

import { IonicModule } from '@ionic/angular';

import { MeusPedidosPage } from './meus-pedidos.page';

const routes: Routes = [
  {
    path: '',
    component: MeusPedidosPage
  }
];

@NgModule({
  imports: [
    CommonModule,
    FormsModule,
    IonicModule,
    RouterModule.forChild(routes)
  ],
  declarations: [MeusPedidosPage]
})
export class MeusPedidosPageModule {}
