import { Injectable } from '@angular/core';
import {HttpClient} from '@angular/common/http';
import { HttpHeaders } from '@angular/common/http';
import { Observable } from 'rxjs';
import {User} from './user';
import {Slot} from './slot';
import {CarService} from './car-service';

@Injectable({
  providedIn: 'root'
})
export class RestCallService {

  constructor(private httpVar:HttpClient) { }

  getHeadersInfo():any{
    return {
           headers: new HttpHeaders({
           'Content-Type':  'application/json',
           'Accept':'*/*' 
         })
      };
  }

  restUrl:string = "http://localhost:9999/";


  validateLogin(userObj:User):Observable<any>{
    var validateLoginRestApi = this.restUrl+"user/login";
    return this.httpVar.post(validateLoginRestApi,userObj,this.getHeadersInfo());
  }

  checkSlotApi(date:string):Observable<any>{
    var checkSlotRestApi = this.restUrl+"carApp/checkslot";
    return this.httpVar.post(checkSlotRestApi,date,this.getHeadersInfo());
  }

  bookSlotApi(slotObj:Slot):Observable<any>{
    var bookSlotRestApi = this.restUrl+"carApp/book";
    return this.httpVar.post(bookSlotRestApi,slotObj,this.getHeadersInfo());
  }
  checkInCarApi(carServiceObj:CarService):Observable<any>{
    var checkInCarRestApi = this.restUrl+"carApp/check";
    return this.httpVar.post(checkInCarRestApi,carServiceObj,this.getHeadersInfo());
  }
  displayDashboardApi():Observable<any>{
    var displayDashboardRestApi = this.restUrl+"carApp/dashboard";
    return this.httpVar.get(displayDashboardRestApi);
  }
  generateBillApi(checkInId:number):Observable<any>{
    var generateBillRestApi = this.restUrl+"bill/generate?checkInId="+checkInId;
    return this.httpVar.get(generateBillRestApi);
  }
  payBillApi(checkInId:number):Observable<any>{
    var payBillRestApi = this.restUrl+"bill/pay/"+checkInId;
    return this.httpVar.get(payBillRestApi);
  }
}
