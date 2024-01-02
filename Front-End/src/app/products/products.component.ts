import { Component, OnInit } from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {Router} from "@angular/router";

@Component({
  selector: 'app-products',
  templateUrl: './products.component.html',
  styleUrls: ['./products.component.css']
})
export class ProductsComponent implements OnInit {
  products : any;
  productId: any;
  constructor(private http:HttpClient , private router: Router ) { }

  ngOnInit(): void {
    this.http.get("http://localhost:9999/inventory-service/products?projection=FullProduct")
      .subscribe({
      next : (data)=>{
        this.products=data;
      },
      error : (err)=>{}
    });
  }


  newproduct(products: any) {
     this.router.navigateByUrl("/new-product");
                   }

  deleteProduct(productId: any) {
    this.http.delete("http://localhost:9999/inventory-service/products/" + productId)
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
