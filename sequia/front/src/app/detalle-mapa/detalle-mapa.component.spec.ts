import { ComponentFixture, TestBed } from '@angular/core/testing';

import { DetalleMapaComponent } from './detalle-mapa.component';

describe('DetalleMapaComponent', () => {
  let component: DetalleMapaComponent;
  let fixture: ComponentFixture<DetalleMapaComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [DetalleMapaComponent]
    })
    .compileComponents();

    fixture = TestBed.createComponent(DetalleMapaComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
