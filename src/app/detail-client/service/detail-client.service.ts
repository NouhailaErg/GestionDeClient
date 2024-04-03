import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Client } from 'src/app/dto/client';
import { Contact } from 'src/app/dto/contact';
import { environment } from 'src/environments/environment';

@Injectable({
  providedIn: 'root'
})
export class DetailClientService {

  readonly APIurl=environment.baseURL;

  constructor(private httpClient: HttpClient) { }
  getClientConta(client:Client): Observable<Contact[]>{
    return this.httpClient.post<Contact[]>(this.APIurl+"contact/client",client);
  }
  createContact(contact: Contact){
    return this.httpClient.post(this.APIurl+"contact/add",contact);
  }
  getByRow(id :number):Observable<Client[]>{
    return this.httpClient.get<Client[]>(this.APIurl+"client/find/"+id);
  }
}
