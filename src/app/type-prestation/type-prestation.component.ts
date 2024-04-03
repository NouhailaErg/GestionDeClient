import { HttpClient } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, NgForm } from '@angular/forms';
import { Router } from '@angular/router';
import { ModalDismissReasons, NgbModal } from '@ng-bootstrap/ng-bootstrap';
import { TypePrestation } from '../dto/typePrestation';
import { TypePrestationService } from './typePrestation.service';
import Swal from 'sweetalert2';

@Component({
  selector: 'app-type-prestation',
  templateUrl: './type-prestation.component.html',
  styleUrls: ['./type-prestation.component.css']
})
export class TypePrestationComponent implements OnInit {

  closeResult !: string;
  typePrestation !: TypePrestation[];
  reactiveForm !: FormGroup;
  saveResponse : any;

  constructor(private httpClient:HttpClient,private typePrestationService: TypePrestationService,
    private router: Router,private modalService: NgbModal,
    private fb:FormBuilder,) { }
    totalLenght : any;
    page : number = 1;
    filterTerm!: string;

  ngOnInit(): void {
    this.getTypePrestation();
  }
  typePrestationForm=this.fb.group({
    id:[],
   libelle:[]
 })
 EditForm=this.fb.group({
  id:[],
 libelle:[]
})
  private getTypePrestation() {
    this.typePrestationService.getTypePrestationList().subscribe(data =>{
       this.typePrestation = data;
       this.totalLenght = data.length;
    })
   }
   typePrestationDetails(id: number){
     this.router.navigate(['typePrestation-details', id]);
   }
 
   updateTypePrestation(id: number){
    this.typePrestationService.getByRow(id).subscribe(data =>{
      console.log(data);
      this.getTypePrestation();
    })
   }
 
   deleteTypePrestation(id: number){
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
        this.typePrestationService.deleteTypePrestation(id).subscribe( data => {
             console.log(data);
              this.getTypePrestation();
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
  this.typePrestationService.creatTypePrestation(this.typePrestationForm.value).subscribe((result)=>{
    console.log(result);
    this.getTypePrestation();
  });
}

fillTypePData!:any;
openEdit(Editcontent: any,idTypeP:number) {
  this.typePrestationService.getByRow(idTypeP).subscribe(data =>{
    this.fillTypePData=data;
    console.log(data);
    
    this.EditForm.get('id')?.setValue(this.fillTypePData.id);
    this.EditForm.get('libelle')?.setValue(this.fillTypePData.libelle);
    
  })
  
  this.modalService.open(Editcontent, {ariaLabelledBy: 'modal-basic-title'}).result.then((result) => {
    this.closeResult = `Closed with: ${result}`;
    
  }, (reason) => {
    this.closeResult = `Dismissed ${this.getDismissReason(reason)}`;
    

  });
}
onSave(){
  this.typePrestationService.updateTypePrestation(this.EditForm.value).subscribe((result)=>{
    console.log(result);
    this.getTypePrestation();
  });
 }

}
