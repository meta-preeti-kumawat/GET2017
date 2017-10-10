import { Injectable } from '@angular/core';
import {Product} from '../components/product/product.component';
import {PRODUCTS} from '../mock-data/mock-product';

@Injectable()
export class ProductService {
    getProducts() : Promise<Product[]> {
        return Promise.resolve(PRODUCTS);
      }
}