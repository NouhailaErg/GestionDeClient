import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http'
import { Observable } from 'rxjs';
import { ClientComponent } from './client.component';
import { Client } from '../dto/client';
import { environment } from 'src/environments/environment';
import { Contact } from '../dto/contact';

@Injectable({
  providedIn: 'root'
})
export class ClientService {
    
readonly APIurl=environment.baseURL;
  constructor(private httpClient: HttpClient) { 
 
  }
  
  getClientList(): Observable<any>{
    return this.httpClient.get<any>(this.APIurl+"client/all");
  }
  deleteClient(id: number) {
    return this.httpClient.delete(this.APIurl+"client/delete/"+id);
  }
  createClient(client: Client){
    return this.httpClient.post(this.APIurl+"client/add",client);
  }
  getClientConta(client:Client): Observable<Contact[]>{
    return this.httpClient.post<Contact[]>(this.APIurl+"contact/client",client);
  }
  updateClient(client : Client): Observable<Object>{
    return this.httpClient.put(this.APIurl+"client/update",client);
  }
  getByRow(id :number):Observable<Client[]>{
    return this.httpClient.get<Client[]>(this.APIurl+"client/find/"+id);
  }
  download(file: string | undefined): Observable<Blob> {
    return this.httpClient.get(this.APIurl+"client/clientpdf/client", {
      responseType: 'blob'
    });
  }
}