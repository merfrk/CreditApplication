package com.example.creditapplication.service.user;

import com.example.creditapplication.repository.user.UserEntity;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.Optional;

@Getter
@Setter
@Builder
public class User {

    private Long id;
    private String userName;
    private String password;

    public UserEntity convertToUserEntity() {
        UserEntity entity = new UserEntity();
        entity.setUserName(userName);
        entity.setPassword(password);
        return entity;
    }

    public static User convertFrom(Optional<UserEntity> entity){
        if(entity.isEmpty()) return null;

        UserEntity userEntity = entity.get();
        return User.builder()
                .userName(userEntity.getUserName())
                .password(userEntity.getPassword())
                .build();
    }
}
