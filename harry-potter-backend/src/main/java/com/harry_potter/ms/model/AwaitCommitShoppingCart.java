package com.harry_potter.ms.model;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "await_commit_shopping_cart")
@Data
public class AwaitCommitShoppingCart {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;
    @Column(name = "user_id")
    private Integer userId;
    @Column(name = "quantity")
    private Integer quantity;
    @JoinColumn(name = "book_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Book book;
}
