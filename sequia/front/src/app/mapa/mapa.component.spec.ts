import { ComponentFixture, TestBed } from '@angular/core/testing';

import { MapaComponent } from './mapa.component';

import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-geolocalizacion',
  templateUrl: './mapa.component.html',
  styleUrls: ['./mapa.component.css']
})

export class GeolocalizacionComponent implements OnInit {
  latitude: number | undefined;
  longitude: number | undefined;
  error: string | undefined;

  constructor() { }

  ngOnInit(): void {
    this.getLocation();
  }

  getLocation(): void {
    if (navigator.geolocation) {
      navigator.geolocation.getCurrentPosition(
        (position) => {
          this.latitude = position.coords.latitude;
          this.longitude = position.coords.longitude;
        },
        (error) => {
          this.error = 'Error al obtener la ubicación: ' + error.message;
        }
      );
    } else {
      this.error = 'Geolocalización no es soportada por este navegador.';
    }
  }
}

describe('MapaComponent', () => {
  let component: MapaComponent;
  let fixture: ComponentFixture<MapaComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [MapaComponent]
    })
    .compileComponents();
    
    fixture = TestBed.createComponent(MapaComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
