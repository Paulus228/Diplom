package com.carshoptiger.controller;

import com.carshoptiger.service.API.CarService;
import com.carshoptiger.service.API.OrderSerivce;
import com.carshoptiger.service.API.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.stream.Collectors;

@Controller
@RequestMapping("/admin")
public class AdminController {

    @Autowired
    private UserService userService;

    @Autowired
    private OrderSerivce orderSerivce;

    @Autowired
    private CarService carService;

    @GetMapping("/")
    public String adminhome(Model model){

        var ref = new Object() {
            float summa_all_order = 0;
        };

        orderSerivce.findAllOrder().forEach(o1-> ref.summa_all_order +=carService.getonecar(o1.getId_car()).getPrice());

        model.addAttribute("visitor",userService.findAllUser().size());
        model.addAttribute("orderscount",orderSerivce.findAllOrder().size());
        model.addAttribute("summa",ref.summa_all_order);
        model.addAttribute("sales", (int) orderSerivce.findAllOrder().stream().filter(o1 -> o1.getStatus_order().equals("sales")).count());
        model.addAttribute("latestorder",orderSerivce.findAllOrder().stream().limit(9).collect(Collectors.toList()));
        model.addAttribute("carservice",carService);
        return "admin/admin_home";
    }

    @GetMapping("/carlist")
    public String carlist(Model model){
        model.addAttribute("carlist",carService.findAllCar());
        return "admin/admin_list_of_car";
    }

    @GetMapping("/carlist/add")
    public String caraddpage(){
        return "admin_add_car";
    }
}
