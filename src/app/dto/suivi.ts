import { Pov } from "./pov";
import { TypePrestation } from "./typePrestation";

export interface Suivi{
    id: number;
    offre_com : Boolean;
    montant : number;
    typePrestation : TypePrestation
    compte_rendu : String;
    pov : Pov
}