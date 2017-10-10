import { NgModule }      from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { FormsModule } from '@angular/forms';
import { ProductComponent }  from './components/product/product.component';
import { ProductDetailComponent }  from './components/product/product-detail.component';
import { ProductService } from './services/product.service';

@NgModule({
  imports:      [ BrowserModule, FormsModule ],
  declarations: [ ProductComponent, ProductDetailComponent ],
  bootstrap:    [ ProductComponent ],
  providers: [ ProductService ] 
})
export class AppModule { }
