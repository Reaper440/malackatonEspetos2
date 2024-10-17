import { NgModule } from '@angular/core';
import { BrowserModule, provideClientHydration } from '@angular/platform-browser';
import { NgbModule } from '@ng-bootstrap/ng-bootstrap';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { MapaComponent } from './mapa/mapa.component';
import { ListaComponent } from './lista/lista.component';
import { EmbalseComponent } from './embalse/embalse.component';

@NgModule({
  declarations: [
    AppComponent,
    MapaComponent,
    ListaComponent,
    EmbalseComponent
  ],
  imports: [
    BrowserModule,
    NgModule,
    AppRoutingModule
  ],
  providers: [
    provideClientHydration()
  ],
  bootstrap: [AppComponent]
})
export class AppModule { }
