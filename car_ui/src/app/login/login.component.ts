import { Component, OnInit } from '@angular/core';
import {RestCallService} from '../rest-call.service';
import {Router} from '@angular/router';
import {DataCarrierService} from '../data-carrier.service';
import {User} from '../user';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {

  constructor(private restSrv:RestCallService,private routerVar:Router, private dataSrv: DataCarrierService) { }

  ngOnInit(): void {
    
  }
  userObj:User = new User();

  loginErrMsg:string = "";

  validateLogin(){
    this.restSrv.validateLogin(this.userObj).subscribe(data =>{
      var user = data.body;
      console.log(user);
        if(user == false){
              this.userObj = new User();
              this.loginErrMsg = "Invalid Credentials";
        }else{                          
              this.dataSrv.setLoggedInUser(data.body);
              this.routerVar.navigate(['/base']);
        }

    })
  }

}
