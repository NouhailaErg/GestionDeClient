import { Component, Input, OnInit } from '@angular/core';
import { FormBuilder, FormGroup } from '@angular/forms';
import { Router } from '@angular/router';
import { ModalDismissReasons, NgbActiveModal, NgbModal } from '@ng-bootstrap/ng-bootstrap';
import { ClientService } from '../client/client.service';
import { ContactService } from '../contact/contact.service';
import { Client } from '../dto/client';
import { Contact } from '../dto/contact';
import { DetailClientService } from './service/detail-client.service';

@Component({
  selector: 'app-detail-client',
  templateUrl: './detail-client.component.html',
  styleUrls: ['./detail-client.component.css']
})
export class DetailClientComponent implements OnInit {

  closeResult !: string;
  reactiveForm !: FormGroup;
  client !: Client[];
  contact !: Contact[];
  @Input() user!:Client
  // @Input() us !: Contact
  constructor(private detailClientService : DetailClientService,private fb:FormBuilder,private router: Router,
    private modalService: NgbModal,
    private contactService : ContactService,
    private clientService : ClientService,
    private activeModale: NgbActiveModal,
    ) { }

  ngOnInit(): void {
    console.log(this.user);
    this.getContact(this.user);
    // console.log(this.us);
    
  }
  private getClient() {
    this.clientService.getClientList().subscribe(data =>{
       this.client = data;
    })
   }
  getContact(client : Client){
    this.detailClientService.getClientConta(client).subscribe(data =>{
      this.contact = data;
      console.log(data);
      
    })
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

onSubmit() {

    this.contactForm.get('client')?.setValue(this.user);

  this.detailClientService.createContact(this.contactForm.value).subscribe(result=>{
    console.log(result);
    this.getContact(this.user);
    this.contactForm.reset();
    this.activeModale.close();
  });
}
}
