package com.iamsajan.service;

import com.iamsajan.entity.UserEntity;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;

/**
 * @Author Sajan Kc
 * @Date 2023/01/08
 * @Description: This class is used to get user details
 */
@Service
public class UserService {
    private static final String EXISTING_USERNAME = "iamsajan";

    public Optional<UserEntity> findByUsername(String username) {
        //  @TODO: move this to database
        if (!EXISTING_USERNAME.equalsIgnoreCase(username))
            return Optional.empty();
        var user = new UserEntity();
        user.setId(UUID.randomUUID().toString());
        user.setUsername(EXISTING_USERNAME);
        user.setPassword("$2y$10$6VhUGIRr1Mk4XcllMAfrfuoHxy63vlat4W.hmF8gAPHZ8v0zYK6rm"); // bcrypt hash of "sajankc"
        user.setRole("ROLE_ADMIN");
        user.setExtraInfo("This is admin Sajan Kc");

        return Optional.of(user);
    }
}
