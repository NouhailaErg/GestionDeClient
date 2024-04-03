import { HttpClient } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup } from '@angular/forms';
import { Router } from '@angular/router';
import { ModalDismissReasons, NgbModal } from '@ng-bootstrap/ng-bootstrap';
import { Pov } from '../dto/pov';
import { Suivi } from '../dto/suivi';
import { TypePrestation } from '../dto/typePrestation';
import { PovService } from '../pov/pov.service';
import { TypePrestationService } from '../type-prestation/typePrestation.service';
import { SuiviService } from './suivi.service';
import Swal from 'sweetalert2';

@Component({
  selector: 'app-suivi',
  templateUrl: './suivi.component.html',
  styleUrls: ['./suivi.component.css']
})
export class SuiviComponent implements OnInit {


  suivi !:Suivi[];
  typePrestation !: TypePrestation[];
  pov !: Pov[];
  closeResult !: string;
  saveResponse : any;
  reactiveForm !: FormGroup;

  constructor(private httpCleint:HttpClient,private suiviService: SuiviService,
    private router: Router,
    private modalService: NgbModal,
    private povService: PovService,
    private typePrestationService: TypePrestationService,
    private fb:FormBuilder
    ) { }
    totalLenght : any;
    page : number = 1;
    filterTerm!: string;

  ngOnInit(): void {
    this.getSuivi();
    this.getPov();
    this.getTypePrestation();
  }
  
  suiviForm=this.fb.group({
    id:[],
    offre_com:[],
    montant:[],
    typePrestation:[],
    compte_rendu:[],
    pov:[]
 })
 EditForm=this.fb.group({
  id:[],
  offre_com:[],
  montant:[],
  typePrestation:[],
  compte_rendu:[],
  pov:[]
})
  private getSuivi() {
    this.suiviService.getSuiviList().subscribe(data =>{
       this.suivi = data;
       this.totalLenght = data.length;
    })
   }
   private getTypePrestation(){
    this.typePrestationService.getTypePrestationList().subscribe(data =>{
      this.typePrestation = data;
    })
  }
  private getPov(){
    this.povService.getPovList().subscribe(data =>{
      this.pov = data;
    })
  }
   suiviDetails(id: number){
     this.router.navigate(['suivi-details', id]);
   }
 
   updateSuivi(id: number){
    this.suiviService.getByRow(id).subscribe(data =>{
      console.log(data);
      this.getSuivi();
    })
   }
 
   deleteSuivi(id: number){
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
        this.suiviService.deleteSuivi(id).subscribe( data => {
              console.log(data);
             this.getSuivi();
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
  this.suiviService.createSuivi(this.suiviForm.value).subscribe((result)=>{
    console.log(result);
    this.getSuivi();
  });
}
fillSuiviData!:any;
openEdit(Editcontent: any,idSuivi:number) {
  this.suiviService.getByRow(idSuivi).subscribe(data =>{
    this.fillSuiviData=data;
    console.log(data);
    
    this.EditForm.get('id')?.setValue(this.fillSuiviData.id);
    this.EditForm.get('offre_com')?.setValue(this.fillSuiviData.offre_com);
    this.EditForm.get('montant')?.setValue(this.fillSuiviData.montant);
    this.EditForm.get('typePrestation')?.setValue(this.fillSuiviData.typePrestation);
    this.EditForm.get('compte_rendu')?.setValue(this.fillSuiviData.compte_rendu);
    this.EditForm.get('pov')?.setValue(this.fillSuiviData.pov);
  })
  
  this.modalService.open(Editcontent, {ariaLabelledBy: 'modal-basic-title'}).result.then((result) => {
    this.closeResult = `Closed with: ${result}`;
    
  }, (reason) => {
    this.closeResult = `Dismissed ${this.getDismissReason(reason)}`;
    

  });
}
onSave(){
  this.suiviService.updateSuivi(this.EditForm.value).subscribe((result)=>{
    console.log(result);
    this.getSuivi();
  });
 }
}
