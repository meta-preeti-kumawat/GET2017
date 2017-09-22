import { Component, Input } from '@angular/core';

import { Product } from './product.component';
@Component({
 selector: 'product-detail',
 template: `
   <div class="product-detail" *ngIf="product">
     <h2>{{product.name}} details!</h2>
     <div class="row"><label class="col-sm-offset-4 col-sm-2 text-right">Id: </label><div class="col-sm-2 text-left">{{product.id}}</div></div>
     <div class="row"><label class="col-sm-offset-4 col-sm-2 text-right">Name: </label><div class="col-sm-2 text-left">{{product.name}}</div></div>
     <div class="row"><label class="col-sm-offset-4 col-sm-2 text-right">Price: </label><div class="col-sm-2 text-left">{{product.price}}</div></div>
   </div>
 `,
 styles: [`
    .product-detail{
        margin-top: 5%;
    }`]
}) 
export class ProductDetailComponent {
 @Input() product: Product;
}