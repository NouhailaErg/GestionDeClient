import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Suivi } from 'src/app/dto/suivi';
import { Sceance } from 'src/app/dto/sceance';
import { Pov } from 'src/app/dto/pov';
import { environment } from 'src/environments/environment';

@Injectable({
  providedIn: 'root'
})
export class DetailSesuService {

  readonly APIurl=environment.baseURL;

  constructor(private httpClient: HttpClient) { }

  getListSceance(pov:Pov): Observable<Sceance[]>{
    return this.httpClient.post<Sceance[]>(this.APIurl+"sceance/pov",pov)
  }
  getListSuivi(pov:Pov): Observable<Suivi[]>{
    return this.httpClient.post<Suivi[]>(this.APIurl+"suivi/pov",pov)
  }
}