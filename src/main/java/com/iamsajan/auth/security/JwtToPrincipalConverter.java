package com.iamsajan.auth.security;

import com.auth0.jwt.interfaces.DecodedJWT;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @Author Sajan Kc
 * @Date 2023/01/08
 * @Description: This class is used to convert the token to principal
 */
@Component
public class JwtToPrincipalConverter {
    public UserPrincipal convert(DecodedJWT decodedJWT) {
        return UserPrincipal.builder()
                .userId(decodedJWT.getId())
                .username(decodedJWT.getSubject())
                .authorities(getAuthoritiesFromClaims(decodedJWT))
                .build();
    }

    private List<SimpleGrantedAuthority> getAuthoritiesFromClaims(DecodedJWT decodedJWT) {
        var claim = decodedJWT.getClaim("roles");
        if (claim.isNull() || claim.isMissing())
            return List.of();
        return claim.asList(SimpleGrantedAuthority.class);
    }
}
