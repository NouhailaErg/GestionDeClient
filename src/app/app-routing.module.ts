import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { AdminTemplateComponent } from './admin-template/admin-template.component';
import { ApplianceComponent } from './appliance/appliance.component';
import { ClientComponent } from './client/client.component';
import { ContactComponent } from './contact/contact.component';
import { HomeComponent } from './home/home.component';
import { LoginComponent } from './login/login.component';
import { NewApplianceComponent } from './new-appliance/new-appliance.component';
import { PovComponent } from './pov/pov.component';
import { SceanceComponent } from './sceance/sceance.component';
import { SuiviComponent } from './suivi/suivi.component';
import { TypePrestationComponent } from './type-prestation/type-prestation.component';
import { TypeComponent } from './type/type.component';

const routes: Routes = [
  {path : 'login', component: LoginComponent},
  {path : '', component: LoginComponent},
  {path : '', component: LoginComponent},
  {path : 'admin', component: AdminTemplateComponent, children : [
    {path : 'appliance', component: ApplianceComponent},
    {path : 'new-appliance', component: NewApplianceComponent},
    {path :'type', component: TypeComponent},
    {path :'client', component: ClientComponent},
    {path : 'pov', component: PovComponent},
    {path : 'contact', component: ContactComponent},
    {path: 'sceance', component: SceanceComponent},
    {path: 'suivi', component: SuiviComponent},
    {path:'typePrestation', component: TypePrestationComponent},
  ]},
  {path: 'home', component: HomeComponent},
  {path:'login', component: LoginComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
