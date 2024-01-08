package com.iamsajan.security;

import org.springframework.security.authentication.AbstractAuthenticationToken;

/**
 * @Author Sajan Kc
 * @Date 2023/01/08
 * @Description: This class is used to authenticate user
 */
public class UserPrincipalAuthenticationToken extends AbstractAuthenticationToken {
    private final UserPrincipal userPrincipal;
    public UserPrincipalAuthenticationToken(UserPrincipal userPrincipal) {
        super(userPrincipal.getAuthorities());
        this.userPrincipal = userPrincipal;
        this.setAuthenticated(true);
    }

    @Override
    public Object getCredentials() {
        return null;
    }

    @Override
    public UserPrincipal getPrincipal() {
        return userPrincipal;
    }
}
