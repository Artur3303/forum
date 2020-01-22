package com.akarpov.forum.validator;

import com.akarpov.forum.annotation.UniqueUsername;
import com.akarpov.forum.service.AppUserService;
import org.springframework.beans.factory.annotation.Autowired;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class UniqueUsernameValidator implements ConstraintValidator<UniqueUsername, String> {

    @Autowired
    private AppUserService appUserService;

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        return !appUserService.isUsernameExists(value);
    }

}
