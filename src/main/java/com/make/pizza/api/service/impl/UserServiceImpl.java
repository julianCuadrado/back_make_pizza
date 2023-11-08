package com.make.pizza.api.service.impl;

import com.make.pizza.api.dto.SaveUser;
import com.make.pizza.api.exception.InvalidPasswordException;
import com.make.pizza.api.exception.ObjectNotFoundException;
import com.make.pizza.api.persistence.entity.User;
import com.make.pizza.api.persistence.repository.UserRepository;
import com.make.pizza.api.persistence.util.Role;
import com.make.pizza.api.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public User registrOneCustomer(SaveUser newUser) {
        validatePassword(newUser);
        Optional<User> opt = findOneByUsername(newUser.getUsername());
        if(opt.isPresent()) {
            throw new ObjectNotFoundException("El usuario ya existe.");
        }
        User user = new User();
        user.setPassword(passwordEncoder.encode(newUser.getPassword()));
        user.setUsername(newUser.getUsername());
        user.setName(newUser.getName());
        user.setRole(Role.CUSTOMER);

        return userRepository.save(user);
    }

    @Override
    public Optional<User> findOneByUsername(String username) {
        return userRepository.findByUsername(username);
    }

    private void validatePassword(SaveUser dto) {

        if(!StringUtils.hasText(dto.getPassword()) || !StringUtils.hasText(dto.getRepeatedPassword())){
            throw new InvalidPasswordException("Las contraseñas no coinciden.");
        }

        if(!dto.getPassword().equals(dto.getRepeatedPassword())){
            throw new InvalidPasswordException("Las contraseñas no coinciden.");
        }

    }

}
