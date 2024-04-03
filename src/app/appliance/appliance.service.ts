import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http'
import { Observable } from 'rxjs';
import { ApplianceComponent } from './appliance.component';
import { Appliance } from '../dto/appliance';
import { environment } from 'src/environments/environment';
import { Type } from '../dto/Type';
import { Pov } from '../dto/pov';
import { Client } from '../dto/client';
import { Contact } from '../dto/contact';
import { Sceance } from '../dto/sceance';

@Injectable({
  providedIn: 'root'
})
export class ApplianceService {

   
  readonly APIurl=environment.baseURL;

  constructor(private httpClient: HttpClient) { 
 
  }
  getListType(): Observable<Type[]>{
    return this.httpClient.get<Type[]>(this.APIurl+"type/all")
  }
  getListPov(applaince:Appliance): Observable<Pov[]>{
    return this.httpClient.post<Pov[]>(this.APIurl+"pov/appliance",applaince)
  }
  getListClient(client : Client): Observable<Contact[]>{
    return this.httpClient.post<Contact[]>(this.APIurl+"contact/client",client)
  }
  getApplianceList(): Observable<Appliance[]>{
    return this.httpClient.get<Appliance[]>(this.APIurl+"appliance/all");
  }
  createAppliance(data: any){
    console.log(data);
    return this.httpClient.post(this.APIurl+"appliance/add",data);
  }
  updateAppliance(id_appliance: number): Observable<Object>{
    return this.httpClient.put(this.APIurl+"appliance/update/",id_appliance);
  }
  deleteAppliance(id: number) {
    return this.httpClient.delete(this.APIurl+"appliance/delete/"+id);
  }
  getByRow(id :number):Observable<Appliance[]>{
    return this.httpClient.get<Appliance[]>(this.APIurl+"appliance/find/"+id);
  }
  download(file: string | undefined): Observable<Blob> {
    return this.httpClient.get(this.APIurl+"appliance/applipdf/appliance", {
      responseType: 'blob'
    });
  }
}