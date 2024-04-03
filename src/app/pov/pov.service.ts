import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http'
import { Observable } from 'rxjs';
import { PovComponent } from './pov.component';
import { Pov } from '../dto/pov';
import { environment } from 'src/environments/environment';
import { Appliance } from '../dto/appliance';
import { Client } from '../dto/client';
import { Sceance } from '../dto/sceance';
import { Suivi } from '../dto/suivi';

@Injectable({
  providedIn: 'root'
})
export class PovService {
    
  readonly APIurl=environment.baseURL;

  constructor(private httpClient: HttpClient) { 
 
  }
  
  getPovList(): Observable<Pov[]>{
    return this.httpClient.get<Pov[]>(this.APIurl+"pov/all");
  }
  getListAppliance(): Observable<Appliance[]>{
    return this.httpClient.get<Appliance[]>(this.APIurl+"appliance/all")
  }
  getListClient(): Observable<Client[]>{
    return this.httpClient.get<Client[]>(this.APIurl+"client/all")
  }
  deletePov(id: number) {
    return this.httpClient.delete(this.APIurl+"pov/delete/"+id);
  }
  createPov(pov: Pov){
    console.log(pov);
    return this.httpClient.post(this.APIurl+"pov/add",pov);
  }
  updatePov(id : number): Observable<Object>{
    return this.httpClient.put(this.APIurl+"pov/update/",id);
  }
  getByRow(id :number):Observable<Pov[]>{
    return this.httpClient.get<Pov[]>(this.APIurl+"pov/find/"+id);
  }
  getByClient(client:Client): Observable<Pov[]>{
    return this.httpClient.post<Pov[]>(this.APIurl+"pov/client",client)
  }
  getByAppliance(appliance:Appliance): Observable<Pov[]>{
    return this.httpClient.post<Pov[]>(this.APIurl+"pov/appliance",appliance)
  }
  getListSceance(pov:Pov): Observable<Sceance[]>{
    return this.httpClient.post<Sceance[]>(this.APIurl+"sceance/pov",pov)
  }
  getListSuivi(pov:Pov): Observable<Suivi[]>{
    return this.httpClient.post<Suivi[]>(this.APIurl+"suivi/pov",pov)
  }
  // exportpdf(){
  //   return this.httpClient.get<any>(this.APIurl+"report/povpdf/all")
  // }
  download(file: string | undefined): Observable<Blob> {
    return this.httpClient.get(this.APIurl+"report/povpdf/all", {
      responseType: 'blob'
    });
  }
}