import { Component, OnInit } from '@angular/core';
import {RestCallService} from '../rest-call.service';
import {Dashboard} from '../dashboard';
@Component({
  selector: 'app-dashboard',
  templateUrl: './dashboard.component.html',
  styleUrls: ['./dashboard.component.css']
})
export class DashboardComponent implements OnInit {

  constructor(private restSrv:RestCallService) { }

  ngOnInit(): void {
    this.restSrv.displayDashboardApi().subscribe(data =>{
      this.dashboardData = data.body;
    })
  }
  
  dashboardData:Dashboard[] = [];
}
