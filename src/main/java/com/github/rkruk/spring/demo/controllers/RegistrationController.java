package com.github.rkruk.spring.demo.controllers;

import com.github.rkruk.spring.demo.model.domain.User;
import com.github.rkruk.spring.demo.model.repositories.UserRepository;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Slf4j
@Controller
@RequestMapping("/register")

public class RegistrationController {

    private final UserRepository userRepository;

//    private static final Logger log = LoggerFactory.getLogger(RegistrationController.java);

    @Autowired
    public RegistrationController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @GetMapping
    public String prepareRegistrationPage() {
        return "/WEB-INF/views/registration-form.jsp";
    }

    @PostMapping
    public String processRegistrationPage(String username, String password, String firstName, String lastName) {

        User user = User.builder()
                .username(username)
                .password(password)
                .firstName(firstName)
                .lastName(lastName)
                .active(true)
                .build();


        userRepository.save(user);

        log.info("Zapisany użytkownik: {}", user);
        return "redirect:/index.html";
    }
}
