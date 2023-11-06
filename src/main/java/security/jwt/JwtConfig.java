package security.jwt;

import authentication.JwtProperties;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class JwtConfig {
    private final JwtProperties jwtProperties;

    public JwtConfig(JwtProperties jwtProperties) {
        this.jwtProperties = jwtProperties;
    }

    @Bean
    public String jwtSecretKeyValue() {
        return jwtProperties.getSecret();
    }

    @Bean
    public int jwtExpirationInMsyes() {
        return jwtProperties.getExpirationInMs();
    }
    @Value("${jwt.secret}")
    private String jwtSecret;

    @Value("${jwt.expirationInMs}")
    private int jwtExpirationInMs;

}
