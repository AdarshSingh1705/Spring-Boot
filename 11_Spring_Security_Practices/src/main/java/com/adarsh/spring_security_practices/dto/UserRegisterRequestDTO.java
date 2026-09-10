package com.adarsh.spring_security_practices.dto;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class UserRegisterRequestDTO {

    private String username;
    private String password;
}
