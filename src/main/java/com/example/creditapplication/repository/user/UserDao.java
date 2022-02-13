package com.example.creditapplication.repository.user;

import java.util.Optional;

public interface UserDao {
    Optional<UserEntity> getUserByUserName(String userName);
    void saveUser(UserEntity entity);
    Optional<UserEntity> getUserById(Long id);

    void deleteUserById(Long id);
}
