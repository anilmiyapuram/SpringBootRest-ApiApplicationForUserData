package com.user.utility;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

@Component
public class UserIdProvider {
    public Long getUserId() {

        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (authentication != null && authentication.isAuthenticated()) {
            Object principal = authentication.getPrincipal();
            if (principal instanceof UserDetails) {
                return ((com.user.entity.UserDetails) principal).getUserId();
            }
            else {
                throw new IllegalStateException("Unexpected principal type: " + principal.getClass());
            }
        }
        else {
            throw new IllegalStateException("User is not authenticated");
        }
    }
}
