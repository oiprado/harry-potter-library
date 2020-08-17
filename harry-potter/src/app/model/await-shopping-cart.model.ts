import { Book } from './book.model';

export interface AwaitCommitShoppingCart {
   id?: number;
   quantity?: number;
   userId: number;
   book: Book;
}