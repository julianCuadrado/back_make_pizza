package com.make.pizza.api.dto.pay;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class Payments {

    private List<Capture> captures;
}