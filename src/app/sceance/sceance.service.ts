import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http'
import { Observable } from 'rxjs';
import { SceanceComponent } from './sceance.component';
import { Sceance } from '../dto/sceance';
import { environment } from 'src/environments/environment';
import { Pov } from '../dto/pov';

@Injectable({
  providedIn: 'root'
})
export class SceanceService {
    
  readonly APIurl=environment.baseURL;

  constructor(private httpClient: HttpClient) { 
 
  }
  
  getSceanceList(): Observable<Sceance[]>{
    return this.httpClient.get<Sceance[]>(this.APIurl+"sceance/all");
  }
  getPovList(): Observable<Pov[]>{
    return this.httpClient.get<Pov[]>(this.APIurl+"pov/all");
  }
  deleteSceance(id: number) {
    return this.httpClient.delete(this.APIurl+"sceance/delete/"+id);
  }
  createSceance(sceance: Sceance){
    return this.httpClient.post(this.APIurl+"sceance/add",sceance);
  }
  updateSceance(sceance : Sceance): Observable<Object>{
    return this.httpClient.put(this.APIurl+"sceance/update/",sceance);
  }
  getByRow(id :number):Observable<Sceance[]>{
    return this.httpClient.get<Sceance[]>(this.APIurl+"sceance/find/"+id);
  }
  getListSceance(pov:Pov): Observable<Sceance[]>{
    return this.httpClient.post<Sceance[]>(this.APIurl+"sceance/pov",pov)
  }

}