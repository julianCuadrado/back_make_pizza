package com.make.pizza.api.service.impl;

import com.make.pizza.api.exception.ObjectNotFoundException;
import com.make.pizza.api.persistence.entity.SystemParameter;
import com.make.pizza.api.persistence.repository.SystemParameterRepository;
import com.make.pizza.api.service.SystemParameterService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class SystemParameterServiceImpl implements SystemParameterService {

    private final SystemParameterRepository systemParameterRepository;

    @Override
    public String getParameterValue(String parameterName) {
        Optional<SystemParameter> opt = systemParameterRepository.findByName(parameterName);
        if(opt.isEmpty()) {
            throw new ObjectNotFoundException("Parametrización no valida");
        }
        return opt.get().getValue();
    }
}