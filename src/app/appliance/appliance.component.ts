import { getNumberOfCurrencyDigits } from '@angular/common';
import { HttpClient } from '@angular/common/http';
import { ValueConverter } from '@angular/compiler/src/render3/view/template';
import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormControl, FormControlDirective, FormGroup, NgForm } from '@angular/forms';
import { Router } from '@angular/router';
import { ModalDismissReasons, NgbModal } from '@ng-bootstrap/ng-bootstrap';
import { getValueInRange } from '@ng-bootstrap/ng-bootstrap/util/util';
import { Appliance } from '../dto/appliance';
import { Pov } from '../dto/pov';
import { Type } from '../dto/Type';
import { TypeService } from '../type/type.service';
import { ApplianceService } from './appliance.service';
import Swal from 'sweetalert2';
import { Client } from '../dto/client';
import { Contact } from '../dto/contact';
import { ContactService } from '../contact/contact.service';
import { ClientService } from '../client/client.service';
import { SceanceService } from '../sceance/sceance.service';
import { PovService } from '../pov/pov.service';
import { Sceance } from '../dto/sceance';
import { Suivi } from '../dto/suivi';
import { SuiviService } from '../suivi/suivi.service';
import { ClientComponent } from '../client/client.component';
import { ContactComponent } from '../contact/contact.component';
import { DetailClientComponent } from '../detail-client/detail-client.component';
import { DetailSesuComponent } from '../detail-sesu/detail-sesu.component';
import * as saveAs from 'file-saver';




@Component({
  selector: 'app-appliance',
  templateUrl: './appliance.component.html',
  styleUrls: ['./appliance.component.css']
})
export class ApplianceComponent implements OnInit {

  reactiveForm !: FormGroup;
  // disableDetail : boolean = false;
  disableDelete : boolean = true;
  appliance!: Appliance[];
  type !: Type[];
  pov !: Pov[];
  client !: Client[];
  contact !: Contact[];
  sceance !: Sceance[];
  suivi !: Suivi[];
  applianceDto : Appliance = new Appliance();
  public totalPages !: number;
  closeResult !: string;
  saveResponse : any;
  showTable: boolean = false;
  showTablec: boolean = false;

  title:string="test";

  constructor(private httpClient:HttpClient,
    private applianceService: ApplianceService,
    private router: Router,
    private modalService: NgbModal,
    private fb:FormBuilder,
    private typeService : TypeService,
    private clientService :ClientService,
    private contactService : ContactService,
    private povService : PovService,
    private sceanceService : SceanceService,
    private suiviService : SuiviService) { }
    
    totalLenght : any;
    page : number = 1;
    filterTerm!: string;
  ngOnInit(): void {
    this.getAppliance();
    this.getType();
  //  this.Details();
  }

  applianceForm=this.fb.group({
     id_appliance:[],
    libelle:[],
    type:[],
    dbid:[],
    disponibilite:[],
    reference:[]
  })

  EditForm= this.fb.group({
    id_appliance:[], 
    libelle:[],
    type:[],
    dbid:[],
    disponibilite:[],
    reference:[]
  });
 
 sceanceForm=this.fb.group({
  id:[],
  date_sceance:[],
  resumer:[],
  participant:[],
  pov:[],
})
suiviForm=this.fb.group({
  id:[],
  offre_com:[],
  montant:[],
  typePrestation:[],
  compte_rendu:[],
  pov:[]
})
 fillContactData!:any;
openContact(client:Client) {
  const modalRef = this.modalService.open(DetailClientComponent , {size:'lg'});
  modalRef.componentInstance.user = client;
  modalRef.componentInstance.us = this.contact;
}
downloadFile(filename: string): void {
  this.applianceService
    .download(filename)
    .subscribe(blob => saveAs(blob, filename));
}
openSceance(pov:Pov) {
  const modalRef = this.modalService.open(DetailSesuComponent , {size:'lg'});
  modalRef.componentInstance.user = pov;
}

openSuivi(pov:Pov) {
  const modalRef = this.modalService.open(DetailSesuComponent , {size:'lg'});
  modalRef.componentInstance.user = pov;
}
  toggleShowTable(): void {
    this.showTable = !this.showTable;
}
// toggleShowTablec(): void {
//   this.showTablec = !this.showTablec;
// }
  private getAppliance(){
    this.applianceService.getApplianceList().subscribe(data =>{
      this.appliance = data;
      this.totalLenght = data.length;
     
    })
  }
  private getType(){
    this.typeService.getTypeList().subscribe(data =>{
      this.type = data;
    })
  }
 
   Details(appliance: Appliance){
    console.log(appliance);    
 this.applianceService.getListPov(appliance).subscribe(data =>{
  this.pov = data;
  console.log(data);
 }) }


//  getClientinfo(client : Client){
//   this.clientService.getClientConta(client).subscribe(data =>{
//     this.contact = data;
//     console.log(data);
//   })
//  }
//  getSceanceinfo(pov : Pov){
//   this.povService.getListSceance(pov).subscribe(data =>{
//     this.sceance = data;
//     console.log(data);
//   })
//  }
//  getSuiviinfo(pov : Pov){
//   this.povService.getListSuivi(pov).subscribe(data =>{
//     this.suivi = data;
//     console.log(data);
//   })
//  }

  updateAppliance(id: number){
    this.applianceService.getByRow(id).subscribe(data =>{
      console.log(data);
      this.getAppliance();
    })
  }

  deleteAppliance(id: number){
    const swalWithBootstrapButtons = Swal.mixin({
      customClass: {
        confirmButton: 'btn btn-success',
        cancelButton: 'btn btn-danger'
      },
      buttonsStyling: false
    })
    
    swalWithBootstrapButtons.fire({
      title: 'Are you sure?',
      text: "You won't be able to revert this!",
      icon: 'warning',
      showCancelButton: true,
      confirmButtonText: 'Yes, delete it!',
      cancelButtonText: 'No, cancel!',
      reverseButtons: true
    }).then((result) => {
      if (result.isConfirmed) {
        this.applianceService.deleteAppliance(id).subscribe( data => {
             console.log(data);
             this.getAppliance();
           })
      } else if (
        /* Read more about handling dismissals below */
        result.dismiss === Swal.DismissReason.cancel
      ) {
        swalWithBootstrapButtons.fire(
          'Cancelled',
          'Your imaginary file is safe :)',
          'error'
        )
      }
    })
    // this.applianceService.deleteAppliance(id).subscribe( data => {
    //   console.log(data);
    //   this.getAppliance();
    // })
}
fillApplianceData!:any;
openEdit(Editcontent: any,idAppliance:number) {
  this.applianceService.getByRow(idAppliance).subscribe(data =>{
    this.fillApplianceData=data;
    console.log(data);
    
    this.EditForm.get('id_appliance')?.setValue(this.fillApplianceData.id_appliance);
    this.EditForm.get('libelle')?.setValue(this.fillApplianceData.libelle);
    this.EditForm.get('type')?.setValue(this.fillApplianceData.type);
    this.EditForm.get('dbid')?.setValue(this.fillApplianceData.dbid);
    this.EditForm.get('reference')?.setValue(this.fillApplianceData.reference);

  })
  
  this.modalService.open(Editcontent, {ariaLabelledBy: 'modal-basic-title'}).result.then((result) => {
    this.closeResult = `Closed with: ${result}`;
    
  }, (reason) => {
    this.closeResult = `Dismissed ${this.getDismissReason(reason)}`;
    

  });
}
open(content: any) {
  this.modalService.open(content, {ariaLabelledBy: 'modal-basic-title'}).result.then((result) => {
    this.closeResult = `Closed with: ${result}`;
  }, (reason) => {
    this.closeResult = `Dismissed ${this.getDismissReason(reason)}`;
  });
}
private getDismissReason(reason: any): string {
  if (reason === ModalDismissReasons.ESC) {
    return 'by pressing ESC';
  } else if (reason === ModalDismissReasons.BACKDROP_CLICK) {
    return 'by clicking on a backdrop';
  } else {
    return `with: ${reason}`;
  }
}
 onSave(){
  this.applianceService.updateAppliance(this.EditForm.value).subscribe((result)=>{
    console.log(result);
    this.getAppliance();
  });
 }

onSubmit() {
   this.applianceService.createAppliance(this.applianceForm.value).subscribe((result)=>{
     console.log(result);
     this.getAppliance();
   });
}

 }
