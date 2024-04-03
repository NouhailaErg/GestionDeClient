import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http'
import { Observable } from 'rxjs';
import { ContactComponent } from './contact.component';
import { Contact } from '../dto/contact';
import { environment } from 'src/environments/environment';
import { Client } from '../dto/client';

@Injectable({
  providedIn: 'root'
})
export class ContactService {

  readonly APIurl=environment.baseURL;
  constructor(private httpClient: HttpClient) { 
 
  }
  
  getContactList(): Observable<Contact[]>{
    return this.httpClient.get<Contact[]>(this.APIurl+"contact/all");
  }
  getClientList(): Observable<Client[]>{
    return this.httpClient.get<Client[]>(this.APIurl+"client/all");
  }
  createContact(contact: Contact){
    return this.httpClient.post(this.APIurl+"contact/add",contact);
  }
  updateContact(id_contact: number): Observable<Object>{
    return this.httpClient.put(this.APIurl+"contact/update/", id_contact);
  }
  deleteContact(id: number) {
    return this.httpClient.delete(this.APIurl+"contact/delete/"+id);
  }
  getByRow(id :number):Observable<Contact[]>{
    return this.httpClient.get<Contact[]>(this.APIurl+"contact/find/"+id);
  }
  getClientCon(client : Client):Observable<Client[]>{
    return this.httpClient.post<Client[]>(this.APIurl+"contact/client",client);
  }
}