import { NgModule } from '@angular/core';
import { IonicModule, IonicRouteStrategy } from '@ionic/angular';
import { BrowserModule } from '@angular/platform-browser';
import { StatusBar } from '@ionic-native/status-bar/ngx';
import { SplashScreen } from '@ionic-native/splash-screen/ngx';
import { RouteReuseStrategy } from '@angular/router';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';

import localePt from '@angular/common/locales/pt';
import { registerLocaleData } from '@angular/common';
registerLocaleData(localePt);

import { CategoriaService } from 'src/services/domain/categoria.service';
import { UsuarioService } from 'src/services/domain/usuario.service';
import { ProdutoVendaService } from 'src/services/domain/produtoVenda.service'

@NgModule({
  imports: [
    IonicModule.forRoot(),
    FormsModule,
    ReactiveFormsModule
  ],
  exports: [
    BrowserModule,
    IonicModule,
  ],
  providers: [
    StatusBar,
    SplashScreen,
    CategoriaService,
    UsuarioService,
    ProdutoVendaService,
    { provide: RouteReuseStrategy, useClass: IonicRouteStrategy }
  ],
})
export class CoreModule { }
