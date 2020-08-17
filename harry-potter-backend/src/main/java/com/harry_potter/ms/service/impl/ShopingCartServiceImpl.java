package com.harry_potter.ms.service.impl;

import com.harry_potter.ms.model.AwaitCommitShoppingCart;
import com.harry_potter.ms.model.Book;
import com.harry_potter.ms.model.ShoppingCart;
import com.harry_potter.ms.model.ShoppingCartDetail;
import com.harry_potter.ms.payload.request.Commit;
import com.harry_potter.ms.payload.request.Rollback;
import com.harry_potter.ms.payload.request.UserBook;
import com.harry_potter.ms.repository.AwaitCommitSoppingCartRepository;
import com.harry_potter.ms.repository.ShoppingCartRepository;
import com.harry_potter.ms.service.BookService;
import com.harry_potter.ms.service.ShoppingCartService;
import lombok.extern.java.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.stream.Collectors;

@Log
@Service
public class ShopingCartServiceImpl implements ShoppingCartService {

    @Autowired
    private BookService bookService;
    @Autowired
    private ShoppingCartRepository shoppingCartRepository;
    @Autowired
    private AwaitCommitSoppingCartRepository awaitCommitSoppingCartRepository;

    @Override
    @Transactional
    public boolean commit(Commit commit) {

        try{
            List<ShoppingCartDetail> books = new ArrayList<>();

            List<AwaitCommitShoppingCart> awaitCommitShoppingCart =  awaitCommitSoppingCartRepository
                    .findAwaitCommitShoppingCartByUserId(commit.getUserId());

            ShoppingCart shoppingCart = new ShoppingCart();

            shoppingCart.setShoppingCartDetails(books);
            shoppingCart.setPurchaseDate(new Date());
            shoppingCart.setUserId(commit.getUserId());

            books = awaitCommitShoppingCart
                .stream()
                .map(book -> {
                    ShoppingCartDetail shoppingCartDetail = new ShoppingCartDetail();
                    shoppingCartDetail.setBook(book.getBook());
                    shoppingCartDetail.setQuantity(book.getQuantity());
                    shoppingCartDetail.setShoppingCart(shoppingCart);
                    return shoppingCartDetail;
                }).collect(Collectors.toList());

            shoppingCart.setShoppingCartDetails(books);

            shoppingCartRepository.save(shoppingCart);

            awaitCommitShoppingCart.stream().forEach(book -> {
                bookService.updateQuantity(book.getBook().getId(), book.getQuantity());
                awaitCommitSoppingCartRepository.delete(book);
            });

            return true;
        }catch (Exception ex) {
            log.log(Level.SEVERE, ex.getMessage());
            return false;
        }
    }

    @Override
    @Transactional
    public boolean cancel(Rollback rollback) {

        try{

            List<AwaitCommitShoppingCart> awaitCommitShoppingCart =  awaitCommitSoppingCartRepository
                    .findAwaitCommitShoppingCartByUserId(rollback.getUserId());

            if(awaitCommitShoppingCart.isEmpty()) {
                throw new RuntimeException("Transaction not found");
            }

            awaitCommitShoppingCart.stream().forEach(book -> {
                awaitCommitSoppingCartRepository.delete(book);
            });

            return true;
        }catch (Exception ex) {
            log.log(Level.SEVERE, ex.getMessage());
            return false;
        }
    }

    public boolean add(UserBook userBook) {
        try{

            Book book = bookService.getBookById(userBook.getBook().getBookId());

            if(book == null) {
                throw new RuntimeException("Book doesn't exists");
            }

            AwaitCommitShoppingCart awaitCommitShoppingCart = new AwaitCommitShoppingCart();
            awaitCommitShoppingCart.setUserId(userBook.getUserId());
            awaitCommitShoppingCart.setQuantity(userBook.getBook().getQuantity());
            awaitCommitShoppingCart.setBook(book);

            awaitCommitSoppingCartRepository.save(awaitCommitShoppingCart);

            return true;
        }catch (Exception ex){
            return false;
        }
    }

    @Override
    public List<AwaitCommitShoppingCart> getAwaitCommitShoppingCartByUser(Integer userId) {
        return awaitCommitSoppingCartRepository.findAwaitCommitShoppingCartByUserId(userId);
    }

    @Override
    public boolean removeFromAwaiteCommitShoppingCart(UserBook userBook) {

       try {
           AwaitCommitShoppingCart awaitCommitShoppingCart = awaitCommitSoppingCartRepository
                   .findAwaitCommitShoppingCartByBookAndUserId(
                           bookService.getBookById(userBook.getBook().getBookId()),
                           userBook.getUserId()
                   );

           awaitCommitSoppingCartRepository.delete(awaitCommitShoppingCart);
           return true;
       }catch (Exception ex){
           return false;
       }
    }

    @Override
    public boolean updateFromAwaiteCommitShoppingCart(UserBook userBook) {

        try {
            Book book = bookService.getBookById(userBook.getBook().getBookId());
            AwaitCommitShoppingCart awaitCommitShoppingCart = awaitCommitSoppingCartRepository
                    .findAwaitCommitShoppingCartByBookAndUserId( book, userBook.getUserId());

            if(userBook.getBook().getQuantity() > book.getQuantity()){
                throw new RuntimeException(String.format("Wrong quantity value for book id: %d ", book.getId()));
            }

            awaitCommitShoppingCart.setQuantity(userBook.getBook().getQuantity());

            awaitCommitSoppingCartRepository.save(awaitCommitShoppingCart);
            return true;
        }catch (Exception ex){
            return false;
        }

    }
}
