import { SimpleRest, Method, Resource } from 'ngx-simple-rest';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { BookSpec } from '../model/book.model';

@Injectable()
@Resource(
   {
      host: "http://localhost:8082",
      basePath: "/book",
      useToken: false
   }
)
export class BookService extends SimpleRest<any> {

   onInit() { }

   @Method({
      name: "/",
      type: "get",
      headers: [
         { name: "Content-Type", value: "application/json" },
         { name: "Accept", value: "application/json" }
      ]
   })
   public books(): Observable<BookSpec[]> {
      return this.invokeResource(this, {});
   }

}