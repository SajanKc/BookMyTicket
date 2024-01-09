package com.iamsajan.auth.security;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

/**
 * @Author Sajan Kc
 * @Date 2023/01/07
 * @Description: This class is used to hold JWT properties
 */
@Data
@Configuration
@ConfigurationProperties("security.jwt")
public class JwtProperties {
    /**
     * Secret key used for signing JWT
     */
    private String secretKey;
}
