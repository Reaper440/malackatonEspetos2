import { Injectable } from '@angular/core';
import {Observable} from 'rxjs';
import { HttpClient } from '@angular/common/http';
import {Embalse } from '../entities/embalse';

@Injectable({
    providedIn: 'root'
})
export class EmbalseService {
    private baseURL = 'https://g1b806902581efa-retomalackaton.adb.eu-madrid-1.oraclecloudapps.com/ords/espetitos/embalses/';

    constructor(private http: HttpClient) {}

    getEmbalses(): Observable<Embalse[]> {
      return this.http.get<Embalse[]>(this.baseURL);
    }

    getEmbalse(id: number): Observable<Embalse> {
      return this.http.get<Embalse>(this.baseURL + id);
    }

}