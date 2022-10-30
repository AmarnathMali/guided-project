import { Component, OnInit } from '@angular/core';
import {RestCallService} from '../rest-call.service';

@Component({
  selector: 'app-bill',
  templateUrl: './bill.component.html',
  styleUrls: ['./bill.component.css']
})
export class BillComponent implements OnInit {

  constructor(private restSrv:RestCallService) { }

  ngOnInit(): void {
  }

  checkInId:number = 0;
  billAmount:number = 0;
  generateRespMsg:string = "";
  payBillRespMsg:string = "";

  generateBill(){
    this.restSrv.generateBillApi(this.checkInId).subscribe(data =>{
      if(data.body){
        this.billAmount = data.body;
        this.generateRespMsg = "Bill generated for checkin Id :"+this.checkInId +" is = "+this.billAmount;
      }else{
          this.generateRespMsg = "generate bill failed for checkInId "+this.checkInId;
      }

    })
  }

  payBill(){
    this.restSrv.payBillApi(this.checkInId).subscribe(data =>{
      if(data.body){
        this.payBillRespMsg = "Bill payed for checkInId "+ this.checkInId +"and your service request closed";
      }
    });
  }
}
