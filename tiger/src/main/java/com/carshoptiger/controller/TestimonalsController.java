package com.carshoptiger.controller;

import com.carshoptiger.service.API.TestimonalsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class TestimonalsController {

    @Autowired
    private TestimonalsService testimonalsService;

    @GetMapping("/testimonals")
    public String testimonalsPage(Model model){
        model.addAttribute("testimonals",testimonalsService.findAllTestimonals());
        return "user/testimonals";
    }

}
