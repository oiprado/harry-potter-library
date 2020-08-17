export interface BookSpec extends Book {
   userId: number;
   quantityCart: number;
}

export interface Book {

   id: number;
   title: string;
   price: number;
   quantity: number;
   cover: string;

}