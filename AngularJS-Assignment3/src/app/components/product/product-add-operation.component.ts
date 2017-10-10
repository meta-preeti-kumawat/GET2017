import { Component, Input, OnInit } from '@angular/core';
import { ActivatedRoute, ParamMap } from '@angular/router';
import { Location } from '@angular/common';

import { ProductService } from '../../services/product.service';
import { Product } from './product.component';
import { ProductComponent } from './product.component';

import 'rxjs/add/operator/switchMap';

@Component({
 selector: 'new-product',
 templateUrl: './product-add-operation.component.html',
 styleUrls: ['./product-add-operation.component.css']
 
}) 
export class ProductAddOperationComponent implements OnInit{
  @Input() product: Product;
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
    this.getProducts();
  }

  add(name: string, price: number): void {
    name = name.trim();
    if (!name || !price) { return; }
    this.productService.create(name, price)
      .then(product => {
        this.products.push(product);
      }).then(() => {this.goBack();});
  }

  goBack(): void {
    this.location.back();
  }
}