import { Pov } from "./pov";

export interface Sceance{
    id: number;
    date_sceance : Date;
    resumer : String;
    participant : String;
    pov : Pov
}