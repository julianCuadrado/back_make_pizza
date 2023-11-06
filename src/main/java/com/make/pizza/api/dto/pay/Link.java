package com.make.pizza.api.dto.pay;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Link {

    private String href;
    private String rel;
    private String method;
}