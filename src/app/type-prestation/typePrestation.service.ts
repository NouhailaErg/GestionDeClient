import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http'
import { Observable } from 'rxjs';
import { TypePrestationComponent } from './type-prestation.component';
import { TypePrestation } from '../dto/typePrestation';
import { environment } from 'src/environments/environment';

@Injectable({
  providedIn: 'root'
})
export class TypePrestationService {


  readonly APIurl=environment.baseURL;


  constructor(private httpClient: HttpClient) { 
 
  }
  
  getTypePrestationList(): Observable<any>{
    return this.httpClient.get<any>(this.APIurl+"typePrestation/all");
  }
  deleteTypePrestation(id: number) {
    return this.httpClient.delete(this.APIurl+"typePrestation/delete/"+id);
  }
  creatTypePrestation(typePrestation: TypePrestation){
    return this.httpClient.post(this.APIurl+"typePrestation/add",typePrestation);
  }
  updateTypePrestation(typePrestation : TypePrestation): Observable<Object>{
    return this.httpClient.put(this.APIurl+"typePrestation/update/",typePrestation);
  }
  getByRow(id :number):Observable<TypePrestation[]>{
    return this.httpClient.get<TypePrestation[]>(this.APIurl+"typePrestation/find/"+id);
  }

}