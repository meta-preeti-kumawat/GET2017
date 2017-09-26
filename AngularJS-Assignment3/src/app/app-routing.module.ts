import { NgModule }      from '@angular/core';
import { RouterModule, Routes }   from '@angular/router';

import { DashboardComponent }  from './components/dashboard/dashboard.component';
import { ContactComponent }  from './components/contact/contact.component';
import { ProductComponent }  from './components/product/product.component';
import { ProductDetailComponent }  from './components/product/product-detail.component';
import { ProductAddOperationComponent } from './components/product/product-add-operation.component';
import { ProductEditOperationComponent } from './components/product/product-edit-operation.component';

const routes: Routes = [
    { path: 'products', component: ProductComponent },
      { path: 'dashboard', component: DashboardComponent },
      { path: 'contact', component: ContactComponent },
      { path: 'detail/:id', component: ProductDetailComponent },
      { path: 'edit/:id', component: ProductEditOperationComponent },
      { path: 'addProduct', component: ProductAddOperationComponent },
      { path: '**', redirectTo: '/dashboard', pathMatch: 'full' }
  ];
   
  @NgModule({
    imports: [ RouterModule.forRoot(routes) ],
    exports: [ RouterModule ]
  })
  export class AppRoutingModule {}