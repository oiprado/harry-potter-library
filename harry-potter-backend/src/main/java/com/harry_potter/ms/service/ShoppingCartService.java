package com.harry_potter.ms.service;

import com.harry_potter.ms.model.AwaitCommitShoppingCart;
import com.harry_potter.ms.payload.request.Commit;
import com.harry_potter.ms.payload.request.Rollback;
import com.harry_potter.ms.payload.request.UserBook;

import java.util.List;

public interface ShoppingCartService {

    List<AwaitCommitShoppingCart> getAwaitCommitShoppingCartByUser(Integer userId);

    boolean commit(Commit commit);

    boolean cancel(Rollback rollback);

    boolean add(UserBook userBook);

    boolean removeFromAwaiteCommitShoppingCart(UserBook userBook);

    boolean updateFromAwaiteCommitShoppingCart(UserBook userBook);

}
