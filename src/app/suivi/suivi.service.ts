import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http'
import { Observable } from 'rxjs';
import { SuiviComponent } from './suivi.component';
import { Suivi } from '../dto/suivi';
import { environment } from 'src/environments/environment';
import { Pov } from '../dto/pov';
import { TypePrestation } from '../dto/typePrestation';

@Injectable({
  providedIn: 'root'
})
export class SuiviService {
    
  readonly APIurl=environment.baseURL;

  constructor(private httpClient: HttpClient) { 
 
  }
  
  getSuiviList(): Observable<Suivi[]>{
    return this.httpClient.get<Suivi[]>(this.APIurl+"suivi/all");
  }
  getPovList(): Observable<Pov[]>{
    return this.httpClient.get<Pov[]>(this.APIurl+"pov/all");
  }
  getTypePrestationList(): Observable<TypePrestation[]>{
    return this.httpClient.get<TypePrestation[]>(this.APIurl+"typePrestation/all");
  }
  deleteSuivi(id: number) {
    return this.httpClient.delete(this.APIurl+"suivi/delete/"+id);
    //return this.httpClient.delete(`${this.baseURL}/delete/${id}`);
  }
  createSuivi(suivi: Suivi){
    return this.httpClient.post(this.APIurl+"suivi/add/",suivi);
  }
  updateSuivi(id : number): Observable<Object>{
    return this.httpClient.put(this.APIurl+"suivi/update/",id);
  }
  getByRow(id :number):Observable<Suivi[]>{
    return this.httpClient.get<Suivi[]>(this.APIurl+"suivi/find/"+id);
  }

}