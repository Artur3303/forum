package com.akarpov.forum.service.impl;

import com.akarpov.forum.dto.UserDto;
import com.akarpov.forum.entity.AppUser;
import com.akarpov.forum.entity.Role;
import com.akarpov.forum.repository.UserRepository;
import com.akarpov.forum.service.AppUserService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class AppUserServiceImpl implements AppUserService {

    private UserRepository userRepository;
    private PasswordEncoder passwordEncoder;

    public AppUserServiceImpl(UserRepository userRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public boolean isUsernameExists(String username) {
        return userRepository.existsByUsername(username);
    }

    @Override
    public AppUser createUser(UserDto userDto) {
        AppUser user = AppUser.builder()
                .username(userDto.getUsername())
                .encryptedPassword(passwordEncoder.encode(userDto.getPassword()))
                .firstName(userDto.getFirstName())
                .lastName(userDto.getLastName())
                .role(Role.USER)
                .build();
        return userRepository.save(user);
    }
}
