import { Book } from './book.model';

export interface ShoppingCartBook {
   quantity?: number;
   userId: number;
   book: UserBook;
}

