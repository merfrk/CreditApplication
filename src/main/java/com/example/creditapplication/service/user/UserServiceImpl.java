package com.example.creditapplication.service.user;

import com.example.creditapplication.repository.user.UserDao;
import com.example.creditapplication.repository.user.UserEntity;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserDao userDao;

    @Override
    public User getUserByUserName(String userName) {
        Optional<UserEntity> entity = userDao.getUserByUserName(userName);
        return User.convertFrom(entity);
    }

    @Override
    public User getUserById(Long id) {
        Optional<UserEntity> entity = userDao.getUserById(id);
        return User.convertFrom(entity);
    }

    @Override
    public void saveUser(User user) {
        UserEntity entity = user.convertToUserEntity();
        userDao.saveUser(entity);
    }

    @Override
    public void updateUser(Long id, User newUser){
        Optional<UserEntity> entity = userDao.getUserById(id);
        if (entity.isPresent()) {
            UserEntity foundEntity = entity.get();
            foundEntity.setUserName(newUser.getUserName());
            foundEntity.setPassword(newUser.getPassword());
            userDao.saveUser(foundEntity);
        }

    }

    @Override
    public void deleteUserById(Long id){
        userDao.deleteUserById(id);
    }
}
