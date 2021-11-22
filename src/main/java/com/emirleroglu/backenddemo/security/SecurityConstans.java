package com.emirleroglu.backenddemo.security;

public class SecurityConstans {
    public static final String SECRET = "hatay";
    public static final long EXPIRATION_TIME = 900_000; // 15 mins
    public static final String TOKEN_PREFIX = "Bearer ";
    public static final String HEADER_STRING = "Authorization";
    public static final String SIGN_UP_URL = "/api";
}
