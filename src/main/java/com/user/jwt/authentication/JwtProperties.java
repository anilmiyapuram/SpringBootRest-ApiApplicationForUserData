package com.user.jwt.authentication;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Configuration
@ConfigurationProperties(prefix = "jwt")
public class JwtProperties {
    private String secret;
    private int expirationInMs;

    // Getter and setter methods for secret and expirationInMs

    public String getSecret() {
        return secret;
    }

    public void setSecret(String secret) {
        this.secret = secret;
    }

    public int getExpirationInMs() {
        return expirationInMs;
    }

    public void setExpirationInMs(int expirationInMs) {
        this.expirationInMs = expirationInMs;
    }
}
