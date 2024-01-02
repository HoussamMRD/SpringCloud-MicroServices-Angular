import { Component, OnInit } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { ActivatedRoute, Router } from "@angular/router";

@Component({
  selector: 'app-new-customer',
  templateUrl: './new-customer.component.html',
  styleUrls: ['./new-customer.component.css']
})
export class NewCustomerComponent implements OnInit {
  newCustomer: any = {};

  constructor(private http: HttpClient, private router: Router, private route: ActivatedRoute) {}

  ngOnInit() {
    // Implement OnInit lifecycle hook if needed
  }

  addCustomer() {
    this.router.navigateByUrl("/customers");
    this.http.post('http://localhost:9999/customer-service/customers', this.newCustomer)
      .subscribe({
        next: (data) => {
          console.log('customer ajouté avec succès :', data);
          this.newCustomer = {};
        },
        error: (err) => {
          console.error('Erreur lors de l\'ajout du customer :', err);
        }
      });
  }

   clearForm() {
      this.newCustomer = {};
    }
}
