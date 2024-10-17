import { Component } from '@angular/core';
import { NgbModal} from '@ng-bootstrap/ng-bootstrap';
import { Embalse } from '../entities/embalse';
import { EmbalseService } from '../services/embalse.service';

@Component({
  selector: 'app-lista',
  templateUrl: './lista.component.html',
  styleUrl: './lista.component.css'
})
export class ListaComponent {
  
  busq: string = ""
  embalses: Embalse[] = [];
  embalsesFiltrados: Embalse[] = [];

  constructor(private embalseService: EmbalseService, private modalService: NgbModal) { }

  ngOnInit(): void {
    this.actualizaEmbalses();
  }

  private actualizaEmbalses(id?: number): void {
    this.embalseService.getEmbalses()
      .subscribe(embalses => {
        this.embalses = embalses;
        this.embalsesFiltrados = embalses;
      });
  }

  filtrarEmbalses() : void {
    if (this.busq!="") {
      let s = this.busq.normalize("NFD").replace(/[\u0300-\u036f]/g, "").toLowerCase();
      this.embalsesFiltrados = [];
      let sz  = s.length;
      for(let i = 0; i < this.embalses.length; i++) {
        let estar  = false;
        for(let j = 0; j - sz < this.embalses[i].embalseNombre.length && !estar; j++) {
          let subs = this.embalses[i].embalseNombre.substring(j, j+sz);
          if (s==subs.normalize("NFD").replace(/[\u0300-\u036f]/g, "").toLowerCase()) {
            this.embalsesFiltrados.push(this.embalses[i]);
          }
        }
      }
    } else {
      this.embalsesFiltrados = this.embalses;
    }
  }

  borrarBusqueda() : void {
    this.busq = "";
    this.filtrarEmbalses();
  }
}
