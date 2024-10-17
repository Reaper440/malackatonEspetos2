import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { MapaComponent } from './mapa/mapa.component'; // Asegúrate de importar el componente

const routes: Routes = [
  { path: 'geolocalizacion', component: MapaComponent },
  // Otras rutas
  { path: '', redirectTo: '/geolocalizacion', pathMatch: 'full' } // Ruta por defecto
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }