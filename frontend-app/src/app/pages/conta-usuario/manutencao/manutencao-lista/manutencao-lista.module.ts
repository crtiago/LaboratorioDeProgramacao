import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { FormsModule } from '@angular/forms';
import { Routes, RouterModule } from '@angular/router';

import { IonicModule } from '@ionic/angular';

import { ManutencaoListaPage } from './manutencao-lista.page';

const routes: Routes = [
  {
    path: '',
    component: ManutencaoListaPage
  }
];

@NgModule({
  imports: [
    CommonModule,
    FormsModule,
    IonicModule,
    RouterModule.forChild(routes)
  ],
  declarations: [ManutencaoListaPage]
})
export class ManutencaoListaPageModule {}
