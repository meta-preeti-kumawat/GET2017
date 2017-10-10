import { Component, Input, OnInit } from '@angular/core';
import { ActivatedRoute, ParamMap } from '@angular/router';
import { Location } from '@angular/common';

import { ProductService } from '../../services/product.service';
import { Product } from './product.component';
import { ProductComponent } from './product.component';

import 'rxjs/add/operator/switchMap';

@Component({
 selector: 'product-detail',
 templateUrl: './product-detail.component.html',
 styleUrls: ['./product-detail.component.css']
}) 
export class ProductDetailComponent implements OnInit{
  @Input() product: Product;
  
  constructor(
    private productService: ProductService,
    private route: ActivatedRoute,
    private location: Location
  ) {}

  ngOnInit(): void {
    this.route.paramMap
      .switchMap((params: ParamMap) => this.productService.getProduct(+params.get('id')))
      .subscribe(product => this.product = product);
  }

  getProduct(id: number): Promise<Product> {
    return this.productService.getProducts()
               .then(products => products.find(product => product.id === id));
  }

  goBack(): void {
    this.location.back();
  }
}