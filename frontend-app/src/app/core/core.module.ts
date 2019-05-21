import { NgModule } from '@angular/core';
import { IonicModule, IonicRouteStrategy } from '@ionic/angular';
import { BrowserModule } from '@angular/platform-browser';
import { StatusBar } from '@ionic-native/status-bar/ngx';
import { SplashScreen } from '@ionic-native/splash-screen/ngx';
import { RouteReuseStrategy } from '@angular/router';
import { CategoriaService } from 'src/services/domain/categoria.service';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';

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
    { provide: RouteReuseStrategy, useClass: IonicRouteStrategy }
  ],
})
export class CoreModule { }
