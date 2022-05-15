package com.carshoptiger.controller;

import com.carshoptiger.domain.Basket;
import com.carshoptiger.service.API.BasketService;
import com.carshoptiger.service.API.CarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.sql.Date;

@Controller
@RequestMapping("/basket")
public class BasketController {

    @Autowired
    private BasketService basketService;

    @Autowired
    private CarService carService;

    @GetMapping("/{id_user}")
    public String basketUser(@PathVariable("id_user")String id_user, Model model){
        model.addAttribute("basketlist",basketService.findAllByBasketId(Long.valueOf(id_user)));
        model.addAttribute("carservice",carService);
        return "user/basket";
    }

    @GetMapping("/add/{id_car}/{id_user}")
    public String addCarToBasket(@PathVariable("id_car")String car,
                                 @PathVariable("id_user")String id_user){
        Basket basket = new Basket();
        basket.setId_car(Long.valueOf(car));
        basket.setId_basket_user(Long.valueOf(id_user));
        basket.setDate_add(new Date(new java.util.Date().getTime()));

        basketService.save(basket,Long.valueOf(id_user));
        return "redirect:/basket/"+id_user;
    }

    @GetMapping("/delete/{id_car}/{id_user}/{id}")
    public String deleteCarFromBasket(@PathVariable("id_car")String car,
                                      @PathVariable("id_user")String id_user,
                                      @PathVariable("id")String id){

        Basket basket = new Basket();
        basket.setId(Long.valueOf(id));
        basket.setId_car(Long.valueOf(car));
        basket.setId_basket_user(Long.valueOf(id_user));

        basketService.delete(basket);

        return "redirect:/basket/"+id_user;
    }

}
