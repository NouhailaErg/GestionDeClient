import { HttpClientModule } from '@angular/common/http';
import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { NgbModule } from '@ng-bootstrap/ng-bootstrap';


import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { ApplianceComponent } from './appliance/appliance.component';
import { NewApplianceComponent } from './new-appliance/new-appliance.component';
import { TypeComponent } from './type/type.component';
import { ClientComponent } from './client/client.component';
import { PovComponent } from './pov/pov.component';
import { ContactComponent } from './contact/contact.component';
import { SceanceComponent } from './sceance/sceance.component';
import { SuiviComponent } from './suivi/suivi.component';
import { TypePrestationComponent } from './type-prestation/type-prestation.component';
import {NgxPaginationModule} from 'ngx-pagination';
import { FormsModule } from '@angular/forms';
import { ReactiveFormsModule } from '@angular/forms';
import { NgSelectModule } from '@ng-select/ng-select';
import { ConfirmationPopoverModule } from 'angular-confirmation-popover';
import { Ng2SearchPipeModule } from 'ng2-search-filter';
import { DetailClientComponent } from './detail-client/detail-client.component';
import { DetailSesuComponent } from './detail-sesu/detail-sesu.component';
import { GenericListFilterModule } from 'generic-list-filter';
import { LoginComponent } from './login/login.component';
import { AdminTemplateComponent } from './admin-template/admin-template.component';
import { HomeComponent } from './home/home.component';
import { saveAs } from 'file-saver';

@NgModule({
  declarations: [
    AppComponent,
    ApplianceComponent,
    NewApplianceComponent,
    TypeComponent,
    ClientComponent,
    PovComponent,
    ContactComponent,
    SceanceComponent,
    SuiviComponent,
    TypePrestationComponent,
    DetailClientComponent,
    DetailSesuComponent,
    LoginComponent,
    AdminTemplateComponent,
    HomeComponent  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    NgbModule,
    HttpClientModule,
    NgxPaginationModule,
    FormsModule,
    
    ReactiveFormsModule,
    Ng2SearchPipeModule,
    NgSelectModule,
    GenericListFilterModule,
    ConfirmationPopoverModule.forRoot({
      confirmButtonType: 'danger', // set defaults here
    }),
    
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
