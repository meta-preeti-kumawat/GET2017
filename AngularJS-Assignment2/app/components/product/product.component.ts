import { Component, OnInit } from '@angular/core';

import { ProductService } from '../../services/product.service';

@Component({
  selector: 'my-product',
  templateUrl: './product.component.html',
  styleUrls: ['./product.component.css'],
  providers: [ ProductService ]  
})

export class ProductComponent  implements OnInit {
    title = 'Products';
    products: Product[] ;
    selectedProduct: Product;
    constructor(private productService : ProductService){ }
    
    getProducts(): void {
        this.productService.getProducts().then(products => this.products = products);
    }
    
    ngOnInit(): void {
        this.getProducts();
    }

    onSelect(product: Product): void {
        this.selectedProduct = product;
    }
}

export class Product {
    id : number;
    name : string;
    price : number;
}
