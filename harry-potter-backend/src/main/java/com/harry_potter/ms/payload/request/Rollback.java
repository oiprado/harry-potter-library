package com.harry_potter.ms.payload.request;

import com.sun.istack.NotNull;
import lombok.Data;

@Data
public class    Rollback {
    @NotNull
    private Integer userId;
}
