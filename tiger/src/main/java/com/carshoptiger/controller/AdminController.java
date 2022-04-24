package com.carshoptiger.controller;

import com.carshoptiger.domain.Car;
import com.carshoptiger.service.API.CarService;
import com.carshoptiger.service.API.OrderSerivce;
import com.carshoptiger.service.API.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

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
    public String caraddpage(Model model){
         return "admin/admin_add_car";
    }

    @PostMapping("/carlist/add")
    public String caradd(@RequestParam(name = "name")String name,
                         @RequestParam(name = "price")String price,
                         @RequestParam(name = "description")String description,
                         Model model){
        Car car_save = new Car();
        car_save.setName(name);
        car_save.setDescription(description);
        car_save.setPrice(Float.parseFloat(price.replace(',','.')));
        car_save.setCount_buy(0);

        boolean car_result_save = carService.savecar(car_save);

        if(car_result_save) {
            model.addAttribute("message_save_car","Car save success!");
            model.addAttribute("carlist",carService.findAllCar());
            return "redirect:/admin/carlist";
        }else{
            model.addAttribute("message_save_car","Car save not success! Try yet!");
            return "admin/admin_add_car";
        }
    }

    @GetMapping("/carlist/edit/{id}")
    public String careditpage(@PathVariable("id")String id, Model model){
        Car editcar = carService.getonecar(Long.valueOf(id));
        String editprice = editcar.getPrice().toString().replace('.',',');
        model.addAttribute("editcar",editcar);
        model.addAttribute("editprice",editprice);
        return "admin/admin_edit_car";
    }

    @PostMapping("/carlist/edit/{id}")
    public String caredit(@PathVariable("id")String id,
                          @RequestParam(name = "name")String name,
                          @RequestParam(name = "price")String price,
                          @RequestParam(name = "description")String description,
                          Model model){

        Car editcar = carService.getonecar(Long.valueOf(id));
        editcar.setName(name);
        editcar.setPrice(Float.parseFloat(price.replace(',','.')));
        editcar.setDescription(description);

        boolean car_edit_result = carService.updatecar(editcar);

        if(car_edit_result){
            model.addAttribute("message_edit_car","Car save success!");
            model.addAttribute("carlist",carService.findAllCar());
            return "admin/admin_list_of_car";
        }else{
            model.addAttribute("message_edit_car","Car save not success! Try yet!");
            return "admin/admin_edit_car";
        }
    }

    @GetMapping("/carlist/delete/{id}")
    public String carremove(@PathVariable("id")String id){

        boolean car_delete_result = carService.deletecar(Long.valueOf(id));

        return "redirect:/admin/carlist";
    }
}
