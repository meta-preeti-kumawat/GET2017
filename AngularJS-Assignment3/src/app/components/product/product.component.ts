import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';

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
    constructor(private productService : ProductService,
    private router: Router){ }
    
    getProducts(): void {
        this.productService.getProducts().then(products => this.products = products);
    }
    
    ngOnInit(): void {
        this.getProducts();
    }

    onSelect(product: Product): void {
        this.selectedProduct = product;
    }

    gotoDetail(): void {
        this.router.navigate(['/detail', this.selectedProduct.id]);
    }

    remove(product: Product): void{
        this.productService.delete(product.id)
        .then(() => {
            this.products = this.products.filter(element => element !== product);
            if (this.selectedProduct === product) { this.selectedProduct = null; }
            });
    }
}

export class Product {
    id : number;
    name : string;
    price : number;
}
