package com.dailycodework.ilibrary.security.jwt;

import lombok.Data;

@Data
public class JwtAuthenticationRequest {

    private String username;
    private String password;


}
