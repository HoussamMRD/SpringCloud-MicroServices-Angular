import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import {ProductsComponent} from "./products/products.component";
import {CustomersComponent} from "./customers/customers.component";
import {OrdersComponent} from "./orders/orders.component";
import {OrderDetailsComponent} from "./order-details/order-details.component";
import {NewProductComponent} from "./new-product/new-product.component";
import {NewCustomerComponent} from "./new-customer/new-customer.component";
import {LoginComponent} from "./login/login.component";







const routes: Routes = [

{ path: 'login', component: LoginComponent },










  {
    path : "products", component : ProductsComponent
  },



   {
      path : "new-product", component  : NewProductComponent
    },




  {
      path : "customers", component : CustomersComponent
  },

  {
        path : "new-customer", component  : NewCustomerComponent
      },


  {
        path : "orders", component : OrdersComponent
    },

    {
        path : "orders/:customerId", component : OrdersComponent
      },

      {
          path : "order-details/:orderId", component : OrderDetailsComponent
        },






];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
