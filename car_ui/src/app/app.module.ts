import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { HttpClientModule } from '@angular/common/http';
import { FormsModule } from '@angular/forms';
import { RouterModule, Routes } from "@angular/router";

import { AppComponent } from './app.component';
import {RestCallService} from './rest-call.service';
import {DataCarrierService} from './data-carrier.service';
import { LoginComponent } from './login/login.component';
import { BaseComponent } from './base/base.component';
import { HomeComponent } from './home/home.component';
import { SlotComponent } from './slot/slot.component';
import { CheckInComponent } from './check-in/check-in.component';
import { DashboardComponent } from './dashboard/dashboard.component';
import { BillComponent } from './bill/bill.component';

const routes:Routes =[
   {
       path:'', pathMatch: 'full', redirectTo: 'login'
   },
   {
       path:'*', pathMatch: 'full', redirectTo: 'login'
   },
   {
       path:'login', component: LoginComponent
   },
    {
       path:'base', 
       component:BaseComponent,
     children: [        
        { path: 'home', component: HomeComponent },
        { path: 'bookslot', component: SlotComponent},
        { path: 'checkIn', component: CheckInComponent},
        { path: 'dashboard', component: DashboardComponent},
        { path: 'bill', component: BillComponent}
    ]
       },
   { path: 'logout', component: LoginComponent}
];
@NgModule({
  declarations: [
    AppComponent,
    LoginComponent,
    BaseComponent,
    HomeComponent,
    SlotComponent,
    CheckInComponent,
    DashboardComponent,
    BillComponent
  ],
  imports: [
     BrowserModule, FormsModule, HttpClientModule, RouterModule.forRoot(routes)
  ],
  providers: [RestCallService,DataCarrierService],
  bootstrap: [AppComponent]
})
export class AppModule { }
