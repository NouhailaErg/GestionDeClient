import { HttpClient } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup } from '@angular/forms';
import { Router } from '@angular/router';
import { ModalDismissReasons, NgbModal } from '@ng-bootstrap/ng-bootstrap';
import { Client } from '../dto/client';
import { ClientService } from './client.service';
import { DetailClientComponent } from '../detail-client/detail-client.component';
import Swal from 'sweetalert2';
import { Contact } from '../dto/contact';
import * as saveAs from 'file-saver';
@Component({
  selector: 'app-client',
  templateUrl: './client.component.html',
  styleUrls: ['./client.component.css']
})
export class ClientComponent implements OnInit {

  reactiveForm !: FormGroup;
  disableDetail : boolean = false;
  contact !: Contact[];
  client !: Client[];
  closeResult!: string;
  saveResponse : any;
  constructor(private httpCleint:HttpClient,
    private clientService: ClientService,
    private router: Router,
    private modalService: NgbModal,
    private fb:FormBuilder,
    ) { }
     
    totalLenght : any;
    page : number = 1;
    filterTerm!: string;
  ngOnInit(): void {
    this.getClient();

  }
  clientForm=this.fb.group({
    id_client:[],
   libelle:[],
   secteur:[],
   activite:[],
 })
 EditForm= this.fb.group({
  id_client:[],
   libelle:[],
   secteur:[],
   activite:[],
});
  private getClient() {
    this.clientService.getClientList().subscribe(data =>{
       this.client = data;
       this.totalLenght = data.length;
    })
   }
   clientDetails(id_client: number){
     this.router.navigate(['client-details', id_client]);
   }
   downloadFile(filename: string): void {
    this.clientService
      .download(filename)
      .subscribe(blob => saveAs(blob, filename));
  }
   updateClient(id: number){
    this.clientService.getByRow(id).subscribe(data =>{
      console.log(data);
      this.getClient();
    })
  }
 
   deleteClient(id: number){
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
        this.clientService.deleteClient(id).subscribe( data => {
              console.log(data);
              this.getClient();
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
    //  this.clientService.deleteClient(id).subscribe( data => {
    //    console.log(data);
    //    this.getClient();
    //  })
 }
 openContact(client:Client) {
  const modalRef = this.modalService.open(DetailClientComponent , {size:'lg'});
  modalRef.componentInstance.user = client;
  modalRef.componentInstance.us = this.contact;
}
 open(contentClient: any) {
  this.modalService.open(contentClient, {ariaLabelledBy: 'modal-basic-title'}).result.then((result) => {
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
onSubmit() {
   this.clientService.createClient(this.clientForm.value).subscribe((result)=>{
     console.log(result);
     this.getClient();
   });
}
fillClientData!:any;
openEdit(Editcontent: any,idClient:number) {
  this.clientService.getByRow(idClient).subscribe(data =>{
    this.fillClientData=data;
   
    
    this.EditForm.get('id_client')?.setValue(this.fillClientData.id_client);
    this.EditForm.get('libelle')?.setValue(this.fillClientData.libelle);
    this.EditForm.get('secteur')?.setValue(this.fillClientData.secteur);
    this.EditForm.get('activite')?.setValue(this.fillClientData.activite);
    console.log(this.EditForm.value);
  })
  this.modalService.open(Editcontent, {ariaLabelledBy: 'modal-basic-title'}).result.then((result) => {
    this.closeResult = `Closed with: ${result}`;
    
  }, (reason) => {
    this.closeResult = `Dismissed ${this.getDismissReason(reason)}`;
    

  });
}
onSave(){
  this.clientService.updateClient(this.EditForm.value).subscribe((result)=>{
    console.log(result);
  });
 }

}
