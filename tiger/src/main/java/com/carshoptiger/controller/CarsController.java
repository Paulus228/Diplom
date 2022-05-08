package com.carshoptiger.controller;

import com.carshoptiger.service.API.CarExtractService;
import com.carshoptiger.service.API.CarInfoService;
import com.carshoptiger.service.API.CarPhotoService;
import com.carshoptiger.service.API.CarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/cars")
public class CarsController {

    @Autowired
    private CarService carService;

    @Autowired
    private CarPhotoService carPhotoService;

    @Autowired
    private CarInfoService carInfoService;

    @Autowired
    private CarExtractService carExtractService;

    @GetMapping("/all")
    public String carlist(Model model){
        model.addAttribute("carlist",carService.findAllCar());
        model.addAttribute("carphotoservice",carPhotoService);
        model.addAttribute("carinfoservice",carInfoService);
        return "user/carlist";
    }

    @GetMapping("/{id}")
    public String cardetail(Model model, @PathVariable("id")String id){
        model.addAttribute("car",carService.getonecar(Long.valueOf(id)));
        model.addAttribute("carphotoservice",carPhotoService);
        model.addAttribute("carinfoservice",carInfoService);
        model.addAttribute("carExtractService",carExtractService);
        return "user/carone";
    }

}
