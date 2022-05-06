package com.carshoptiger.controller;

import com.carshoptiger.domain.Testimonals;
import com.carshoptiger.service.API.TestimonalsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/testimonals")
public class TestimonalsController {

    @Autowired
    private TestimonalsService testimonalsService;

    @GetMapping("/")
    public String testimonalsPage(Model model){
        model.addAttribute("testimonals",testimonalsService.findAllTestimonals());
        return "user/testimonals";
    }

    @GetMapping("/write")
    public String testimonalsWritePage(){
        return "user/testimonalswrite";
    }

    @PostMapping("/write")
    public String testimonalsWrite(@RequestParam(name = "fullname")String fullname,
                                   @RequestParam(name = "message_testimonals")String message){
        Testimonals testimonals_save = new Testimonals();
        testimonals_save.setFullname(fullname);
        testimonals_save.setMessage_testimonals(message);
        boolean result_save_testimonals = testimonalsService.savetestimonals(testimonals_save);
        return "redirect:/testimonals/";
    }

}
