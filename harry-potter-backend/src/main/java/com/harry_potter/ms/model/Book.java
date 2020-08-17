package com.harry_potter.ms.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Data
@Entity
@Table(name = "book")
public class Book {
    @Id
    @Column(name = "id")
    private Integer id;
    @Column(name = "title")
    private String title;
    @Column(name = "price")
    private Double price;
    @Column(name = "quantity")
    private Double quantity;
    @Column(name = "cover")
    private String cover;
    @JsonIgnore
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "book")
    List<ShoppingCartDetail> shoppingCartDetails;
    @JsonIgnore
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "book")
    List<AwaitCommitShoppingCart> awaitCommitShoppingCarts;

}
