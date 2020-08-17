package com.harry_potter.ms.service.impl;

import com.harry_potter.ms.model.Book;
import com.harry_potter.ms.repository.BookRepository;
import com.harry_potter.ms.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookServiceImpl implements BookService {

    @Autowired
    private BookRepository bookRepository;

    @Override
    public List<Book> findBooks() {
        return bookRepository.findAll();
    }

    @Override
    public Book getBookById(Integer id) {
        return bookRepository.getOne(id);
    }

    @Override
    public void updateQuantity(Integer id, Integer quantity) {

        if(id == null){
            throw new RuntimeException("Book id is empty");
        }
        Book book = getBookById(id);

        if(book == null) {
            throw new RuntimeException("Book doesn't exists");
        }

        if(quantity > book.getQuantity()){
            throw new RuntimeException("Wrong quantity value");
        }
        
        book.setQuantity(book.getQuantity() - quantity);
        bookRepository.save(book);
    }
}
