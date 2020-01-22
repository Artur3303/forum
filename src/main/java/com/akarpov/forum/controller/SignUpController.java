package com.akarpov.forum.controller;

import com.akarpov.forum.dto.UserDto;
import com.akarpov.forum.service.AppUserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;
import java.security.Principal;

@Controller
@RequestMapping("/signup")
public class SignUpController {

    private static final Logger LOGGER = LoggerFactory.getLogger(SignUpController.class);

    private AppUserService appUserService;

    public SignUpController(AppUserService appUserService) {
        this.appUserService = appUserService;
    }

    @GetMapping
    public String getSignUpPage(@AuthenticationPrincipal Principal principal) {
        if (principal != null) {
            return "redirect:/topics";
        }
        return "signup";
    }

    @PostMapping
    public String signUp(@AuthenticationPrincipal Principal principal,
                         @ModelAttribute @Valid UserDto userDto,
                         Errors errors) {
        LOGGER.info("HTTP method POST (sign up) has been called");
        if (principal != null) {
            return "redirect:/topics";
        }
        if (errors.hasErrors()) {
            errors.getAllErrors()
                    .forEach(error -> LOGGER.error(error.getDefaultMessage()));
        } else {
            appUserService.createUser(userDto);
        }
        return "redirect:/login";
    }

}
