package com.web.bloomingdales.entity;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class JwtRequest {
    private String username;
    private String userPassword;
}
