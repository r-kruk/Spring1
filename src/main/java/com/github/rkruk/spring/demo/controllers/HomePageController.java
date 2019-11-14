package com.github.rkruk.spring.demo.controllers;

import com.github.rkruk.spring.demo.model.domain.Advert;
import com.github.rkruk.spring.demo.model.repositories.AdvertRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;


@Controller
@RequestMapping("/")
public class HomePageController {

    private final AdvertRepository advertRepository;

    @Autowired
    public HomePageController(AdvertRepository advertRepository) {
        this.advertRepository = advertRepository;
    }


    @GetMapping
    public String prepareHomePage(Model model) {
        List<Advert> allAdverts = advertRepository.findAllByOrderByPostedDesc();
        model.addAttribute("adverts", allAdverts);
        return "/WEB-INF/views/home-page.jsp";
    }

//    @PostMapping("/add-advert")
//    public String advertAddingForm(String title, String description) {
//        return "/WEB-INF/views/home-page.jsp";
//    }
}
