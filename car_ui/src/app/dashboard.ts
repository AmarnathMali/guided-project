export class Dashboard {
	checkInId:number;
	serviceDate:Date;
	vehicleNumber:string;
	userName:string;
	mobile:string;
	status:string;
	checkInDate:string;
	checkOutDate:string;

	constructor(checkInId:number=0, serviceDate:Date=new Date(), vehicleNumber:string="",
	  userName:string="", mobile:string="", status:string="",
	  checkInDate:string="", checkOutDate:string="") {
	      this.checkInId = checkInId;
	      this.serviceDate = serviceDate;
	      this.vehicleNumber = vehicleNumber;
	      this.userName = userName;
	      this.mobile = mobile;
	      this.status = status;
	      this.checkInDate = checkInDate;
	      this.checkOutDate = checkOutDate;

	   }   
}
