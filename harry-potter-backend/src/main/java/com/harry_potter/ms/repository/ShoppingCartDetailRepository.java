package com.harry_potter.ms.repository;

import com.harry_potter.ms.model.ShoppingCartDetail;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ShoppingCartDetailRepository extends JpaRepository<ShoppingCartDetail, Integer> {
}
