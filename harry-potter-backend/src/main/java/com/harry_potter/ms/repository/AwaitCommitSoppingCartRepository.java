package com.harry_potter.ms.repository;

import com.harry_potter.ms.model.AwaitCommitShoppingCart;
import com.harry_potter.ms.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AwaitCommitSoppingCartRepository extends JpaRepository<AwaitCommitShoppingCart, Integer> {

    List<AwaitCommitShoppingCart> findAwaitCommitShoppingCartByUserId(Integer userId);

    AwaitCommitShoppingCart findAwaitCommitShoppingCartByBookAndUserId(Book book, Integer userId);

}
