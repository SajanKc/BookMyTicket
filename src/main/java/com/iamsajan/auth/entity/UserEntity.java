package com.iamsajan.auth.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

/**
 * @Author Sajan Kc
 * @Date 2023/01/08
 * @Description: This class is User Entity
 */
@Data
public class UserEntity {
    private String id;
    private String username;
    @JsonIgnore
    private String password;
    private String role;
    private String extraInfo;
}
