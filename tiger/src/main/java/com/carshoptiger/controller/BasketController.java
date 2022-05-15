package com.carshoptiger.controller;

import com.carshoptiger.domain.Basket;
import com.carshoptiger.domain.Order;
import com.carshoptiger.service.API.BasketService;
import com.carshoptiger.service.API.CarService;
import com.carshoptiger.service.API.OrderSerivce;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.sql.Date;

@Controller
@RequestMapping("/basket")
public class BasketController {

    @Autowired
    private BasketService basketService;

    @Autowired
    private CarService carService;

    @Autowired
    private OrderSerivce orderSerivce;

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

    @GetMapping("/order/{id_car}/{id}")
    public String orderCar(@PathVariable("id_car")String id_car,
                           @PathVariable("id")String id
            ,Model model){
        model.addAttribute("id_car",id_car);
        model.addAttribute("id",id);
        model.addAttribute("carService",carService);
         return "user/order";
    }

    @PostMapping("/order/{id_car}/{id_user}/{id}")
    public String orderCar(@PathVariable("id_car")String id_car,
                           @PathVariable("id")String id,
                           @PathVariable("id_user")String id_user,
                           @RequestParam("name")String name,
                           @RequestParam("soname")String soname,
                           @RequestParam("faname")String faname,
                           @RequestParam("priceorder")String priceorder,
                           @RequestParam("country")String country,
                           @RequestParam("city")String city,
                           @RequestParam("address")String address,
                           @RequestParam("contactphone")String contactphone,
                           @RequestParam("commentorder")String commentorder){

        Basket basket = new Basket();
        basket.setId(Long.valueOf(id));
        basket.setId_car(Long.valueOf(id_car));
        basket.setId_basket_user(Long.valueOf(id_user));

        Order order = new Order();
        order.setName(name);
        order.setSoname(soname);
        order.setFaname(faname);
        order.setPriceorder(priceorder);
        order.setCountry(country);
        order.setCity(city);
        order.setAddress(address);
        order.setContactphone(contactphone);
        order.setCommentorder(commentorder);
        order.setDate_order(new Date(new java.util.Date().getTime()));
        order.setStatus_order("In process");
        order.setId_car(Long.valueOf(id_car));

        basketService.delete(basket);
        boolean saveorder = orderSerivce.saveorder(order);

        System.out.println("ORDER - " + saveorder);

        return "redirect:/basket/"+id_user;
    }

}
