import { Client } from "./client";

export interface Contact{
    id : number;
    nom : String;
    prenom : String;
    telephone : String;
    fonction : String;
    client: Client
    email : String;
}
