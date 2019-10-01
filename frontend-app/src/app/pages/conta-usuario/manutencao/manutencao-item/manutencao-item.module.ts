import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { FormsModule } from '@angular/forms';
import { Routes, RouterModule } from '@angular/router';

import { IonicModule } from '@ionic/angular';

import { ManutencaoItemPage } from './manutencao-item.page';

const routes: Routes = [
  {
    path: '',
    component: ManutencaoItemPage
  }
];

@NgModule({
  imports: [
    CommonModule,
    FormsModule,
    IonicModule,
    RouterModule.forChild(routes)
  ],
  declarations: [ManutencaoItemPage]
})
export class ManutencaoItemPageModule {}
