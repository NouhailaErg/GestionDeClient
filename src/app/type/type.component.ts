import { HttpClient } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { TypeService } from './type.service';
import {Type} from '../dto/Type';
import {ModalDismissReasons, NgbModal} from '@ng-bootstrap/ng-bootstrap';
import { FormBuilder, FormGroup, NgForm } from '@angular/forms';
import Swal from 'sweetalert2';



@Component({
  selector: 'app-type',
  templateUrl: './type.component.html',
  styleUrls: ['./type.component.css']
})
export class TypeComponent implements OnInit {

  closeResult !: string;
  type !: Type[];
  reactiveForm !: FormGroup;
  saveResponse : any;
  popoverTitle = 'Popover title';
  popoverMessage = 'Popover description';
  confirmClicked = false;
  cancelClicked = false;
  constructor(private httpClient:HttpClient,private typeService: TypeService,
    private router: Router,private modalService: NgbModal,
    private fb:FormBuilder,
    ) { }
    totalLenght : any;
    page : number = 1;
    filterTerm!: string;

  ngOnInit(): void {
    this.getType();
  }
  typeForm=this.fb.group({
    id:[],
   libelle:[]
 })
 EditForm=this.fb.group({
  id:[],
 libelle:[]
})
 private getType() {
   this.typeService.getTypeList().subscribe(data =>{
      this.type = data;
      this.totalLenght = data.length;
   })
  }

  updateType(id: number){
    this.typeService.getByRow(id).subscribe(data =>{
      console.log(data);
      this.getType();
    })
  }

  

  deleteType(id: number){

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
        this.typeService.deleteType(id).subscribe( data => {
             console.log(data);
             this.getType();
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
onSubmit() {
  this.typeService.createType(this.typeForm.value).subscribe((result)=>{
    console.log(result);
    this.getType();
  });
}
fillTypeData!:any;
openEdit(Editcontent: any,idType:number) {
  this.typeService.getByRow(idType).subscribe(data =>{
    this.fillTypeData=data;
    console.log(data);
    
    this.EditForm.get('id')?.setValue(this.fillTypeData.id);
    this.EditForm.get('libelle')?.setValue(this.fillTypeData.libelle);
    
  })
  
  this.modalService.open(Editcontent, {ariaLabelledBy: 'modal-basic-title'}).result.then((result) => {
    this.closeResult = `Closed with: ${result}`;
    
  }, (reason) => {
    this.closeResult = `Dismissed ${this.getDismissReason(reason)}`;
    

  });
}
onSave(){
  this.typeService.updateType(this.EditForm.value).subscribe((result)=>{
    console.log(result);
    this.getType();
  });
 }
}
