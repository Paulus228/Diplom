package com.carshoptiger.controller;

import com.carshoptiger.domain.Car;
import com.carshoptiger.service.API.CarInfoService;
import com.carshoptiger.service.API.CarPhotoService;
import com.carshoptiger.service.API.CarService;
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

    @GetMapping("/")
    public String homePage(Model model){
        List<Car> carList = carService.findAllCar().stream().limit(6).collect(Collectors.toList());

        model.addAttribute("page","Home");
        model.addAttribute("carlist",carList);
        model.addAttribute("carphotoservice",carPhotoService);
        model.addAttribute("carinfoservice",carInfoService);
        return "user/index";
    }

    @GetMapping("/aboutus")
    public String aboutusPage(){
        return "user/aboutus";
    }
}
