import { NgModule }      from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { FormsModule } from '@angular/forms';
import { NgbModule } from '@ng-bootstrap/ng-bootstrap';

import { HttpModule }    from '@angular/http';

// Imports for loading & configuring the in-memory web api
import { InMemoryWebApiModule } from 'angular-in-memory-web-api';
import { InMemoryDataService }  from './services/in-memory-data.service';

import { AppComponent }  from './app.component';
import { DashboardComponent }  from './components/dashboard/dashboard.component';
import { ContactComponent }  from './components/contact/contact.component';
import { ProductComponent }  from './components/product/product.component';
import { ProductDetailComponent }  from './components/product/product-detail.component';
import { ProductSearchComponent }  from './components/product/product-search.component';
import { ProductService } from './services/product.service';
import { ProductSearchService } from './services/product-search.service';
import { ProductAddOperationComponent } from './components/product/product-add-operation.component';
import { AppRoutingModule }   from './app-routing.module';
import { ProductEditOperationComponent } from './components/product/product-edit-operation.component';


@NgModule({
  imports:      
  [ BrowserModule, 
    FormsModule, 
    HttpModule,
    InMemoryWebApiModule.forRoot(InMemoryDataService),
    NgbModule.forRoot(),
    AppRoutingModule
  ],
  declarations: 
  [ AppComponent,  
    DashboardComponent, 
    ProductComponent, 
    ContactComponent,
    ProductSearchComponent, 
    ProductDetailComponent, 
    ProductAddOperationComponent,
    ProductEditOperationComponent 
  ],
  bootstrap:    [ AppComponent ],
  providers: [ ProductService, ProductSearchService ] 
})
export class AppModule { }
