package com.example.creditapplication.repository.user;


import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserDaoImpl implements UserDao {

    private final UserJpaRepository userJpaRepository;

    @Override
    public Optional<UserEntity> getUserByUserName(String userName) {

        return Optional.ofNullable(userJpaRepository.findByUserName(userName));
    }

    @Override
    public Optional<UserEntity> getUserById(Long id) {
        return userJpaRepository.findById(id);
    }

    @Override
    public void saveUser(UserEntity entity) {
        userJpaRepository.save(entity);
    }


    @Override
    public void deleteUserById(Long id){
        userJpaRepository.deleteById(id);
    }

}
