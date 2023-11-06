package authentication;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class JwtAuthenticationFilter extends UsernamePasswordAuthenticationFilter {

    private final String secretKey;

    public JwtAuthenticationFilter(AuthenticationManager authenticationManager, String secretKey) {
        this.secretKey = secretKey;
    }


    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws IOException, ServletException {
        String token = extractTokenFromHeader(request);

        if (token != null) {
            try {
                token = token.substring(7); // Remove "Bearer " prefix
                Claims claims = Jwts.parser()
                        .setSigningKey(secretKey)
                        .parseClaimsJws(token)
                        .getBody();

                String username = claims.getSubject();

                if (username != null) {
                    Collection<SimpleGrantedAuthority> authorities = extractAuthorities(claims);
                    Authentication authentication = new UsernamePasswordAuthenticationToken(username, null, authorities);
                    SecurityContextHolder.getContext().setAuthentication(authentication);
                }
            } catch (Exception e) {
                // Handle token validation errors
            }
        }

        filterChain.doFilter(request, response);
    }

    private String extractTokenFromHeader(HttpServletRequest request) {
        String token = request.getHeader("Authorization");

        if (token != null && token.startsWith("Bearer ")) {
            return token;
        }

        return null;
    }

    private Collection<SimpleGrantedAuthority> extractAuthorities(Claims claims) {
        List<String> roles = (List<String>) claims.get("roles"); // Assuming roles are stored in the JWT claims

        if (roles != null) {
            Collection<SimpleGrantedAuthority> authorities = new ArrayList<>();

            for (String role : roles) {
                authorities.add(new SimpleGrantedAuthority(role));
            }

            return authorities;
        }

        return new ArrayList<>();
    }
}
