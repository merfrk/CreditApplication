package com.example.creditapplication.service.user;

public interface UserService {
    User getUserByUserName(String userName);

    User getUserById(Long id);

    void saveUser(User user);

    void updateUser(Long id, User newUser);

    void deleteUserById(Long id);
}
