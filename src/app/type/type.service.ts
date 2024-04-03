import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http'
import { Observable } from 'rxjs';
import { TypeComponent } from './type.component';
import { Type } from '../dto/Type';
import { environment } from 'src/environments/environment';

@Injectable({
  providedIn: 'root'
})
export class TypeService {
    
  readonly APIurl=environment.baseURL;
  constructor(private httpClient: HttpClient) { 
 
  }
  
  getTypeList(): Observable<any>{
    return this.httpClient.get<any>(this.APIurl+"type/all");
  }
  deleteType(id: number) {
    return this.httpClient.delete(this.APIurl+"type/delete/"+id);
  }
  createType(type: Type){
    return this.httpClient.post(this.APIurl+"type/add",type);
  }
  updateType(type : Type): Observable<Object>{
    return this.httpClient.put(this.APIurl+"type/update/",type);
  }
  getByRow(id :number):Observable<Type[]>{
    return this.httpClient.get<Type[]>(this.APIurl+"type/find/"+id);
  }

}