package com.microserviceproject.security.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@Data
@SuperBuilder
@AllArgsConstructor
@NoArgsConstructor
public class RegisterUserVo {

    private String firstName;
    private String lastName;
    private String email;
    private String password;
}
