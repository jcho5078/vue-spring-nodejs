package com.jcho.backapi.web.user.service.impl;

import com.jcho.backapi.domain.user.User;
import com.jcho.backapi.domain.user.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class LoginService implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String userId) throws UsernameNotFoundException {
        long id = Long.parseLong(userId);
        User user = userRepository.findById(id).get();
        return new org.springframework.security.core.userdetails.User(user.getLoginId(), user.getLoginPw(), new ArrayList<>());
    }
}