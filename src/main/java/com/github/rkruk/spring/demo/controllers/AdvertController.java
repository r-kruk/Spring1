package com.github.rkruk.spring.demo.controllers;

import com.github.rkruk.spring.demo.model.domain.Advert;
import com.github.rkruk.spring.demo.model.domain.User;
import com.github.rkruk.spring.demo.model.repositories.AdvertRepository;
import com.github.rkruk.spring.demo.model.repositories.UserRepository;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.security.Principal;

@Controller
public class AdvertController {

    private static final Logger log = LoggerFactory.getLogger(AdvertController.class);

    private final UserRepository userRepository;
    private final AdvertRepository advertRepository;

    @Autowired
    public AdvertController(UserRepository userRepository, AdvertRepository advertRepository) {
        this.userRepository = userRepository;
        this.advertRepository = advertRepository;
    }

    @GetMapping
    public String prepareNewAdvertForm() {
        return "";
    }

    @PostMapping("/add-advert")
    public String addAdvert(String title, String description, Principal principal) {
        String username = principal.getName();
        User user = userRepository.findByUsername(username);


        Advert advert = Advert.builder()
                .title(title)
                .description(description)
                .owner(user)
                .build();


        advert = advertRepository.save(advert);
        log.info("Dodana ogłoszenie: {}", advert);
        return "redirect:/";
    }

}
