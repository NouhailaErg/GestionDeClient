 //import { Type } from "@angular/compiler/public_api";

import { Type } from "./Type";

//import { Type } from "@angular/compiler/src/core";

export class Appliance{
    id_appliance !: number;
    libelle !: String;
    type !: Type;//{id: number;}
    dbid !: String;
    disponibilite !: Boolean;
    reference !: String;

}