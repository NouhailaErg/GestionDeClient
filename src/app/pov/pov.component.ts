import { Component, OnInit } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Router } from '@angular/router';
import { PovService } from './pov.service';
import { Pov } from '../dto/pov';
import { ModalDismissReasons, NgbModal } from '@ng-bootstrap/ng-bootstrap';
import { FormBuilder, FormGroup } from '@angular/forms';
import { Appliance } from '../dto/appliance';
import { Client } from '../dto/client';
import { ApplianceService } from '../appliance/appliance.service';
import { ClientService } from '../client/client.service';
import Swal from 'sweetalert2';
import { DetailClientComponent } from '../detail-client/detail-client.component';
import { Contact } from '../dto/contact';
import { DetailSesuComponent } from '../detail-sesu/detail-sesu.component';
 import { saveAs } from 'file-saver';

@Component({
  selector: 'app-pov',
  templateUrl: './pov.component.html',
  styleUrls: ['./pov.component.css']
  
})
export class PovComponent implements OnInit {

  reactiveForm !: FormGroup;
  pov !: Pov[];
  appliance!: Appliance[];
  client!: Client[];
  closeResult !: string;
  contact !: Contact[];
  multiple !: boolean ;
  
  
  constructor( private httpCleint:HttpClient,private povService: PovService,
    private router: Router,
    private applianceService: ApplianceService,
    private clientService: ClientService,
    private modalService: NgbModal,
    private fb:FormBuilder) { }
    totalLenght : any;
    page : number = 1;
    filterTerm!: string;
    filterTerm1 !: string;
  ngOnInit(): void {
    this.getPov();
    this.getAppliance();
    this.getClient();
  }
//   FilterForm= {
//    appliance:['sahar','Katy'],
//    client:['nouhaila','test']
//  };
//  filterChange(appliedfilters: any) {
//   console.log(appliedfilters);
  
// }
 
downloadFile(filename: string): void {
  this.povService
    .download(filename)
    .subscribe(blob => saveAs(blob, filename));
}
  
  povForm=this.fb.group({
  appliance:[],
  client:[],
  date_debut:[],
  date_fin:[],
  description:[],
  compteManager:[],
  ingenieurCybersecurite:[],
  analyseCybersecurity:[],
  libelle_pov:[]
 })

 EditForm= this.fb.group({
   id :[],
  appliance:[],
  client:[],
  date_debut:[],
  date_fin:[],
  description:[],
  compteManager:[],
  ingenieurCybersecurite:[],
  analyseCybersecurity:[],
  libelle_pov:[]
});
// exportpdf(){
//   this.povService.exportpdf().subscribe(data =>{
//     return "hello"
//  })
// }
 
  private getPov() {
    this.povService.getPovList().subscribe(data =>{
       this.pov = data;
       this.totalLenght = data.length;
    })
   }
   povDetails(id: number){
     this.router.navigate(['pov-details', id]);
   }
   openContact(client:Client) {
    const modalRef = this.modalService.open(DetailClientComponent , {size:'lg'});
    modalRef.componentInstance.user = client;
    modalRef.componentInstance.us = this.contact;
  }
  openSceance(pov:Pov) {
    const modalRef = this.modalService.open(DetailSesuComponent , {size:'lg'});
    modalRef.componentInstance.user = pov;
  }
   updatePov(id: number){
    this.povService.getByRow(id).subscribe(data =>{
      console.log(data);
      this.getPov();
    })
   }
 
   deletePov(id: number){
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
        this.povService.deletePov(id).subscribe( data => {
              console.log(data);
           this.getPov();
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
    //  this.povService.deletePov(id).subscribe( data => {
    //    console.log(data);
    // this.getPov();
    //  })
 }
 private getAppliance(){
  this.applianceService.getApplianceList().subscribe(data =>{
    this.appliance = data;
   
  })
}
private getClient(){
  this.clientService.getClientList().subscribe(data =>{
    this.client = data; 
  })
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
getByClient(client : Client){
this.povService.getByClient(client).subscribe(data =>{
  this.pov = data;
  console.log(data);
})
}
onSubmit() {
  this.povService.createPov(this.povForm.value).subscribe((result)=>{
    console.log(result);
    this.getPov;
  });
}
fillPovData!:any;
openEdit(Editcontent: any,idPov:number) {
  this.povService.getByRow(idPov).subscribe(data =>{
    this.fillPovData=data;
    console.log(data);
    
    this.EditForm.get('id')?.setValue(this.fillPovData.id);
    this.EditForm.get('appliance')?.setValue(this.fillPovData.appliance);
    this.EditForm.get('client')?.setValue(this.fillPovData.client);
    this.EditForm.get('date_debut')?.setValue(this.fillPovData.date_debut);
    this.EditForm.get('date_fin')?.setValue(this.fillPovData.date_fin);
    this.EditForm.get('description')?.setValue(this.fillPovData.description);
    this.EditForm.get('compteManager')?.setValue(this.fillPovData.compteManager);
    this.EditForm.get('ingenieurCybersecurite')?.setValue(this.fillPovData.ingenieurCybersecurite);
    this.EditForm.get('analyseCybersecurity')?.setValue(this.fillPovData.analyseCybersecurity);
    this.EditForm.get('libelle_pov')?.setValue(this.fillPovData.libelle_pov);

  })  
  this.modalService.open(Editcontent, {ariaLabelledBy: 'modal-basic-title'}).result.then((result) => {
    this.closeResult = `Closed with: ${result}`;
    
  }, (reason) => {
    this.closeResult = `Dismissed ${this.getDismissReason(reason)}`;
    
  });
}
onSave(){
  this.povService.updatePov(this.EditForm.value).subscribe((result)=>{
    console.log(result);
    this.getPov();
  });
 }
 


}
