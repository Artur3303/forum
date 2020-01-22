package com.akarpov.forum.service.impl;

import com.akarpov.forum.entity.AppUser;
import com.akarpov.forum.repository.UserRepository;
import com.akarpov.forum.service.AppUserService;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AppUserServiceImpl implements AppUserService {

    private UserRepository userRepository;

    public AppUserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<AppUser> userOptional = userRepository.findByUsername(username);
        return userOptional
                .orElseThrow(() -> new UsernameNotFoundException("User with username '" + username + "' not found"));
    }

}
