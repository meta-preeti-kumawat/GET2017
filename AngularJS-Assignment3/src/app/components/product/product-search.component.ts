import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';

import { Observable } from 'rxjs/Observable';
import { Subject } from 'rxjs/Subject';

// Observable class extensions
import 'rxjs/add/observable/of';

// Observable operators
import 'rxjs/add/operator/catch';
import 'rxjs/add/operator/debounceTime';
import 'rxjs/add/operator/distinctUntilChanged';

import { ProductSearchService } from '../../services/product-search.service';
import { Product } from './product.component';

@Component({
    selector: 'product-search',
    templateUrl: './product-search.component.html',
    styleUrls: [ './product-search.component.css' ],
    providers: [ProductSearchService]
})

export class ProductSearchComponent implements OnInit {
    products: Observable<Product[]>;
    private searchTerms = new Subject<string>();

    constructor(
    private productSearchService: ProductSearchService,
    private router: Router) {}

    // Push a search term into the observable stream.
    search(term: string): void {
        this.searchTerms.next(term);
    }

    ngOnInit(): void {
        this.products = this.searchTerms
            .debounceTime(300) 
            .distinctUntilChanged() 
            .switchMap(term => term 
            ? this.productSearchService.search(term)
            : Observable.of<Product[]>([]))
            .catch(error => {
                console.log(error);
                return Observable.of<Product[]>([]);
            });
    }

    gotoDetail(product: Product): void {
        this.removeSearch();
        let link = ['/detail', product.id];
        this.router.navigate(link);
    }

    removeSearch(): void {
        this.searchTerms.next(null);
    }
}
