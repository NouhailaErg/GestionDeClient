import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
//import { Appliance } from '../appliance';
import { Appliance } from '../dto/appliance';
import { ApplianceService } from '../appliance/appliance.service';

//appliance : Appliance = new Appliance();
@Component({
  selector: 'app-new-appliance',
  templateUrl: './new-appliance.component.html',
  styleUrls: ['./new-appliance.component.css']
})
export class NewApplianceComponent implements OnInit {

  constructor(private applianceService: ApplianceService,
    private router: Router) { }

  ngOnInit(): void {
  }

  saveAppliance(){
    // this.applianceService.createAppliance(this.appliance).subscribe( data =>{
    //   console.log(data);
    //   this.goToApplianceList();
    // },
    // error => console.log(error));
  }

  goToApplianceList(){
    this.router.navigate(['/appliance']);
  }
  
  onSubmit(){
    // console.log(this.appliance);
    // this.saveAppliance();
  }
}

