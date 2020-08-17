package com.harry_potter.ms.model;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "shopping_cart_detail")
@Data
public class ShoppingCartDetail {
    @Id()
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;
    @JoinColumn(name = "book_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Book book;
    @Column(name = "quantity")
    private Integer quantity;
    @JoinColumn(name = "shopping_cart_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private ShoppingCart shoppingCart;

}
