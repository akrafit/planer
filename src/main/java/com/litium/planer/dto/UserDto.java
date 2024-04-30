package com.litium.planer.dto;

import com.litium.planer.model.UserEntity;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserDto {
    private Long id;
    private String name;
    private String login;
    private String password;

    public UserDto(UserEntity userEntity) {
        this.id = userEntity.getId();
        this.name = userEntity.getName();
        this.login = userEntity.getEmail();
        this.password = userEntity.getPasswordOpen();
    }
}
