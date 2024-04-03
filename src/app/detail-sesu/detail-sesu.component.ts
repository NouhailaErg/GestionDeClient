import { Component, Input, OnInit } from '@angular/core';
import { Pov } from '../dto/pov';
import { Sceance } from '../dto/sceance';
import { Suivi } from '../dto/suivi';
import { PovService } from '../pov/pov.service';
import { DetailSesuService } from './detailsesu.service';

@Component({
  selector: 'app-detail-sesu',
  templateUrl: './detail-sesu.component.html',
  styleUrls: ['./detail-sesu.component.css']
})
export class DetailSesuComponent implements OnInit {

  sceance !: Sceance[];
  suivi !: Suivi[];
  @Input() user!:Pov
  constructor(private detailsesuService : DetailSesuService,
    ) { }

  ngOnInit(): void {
    console.log(this.user);
    this.getSceanceinfo(this.user);
    this.getSuiviinfo(this.user);
  }
  getSceanceinfo(pov : Pov){
    this.detailsesuService.getListSceance(pov).subscribe(data =>{
      this.sceance = data;
      console.log(data);
    })
   }
   getSuiviinfo(pov : Pov){
    this.detailsesuService.getListSuivi(pov).subscribe(data =>{
      this.suivi = data;
      console.log(data);
    })
   }
}
