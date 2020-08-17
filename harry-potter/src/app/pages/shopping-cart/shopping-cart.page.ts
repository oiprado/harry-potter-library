import { Component, OnInit } from '@angular/core';

import { ShoppingCartService } from 'src/app/services/shoping-cart.service';
import { ShoppingCartBook } from 'src/app/model/shopping-cart.model';

import Swal from 'sweetalert2';
import { AwaitCommitShoppingCart } from 'src/app/model/await-shopping-cart.model';

@Component({
   templateUrl: './shopping-cart.page.html',
   styleUrls: ['./shopping-cart.page.css']
})
export class ShoppingCartPage implements OnInit {

   constructor(public _shoppingCartService: ShoppingCartService) { }

   ngOnInit(): void {
      this.init();
   }

   private init() {
      this._shoppingCartService.init(1);
   }

   removeItem(book: AwaitCommitShoppingCart): void {
      let userBook: ShoppingCartBook = {
         userId: book.userId,
         book: {
            bookId: book.book.id,
            quantity: book.quantity
         }
      };


      const swalWithBootstrapButtons = Swal.mixin({
         buttonsStyling: true
      })
      swalWithBootstrapButtons.fire({
         title: 'Confirmación',
         text: "¿Está seguro que desea eliminar el libro seleccionado?",
         icon: 'warning',
         showCancelButton: true,
         confirmButtonText: 'Si, eliminar!',
         cancelButtonText: 'No',
         reverseButtons: true
      }).then((result) => {
         if (result.value) {
            this._shoppingCartService.remove(userBook).subscribe(response => {

               if (response) {
                  swalWithBootstrapButtons.fire(
                     'Mensaje!',
                     'Libro eliminado satisfactoriamente',
                     'success'
                  );
                  this.init();
               } else {
                  swalWithBootstrapButtons.fire(
                     ':( Error',
                     'Ups!! Algo marcha mal. Por favor verifica el estado del carro de compras.',
                     'error'
                  );
               }
            });
         }
      });


   }

   changeQuantity(book: AwaitCommitShoppingCart) {


      let userBook: ShoppingCartBook = {
         userId: book.userId,
         book: {
            bookId: book.book.id,
            quantity: book.quantity
         }
      };


      const swalWithBootstrapButtons = Swal.mixin({
         buttonsStyling: true
      });

      swalWithBootstrapButtons.fire({
         title: 'Confirmación',
         text: "¿Está seguro que desea cambiar la cantidad del libro seleccionado?",
         icon: 'warning',
         showCancelButton: true,
         confirmButtonText: 'Si, modificar!',
         cancelButtonText: 'No',
         reverseButtons: true
      }).then((result) => {
         if (result.value) {
            this._shoppingCartService.changeQuantity(userBook).subscribe(response => {

               if (response) {
                  swalWithBootstrapButtons.fire(
                     'Mensaje!',
                     'La cantidad fue modificada satisfactoriamente',
                     'success'
                  );
                  this.init();
               } else {
                  swalWithBootstrapButtons.fire(
                     ':( Error',
                     'Ups!! Algo marcha mal. Por favor verifica el estado del carro de compras.',
                     'error'
                  );
               }
            });
         }
      });
   }

   cancel() {

      const swalWithBootstrapButtons = Swal.mixin({
         buttonsStyling: true
      })

      swalWithBootstrapButtons.fire({
         title: 'Cancelar carro de compra',
         text: "¿Está seguro que desea eliminar los libros del carro de compra?. Al cancelar el carro de compra no podrá recuperar la información!",
         icon: 'warning',
         showCancelButton: true,
         confirmButtonText: 'Si, cancelar!',
         cancelButtonText: 'No',
         reverseButtons: true
      }).then((result) => {
         if (result.value) {
            this._shoppingCartService.cancel(1).subscribe(response => {
               if (response) {
                  swalWithBootstrapButtons.fire(
                     'Cancelado!',
                     'Sus carro de compra fue cancelado',
                     'success'
                  );
                  this.init();
               } else {
                  swalWithBootstrapButtons.fire(
                     'Error',
                     'ups!! algo sucedio, verifica el estado del carro de compras',
                     'error'
                  );
               }
            });
         }
      });

   }

   commit() {

      const swalWithBootstrapButtons = Swal.mixin({
         buttonsStyling: true
      })

      swalWithBootstrapButtons.fire({
         title: 'Confirmación',
         text: "¿Está seguro que desea confirmar la compra de los libros en el carro de compra?",
         icon: 'warning',
         showCancelButton: true,
         confirmButtonText: 'Si, comprar!',
         cancelButtonText: 'No',
         reverseButtons: true
      }).then((result) => {
         if (result.value) {
            this._shoppingCartService.commit(1).subscribe(response => {
               if (response) {
                  swalWithBootstrapButtons.fire(
                     'Felicidades!',
                     'Hemos recibido su solicitud y será procesada por los agentes. Gracias por su compra',
                     'success'
                  );
                  this.init();
               } else {
                  swalWithBootstrapButtons.fire(
                     ':( Error',
                     'Ups!! Algo marcha mal. Por favor verifica el estado del carro de compras',
                     'error'
                  );
               }
            });

         }
      });

   }

}