import { Component, OnInit } from '@angular/core';

import Swal from 'sweetalert2'

import { BookSpec, Book } from 'src/app/model/book.model';
import { BookService } from 'src/app/services/book.service';
import { ShoppingCartService } from 'src/app/services/shoping-cart.service';
import { ShoppingCartBook } from 'src/app/model/shopping-cart.model';


@Component({
   templateUrl: './home.page.html',
   styleUrls: ['./home.page.css']
})
export class HomePage implements OnInit {

   books: BookSpec[];

   constructor(private _bookService: BookService, public _shoppingCartService: ShoppingCartService) { }

   addToCart(bookSpec: BookSpec): void {

      let userBook: ShoppingCartBook = {
         userId: 1,
         book: {
            bookId: bookSpec.id,
            quantity: bookSpec.quantityCart
         }
      };

      this._shoppingCartService.addToCart(userBook).subscribe(response => {
         if (!response) {
            Swal.fire({
               icon: 'error',
               title: ':( Upps...',
               text: 'Lo sentimos mucho, no poseemos la cantidad de libros que estas solicitando!',
               footer: `
             <div class="container">
               <div class="row">
                 <div class = "col-md-12">
                   <label style ="font-weight: bolder;">Libro:</label> ${bookSpec.title}
                 </div>
                 <div class = "col-md-12">
                   <label style ="font-weight: bolder;">Cantidad disponible</label>: ${bookSpec.quantity} 
                 </div>
               </div>
             </div>
             `
            });
         } else {
            this._shoppingCartService.init(1);
         }
      });

   }

   ngOnInit(): void {

      this._shoppingCartService.init(1);
      this._bookService.books().subscribe((data: BookSpec[]) => {
         this.books = data;
      });

   }
}