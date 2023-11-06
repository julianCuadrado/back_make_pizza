package com.make.pizza.api.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class UserDTO {

    private Long id;
    private String username;
    private String name;
    private String password;
    private String role;
    private Boolean enabled;
    private Boolean accountNonLocked;
    private Boolean credentialsNonExpired;
    private Boolean accountNonExpired;
}