import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { FormsModule } from '@angular/forms';
import { InputNumberModule } from 'primeng/inputnumber';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { BookService } from './services/book.service';
import { HttpClientModule } from '@angular/common/http';
import { ShoppingCartService } from './services/shoping-cart.service';
import { TableModule } from 'primeng/table';
import { HomePage } from './pages/home/home.page';
import { ShoppingCartPage } from './pages/shopping-cart/shopping-cart.page';


@NgModule({
  declarations: [
    AppComponent,
    HomePage,
    ShoppingCartPage
  ],
  imports: [
    BrowserModule,
    BrowserAnimationsModule,
    AppRoutingModule,
    InputNumberModule,
    FormsModule,
    TableModule,
    HttpClientModule
  ],
  providers: [BookService, ShoppingCartService],
  bootstrap: [AppComponent]
})
export class AppModule { }
