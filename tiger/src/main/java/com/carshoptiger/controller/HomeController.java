package com.carshoptiger.controller;

import com.carshoptiger.domain.Car;
import com.carshoptiger.domain.Testimonals;
import com.carshoptiger.service.API.CarInfoService;
import com.carshoptiger.service.API.CarPhotoService;
import com.carshoptiger.service.API.CarService;
import com.carshoptiger.service.API.TestimonalsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;
import java.util.stream.Collectors;

@Controller
public class HomeController {

    @Autowired
    private CarService carService;

    @Autowired
    private CarPhotoService carPhotoService;

    @Autowired
    private CarInfoService carInfoService;

    @Autowired
    private TestimonalsService testimonalsService;

    @GetMapping("/")
    public String homePage(Model model){
        List<Car> carList = carService.findAllCar().stream().limit(6).collect(Collectors.toList());
        List<Testimonals> testimonalsList = testimonalsService.findAllTestimonals().stream().limit(6).collect(Collectors.toList());

        model.addAttribute("page","Home");
        model.addAttribute("carlist",carList);
        model.addAttribute("carphotoservice",carPhotoService);
        model.addAttribute("carinfoservice",carInfoService);
        model.addAttribute("testimonals",testimonalsList);
        return "user/index";
    }

    @GetMapping("/aboutus")
    public String aboutusPage(){
        return "user/aboutus";
    }

    @GetMapping("/terms")
    public String termsPage(){
        return "user/terms";
    }
}
