import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { Routes, RouterModule } from '@angular/router';

import { IonicModule } from '@ionic/angular';

import { EnderecoPage } from './endereco.page';
import { CidadeEstadoService } from 'src/services/domain/cidade-estado.service';

const routes: Routes = [
  {
    path: '',
    component: EnderecoPage
  }
];

@NgModule({
  imports: [
    CommonModule,
    FormsModule,
    ReactiveFormsModule,
    IonicModule,
    RouterModule.forChild(routes)
  ],
  declarations: [EnderecoPage],
  providers: [
    CidadeEstadoService
  ]
})
export class EnderecoPageModule {}
