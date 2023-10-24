package com.make.pizza.api.service;


import com.make.pizza.api.dto.SaveUser;
import com.make.pizza.api.persistence.entity.User;

import java.util.Optional;

public interface UserService {
    User registrOneCustomer(SaveUser newUser);

    Optional<User> findOneByUsername(String username);
}
