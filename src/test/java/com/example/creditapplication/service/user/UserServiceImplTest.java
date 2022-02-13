package com.example.creditapplication.service.user;

import com.example.creditapplication.repository.user.UserDao;
import com.example.creditapplication.repository.user.UserEntity;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class UserServiceImplTest {

    UserServiceImpl userService;

    @Mock
    UserDao userDao;

    @BeforeEach
    void setUp() {
        userService = new UserServiceImpl(userDao);
    }

    @Test
    void should_retrieve_user_by_user_name(){
        //mock
        User mockUser = User.builder()
                .userName("username")
                .build();

        when(userDao.getUserByUserName("username")).thenReturn(Optional.ofNullable(mockUser.convertToUserEntity()));

        //when
        User user = userService.getUserByUserName("username");

        //then
        assertThat(user).isNotNull();
        assertThat(user.getUserName()).isEqualTo("username");
    }
    @Test
    void should_retrieve_user_by_id(){
        //mock
        UserEntity mockUserEntity = new UserEntity();
        mockUserEntity.setId(1L);
        mockUserEntity.setUserName("username");

        when(userDao.getUserById(1L)).thenReturn(Optional.ofNullable(mockUserEntity));

        //when
        User user = userService.getUserById(1L);

        //then
        assertThat(user).isNotNull();
        assertThat(user.getUserName()).isEqualTo("username");
    }
}