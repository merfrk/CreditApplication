package com.example.creditapplication.service.user;

import com.example.creditapplication.repository.user.UserEntity;
import com.example.creditapplication.repository.user.UserJpaRepository;
import com.example.creditapplication.security.JwtUserDetails;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    private UserJpaRepository userJpaRepository;

    public UserDetailsServiceImpl(UserJpaRepository userJpaRepository) {
        this.userJpaRepository = userJpaRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        UserEntity user = userJpaRepository.findByUserName(s);
        return JwtUserDetails.create(user);
    }

    public UserDetails loadUserById(Long id){
        UserEntity user = userJpaRepository.findById(id).get();
        return JwtUserDetails.create(user);
    }
}
