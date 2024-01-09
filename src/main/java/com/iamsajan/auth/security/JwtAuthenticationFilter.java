package com.iamsajan.auth.security;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;
import java.util.Optional;

/**
 * @Author Sajan Kc
 * @Date 2023/01/08
 * @Description: This class is used to filter the request and check the token
 */
@Component
@RequiredArgsConstructor
public class JwtAuthenticationFilter extends OncePerRequestFilter {
    private final JwtDecoder jwtDecoder;
    private final JwtToPrincipalConverter jwtToPrincipalConverter;

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
            throws ServletException, IOException {
        extractTokenFromRequest(request)
                .map(jwtDecoder::decode) //str->jwtDecoder.decode(str)
                .map(jwtToPrincipalConverter::convert) //jwt->jwtToPrincipalConverter.convert(jwt)
                .map(UserPrincipalAuthenticationToken::new) //userPrincipal->new UserPrincipalAuthenticationToken(userPrincipal)
                .ifPresent(authentication -> SecurityContextHolder.getContext().setAuthentication(authentication));

        filterChain.doFilter(request, response);

    }

    private Optional<String> extractTokenFromRequest(HttpServletRequest request) {
        var token = request.getHeader("Authorization");
        if (StringUtils.hasText(token) && token.startsWith("Bearer "))
            // Authorization: Bearer <token>
            return Optional.of(token.substring(7));
        return Optional.empty();
    }
}
