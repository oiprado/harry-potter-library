package com.harry_potter.ms.service;

import com.harry_potter.ms.model.Book;

import java.util.List;

public interface BookService {
    List<Book> findBooks();
    Book getBookById(Integer id);
    void updateQuantity(Integer id, Integer quantity);
}
