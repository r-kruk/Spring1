package com.github.rkruk.spring.demo.controllers;

import com.github.rkruk.spring.demo.model.repositories.AdvertRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
@RequestMapping("/")
public class HomePageController {

    private final Model model;
    private final AdvertRepository advertRepository;

    public HomePageController(Model model, AdvertRepository advertRepository) {
        this.model = model;
        this.advertRepository = advertRepository;

        model = List<Advert> findAllByOrderByPostedDesc();
    }

    @GetMapping
    public String prepareHomePage() {
        return "";
    }
}
