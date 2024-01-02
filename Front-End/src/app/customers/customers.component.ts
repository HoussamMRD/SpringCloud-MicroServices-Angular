import { Component, OnInit } from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {Router} from "@angular/router";

@Component({
  selector: 'app-customers',
  templateUrl: './customers.component.html',
  styleUrls: ['./customers.component.css']
})
export class CustomersComponent implements OnInit {
customers:any;
customerId:any;

  constructor(private http:HttpClient , private router: Router ) { }

  ngOnInit(): void {
 this.http.get("http://localhost:9999/customer-service/customers?projection=FullCustomer")
       .subscribe({
       next : (data)=>{
         this.customers=data;
       },
       error : (err)=>{}
     });
   }
     getOrders(c: any) {
       this.router.navigateByUrl("/orders/"+c.id);
     }

     newcustomer(customers:any) {
       this.router.navigateByUrl("/new-customer");
     }

     deleteCustomer(customerId: any) {
         this.http.delete("http://localhost:9999/customer-service/customers/" + customerId)
           .subscribe({
             next: (data) => {
               this.ngOnInit();
             },
             error: (err) => {
               // Handle error if needed
             }
           });
       }











 }
