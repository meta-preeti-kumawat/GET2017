import { Component, Input, OnInit } from '@angular/core';
import { ActivatedRoute, ParamMap } from '@angular/router';
import { Location } from '@angular/common';

import { ProductService } from '../../services/product.service';
import { Product } from './product.component';
import { ProductComponent } from './product.component';

import 'rxjs/add/operator/switchMap';

@Component({
 selector: 'product-detail',
 templateUrl: './product-edit-operation.component.html',
 styleUrls: ['./product-edit-operation.component.css']
}) 
export class ProductEditOperationComponent implements OnInit{
  product: Product;
  products: Product[] ;
  
  constructor(
    private productService: ProductService,
    private route: ActivatedRoute,
    private location: Location
  ) {}
  
  getProducts(): void {
    this.productService.getProducts().then(products => this.products = products);
  }
  ngOnInit(): void {
    this.route.paramMap
    .switchMap((params: ParamMap) => this.productService.getProduct(+params.get('id')))
    .subscribe(product => this.product = product);
  }

  save(): void {
    this.productService.update(this.product)
      .then( () =>
        this.goBack()
      );
  }

  goBack(): void {
    this.location.back();
  }
}