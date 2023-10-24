package com.make.pizza.api.controller;

import com.make.pizza.api.dto.RegisteredUser;
import com.make.pizza.api.dto.SaveUser;
import com.make.pizza.api.service.auth.AuthenticationService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/customers")
public class CustomerController {

    @Autowired
    private AuthenticationService authenticationService;

    @PostMapping
    public ResponseEntity<RegisteredUser> registerOne(@RequestBody @Valid SaveUser newUser){
        RegisteredUser registeredUser = authenticationService.registerOneCustomer(newUser);
        return ResponseEntity.status(HttpStatus.CREATED).body(registeredUser);
    }

}
