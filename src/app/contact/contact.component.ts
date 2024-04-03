import { HttpClient } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, NgForm } from '@angular/forms';
import { Router } from '@angular/router';
import { ModalDismissReasons, NgbModal } from '@ng-bootstrap/ng-bootstrap';
import { ClientService } from '../client/client.service';
import { Client } from '../dto/client';
import { Contact } from '../dto/contact';
import { ContactService } from './contact.service';
import Swal from 'sweetalert2';
import { ApplianceService } from '../appliance/appliance.service';

@Component({
  selector: 'app-contact',
  templateUrl: './contact.component.html',
  styleUrls: ['./contact.component.css']
})
export class ContactComponent implements OnInit {

  contact !: Contact[];
  closeResult !: string;
  reactiveForm !: FormGroup;
  saveResponse : any;
  client !: Client[];
  constructor(private httpClient:HttpClient,private contactService: ContactService,
    private router: Router,private modalService: NgbModal,
    private fb:FormBuilder,
    private applianceService: ApplianceService,
    private clientService : ClientService
    ) { }
    totalLenght : any;
    page : number = 1;
    filterTerm!: string;

  ngOnInit(): void {
    this.getContact();
    this.getClient();
  }
  contactForm=this.fb.group({
    id:[],
    nom:[],
    prenom:[],
    telephone:[],
    fonction:[],
    client:[],
    email:[]
 })

 EditForm= this.fb.group({
  id:[],
  nom:[],
  prenom:[],
  telephone:[],
  fonction:[],
  client:[],
  email:[]
 });

 getClientList(client : Client){
  this.contactService.getClientCon(client).subscribe(data =>{
    this.client = data;
    console.log(data);
  })
 }
  private getContact() {
    this.contactService.getContactList().subscribe(data =>{
       this.contact = data;
       this.totalLenght = data.length;
       console.log(this.contact);
       
    })
   }
   private getClient() {
    this.clientService.getClientList().subscribe(data =>{
       this.client = data;
    })
   }
   contactDetails(id: number){
     this.router.navigate(['contact-details', id]);
   }
 
   updateContact(id: number){
     this.router.navigate(['update-contact', id]);
   }
 
   deleteContact(id: number){
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
        this.contactService.deleteContact(id).subscribe( data => {
              console.log(data);
              this.getContact();
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
    //  this.contactService.deleteContact(id).subscribe( data => {
    //    console.log(data);
    //    this.getContact();
    //  })
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
  this.contactService.updateContact(this.EditForm.value).subscribe((result)=>{
    console.log(result);
    this.getContact();
  });
 }

onSubmit() {
   this.contactService.createContact(this.contactForm.value).subscribe((result)=>{
     console.log(result);
     this.getContact();
   });
}
fillContactData!:any;
openEdit(Editcontent: any,idContact:number) {
  this.contactService.getByRow(idContact).subscribe(data =>{
    this.fillContactData=data;
    console.log(data);
    
    this.EditForm.get('id')?.setValue(this.fillContactData.id);
    this.EditForm.get('nom')?.setValue(this.fillContactData.nom);
    this.EditForm.get('prenom')?.setValue(this.fillContactData.prenom);
    this.EditForm.get('telephone')?.setValue(this.fillContactData.telephone);
    this.EditForm.get('fonction')?.setValue(this.fillContactData.fonction);
    this.EditForm.get('client')?.setValue(this.fillContactData.client);
    this.EditForm.get('email')?.setValue(this.fillContactData.email);

  })
  
  this.modalService.open(Editcontent, {ariaLabelledBy: 'modal-basic-title'}).result.then((result) => {
    this.closeResult = `Closed with: ${result}`;
    
  }, (reason) => {
    this.closeResult = `Dismissed ${this.getDismissReason(reason)}`;
    

  });
}

}
