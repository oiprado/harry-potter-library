import { Injectable } from '@angular/core';
import { BookSpec } from '../model/book.model';
import { SimpleRest, Method, Resource } from 'ngx-simple-rest';
import { findIndex, propEq } from "ramda";
import { Observable } from 'rxjs';
import { ShoppingCartBook } from '../model/shopping-cart.model';
import { AwaitCommitShoppingCart } from '../model/await-shopping-cart.model';

@Injectable()
@Resource(
   {
      host: "http://localhost:8082",
      basePath: "/shopping-cart",
      useToken: false
   }
)
export class ShoppingCartService extends SimpleRest<any> {


   _shoppingCart: AwaitCommitShoppingCart[];

   onInit(): void {
      this._shoppingCart = [];
   }



   hasBooks(): boolean {
      return !(this._shoppingCart == null || this._shoppingCart.length == 0);
   }

   init(userId: number) {
      this.getShoppingCartByUserId(userId).subscribe(response => this._shoppingCart = response);
   }

   @Method({
      name: "/{userId}",
      type: "get-url",
      headers: [
         { name: "Content-Type", value: "application/json" },
         { name: "Accept", value: "application/json" }
      ]
   })
   getShoppingCartByUserId(userId: number): Observable<any> {
      return this.invokeResource(this, { userId: userId });
   }

   @Method({
      name: "/add",
      type: "post",
      headers: [
         { name: "Content-Type", value: "application/json" },
         { name: "Accept", value: "application/json" }
      ]
   })
   addToCart(book: ShoppingCartBook): Observable<any> {
      return this.invokeResource(this, book);
   }

   @Method({
      name: "/update",
      type: "post",
      headers: [
         { name: "Content-Type", value: "application/json" },
         { name: "Accept", value: "application/json" }
      ]
   })
   changeQuantity(book: ShoppingCartBook): Observable<any> {
      return this.invokeResource(this, book);
   }

   @Method({
      name: "/remove",
      type: "post",
      headers: [
         { name: "Content-Type", value: "application/json" },
         { name: "Accept", value: "application/json" }
      ]
   })
   remove(book: ShoppingCartBook) {
      return this.invokeResource(this, book);
   }

   @Method({
      name: "/cancel",
      type: "post",
      headers: [
         { name: "Content-Type", value: "application/json" },
         { name: "Accept", value: "application/json" }
      ]
   })
   cancel(userId: number): Observable<any> {
      return this.invokeResource(this, { userId: userId });
   }

   @Method({
      name: "/commit",
      type: "post",
      headers: [
         { name: "Content-Type", value: "application/json" },
         { name: "Accept", value: "application/json" }
      ]
   })
   commit(userId: number): Observable<any> {

      return this.invokeResource(this, { userId: userId });
   }

   getTotal(): number {
      let total = 0;

      if (!this.hasBooks()) return total;

      this._shoppingCart.forEach((item: AwaitCommitShoppingCart) => {
         total += item.quantity * item.book.price;
      });

      return total;
   }

}