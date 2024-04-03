import { HttpClient } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup } from '@angular/forms';
import { Router } from '@angular/router';
import { ModalDismissReasons, NgbModal } from '@ng-bootstrap/ng-bootstrap';
import { Pov } from '../dto/pov';
import { Sceance } from '../dto/sceance';
import { PovService } from '../pov/pov.service';
import { SceanceService } from './sceance.service';
import Swal from 'sweetalert2';

@Component({
  selector: 'app-sceance',
  templateUrl: './sceance.component.html',
  styleUrls: ['./sceance.component.css']
})
export class SceanceComponent implements OnInit {


  sceance !: Sceance[];
  reactiveForm !: FormGroup;
  closeResult !: string;
  saveResponse : any;
  pov !: Pov[];

  constructor(private httpCleint:HttpClient,private sceanceService: SceanceService,
    private router: Router,
    private modalService: NgbModal,
    private fb:FormBuilder,
    private povService: PovService) { }
    totalLenght : any;
    page : number = 1;
    filterTerm!: string;

  ngOnInit(): void {
    this.getSceance();
    this.getPov();
  }
  sceanceForm=this.fb.group({
    id:[],
    date_sceance:[],
    resumer:[],
    participant:[],
    pov:[],
 })
 EditForm= this.fb.group({
  id:[],
    date_sceance:[],
    resumer:[],
    participant:[],
    pov:[],
});
  private getSceance() {
    this.sceanceService.getSceanceList().subscribe(data =>{
       this.sceance = data;2
       this.totalLenght = data.length;
    })
   }
   private getPov() {
    this.povService.getPovList().subscribe(data =>{
       this.pov = data;
    })
   }
   sceanceDetails(id: number){
     this.router.navigate(['sceance-details', id]);
   }
 
   updateSceance(id: number){
     this.router.navigate(['update-sceance', id]);
   }
 
   deleteSceance(id: number){
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
        this.sceanceService.deleteSceance(id).subscribe( data => {
              console.log(data);
              this.getSceance();
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
    //  this.sceanceService.deleteSceance(id).subscribe( data => {
    //    console.log(data);
    //    this.getSceance();
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
  this.sceanceService.updateSceance(this.EditForm.value).subscribe((result)=>{
    console.log(result);
    this.getSceance();
  });
 }
onSubmit() {
   this.sceanceService.createSceance(this.sceanceForm.value).subscribe((result)=>{
     console.log(result);
     this.getSceance();
   });
}
fillSceanecData!:any;
openEdit(Editcontent: any,idSceance:number) {
  this.sceanceService.getByRow(idSceance).subscribe(data =>{
    this.fillSceanecData=data;
    console.log(data);
    
    this.EditForm.get('id')?.setValue(this.fillSceanecData.id);
    this.EditForm.get('date_sceance')?.setValue(this.fillSceanecData.date_sceance);
    this.EditForm.get('resumer')?.setValue(this.fillSceanecData.resumer);
    this.EditForm.get('participant')?.setValue(this.fillSceanecData.participant);
    this.EditForm.get('pov')?.setValue(this.fillSceanecData.pov);
  })
  
  this.modalService.open(Editcontent, {ariaLabelledBy: 'modal-basic-title'}).result.then((result) => {
    this.closeResult = `Closed with: ${result}`;
    
  }, (reason) => {
    this.closeResult = `Dismissed ${this.getDismissReason(reason)}`;
    

  });
}


}
