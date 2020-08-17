package com.harry_potter.ms.payload.request;

import lombok.Data;

@Data
public class UserBook {

    private Integer userId;
    private Book book;
}
