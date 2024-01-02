import { Component, OnInit } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { ActivatedRoute, Router } from "@angular/router";

@Component({
  selector: 'app-new-product',
  templateUrl: './new-product.component.html',
  styleUrls: ['./new-product.component.css']
})
export class NewProductComponent implements OnInit {
  newProduct: any = {};

  constructor(private http: HttpClient, private router: Router, private route: ActivatedRoute) {}

  ngOnInit() {
    // Implement OnInit lifecycle hook if needed
  }

  addProduct() {
    this.router.navigateByUrl("/products");
    this.http.post('http://localhost:9999/inventory-service/products', this.newProduct)
      .subscribe({
        next: (data) => {
          console.log('Produit ajouté avec succès :', data);
          this.newProduct = {};
        },
        error: (err) => {
          console.error('Erreur lors de l\'ajout du produit :', err);
        }
      });
  }

   clearForm() {
      this.newProduct = {};
    }
}
