package com.akarpov.forum.service;

import com.akarpov.forum.dto.UserDto;
import com.akarpov.forum.entity.AppUser;

public interface AppUserService {

    boolean isUsernameExists(String username);

    AppUser createUser(UserDto userDto);
}
