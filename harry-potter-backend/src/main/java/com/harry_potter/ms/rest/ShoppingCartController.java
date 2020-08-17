package com.harry_potter.ms.rest;

import com.harry_potter.ms.payload.request.Commit;
import com.harry_potter.ms.payload.request.Rollback;
import com.harry_potter.ms.payload.request.UserBook;
import com.harry_potter.ms.service.ShoppingCartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/shopping-cart")
public class ShoppingCartController {

    @Autowired
    private ShoppingCartService shoppinCartService;

    @RequestMapping(method = RequestMethod.GET, value = "/{userId}")
    public ResponseEntity getAwaitCommitShoppingCartByUser(@PathVariable("userId") Integer userId){
        if(userId == null) {
            return ResponseEntity
                    .badRequest()
                    .build();
        }
        return ResponseEntity.ok(shoppinCartService.getAwaitCommitShoppingCartByUser(userId));
    }

    @RequestMapping(method = RequestMethod.POST, value = "/add")
    public ResponseEntity add(@RequestBody UserBook userBook){
        if(userBook.getUserId() == null) {
            return ResponseEntity
                    .badRequest()
                    .body("userId is required");
        }
        return ResponseEntity.ok(shoppinCartService.add(userBook));
    }

    @RequestMapping(method = RequestMethod.POST, value = "/remove")
    public ResponseEntity removeFromAwaiteCommitShoppingCart(@RequestBody UserBook userBook){
        if(userBook.getUserId() == null) {
            return ResponseEntity
                    .badRequest()
                    .body("userId is required");
        }
        return ResponseEntity.ok(shoppinCartService.removeFromAwaiteCommitShoppingCart(userBook));
    }

    @RequestMapping(method = RequestMethod.POST, value = "/update")
    public ResponseEntity updateQuantityFromAwaiteCommitShoppingCart(@RequestBody UserBook userBook){
        if(userBook.getUserId() == null) {
            return ResponseEntity
                    .badRequest()
                    .build();
        }
        return ResponseEntity.ok(shoppinCartService.updateFromAwaiteCommitShoppingCart(userBook));
    }

    @RequestMapping(method = RequestMethod.POST, value = "/commit")
    public ResponseEntity commit(@RequestBody Commit commit) {
        if(commit.getUserId() == null) {
            return ResponseEntity
                .badRequest()
                .build();
        }
        boolean response = shoppinCartService.commit(commit);
        return ResponseEntity.ok(response);
    }

    @RequestMapping(method = RequestMethod.POST, value = "/cancel")
    public ResponseEntity cancel(@Validated @RequestBody Rollback rollback) {
        if(rollback.getUserId() == null) {
            return ResponseEntity
                    .badRequest()
                    .body("userId is required");
        }
        boolean response = shoppinCartService.cancel(rollback);
        return ResponseEntity.ok(response);
    }

}
