package com.company.backend.security;

public class SecurityConstants {

    private SecurityConstants() {
        throw new IllegalStateException("Utility class");
    }

    public static final String AUTHORIZATION_HEADER = "Authorization";
    public static final String AUTHORIZATION_HEADER_PREFIX = "Bearer ";

    public static final String USERNAME_FIELD = "username";
    public static final String PASSWORD_FIELD = "password";
}
