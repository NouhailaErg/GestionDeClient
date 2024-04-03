import { Appliance } from "./appliance";
import { Client } from "./client";

export interface Pov{
    id : number;
	appliance : Appliance;
	client : Client;
    date_debut: Date ;
	date_fin : Date;
	description : String;
	compteManager : String;
	ingenieurCybersecurite : String;
	analyseCybersecurity : String;
	libelle_pov :String;
}