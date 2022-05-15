package com.carshoptiger.controller;

import com.carshoptiger.domain.*;
import com.carshoptiger.service.API.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.sql.Date;
import java.util.stream.Collectors;

@Controller
@RequestMapping("/admin")
@PreAuthorize("hasAnyAuthority('ADMIN','MANAGER')")
public class AdminController {

    @Autowired
    private UserService userService;

    @Autowired
    private OrderSerivce orderSerivce;

    @Autowired
    private CarService carService;

    @Autowired
    private ContactService contactService;

    @Autowired
    private TestimonalsService testimonalsService;

    @Autowired
    private CarPhotoService carPhotoService;

    @Autowired
    private CarExtractService carExtractService;

    @Autowired
    private CarInfoService carInfoService;

    @GetMapping("/")
    public String adminhome(Model model) {

        var ref = new Object() {
            float summa_all_order = 0;
        };

        orderSerivce.findAllOrder().forEach(o1 -> ref.summa_all_order += carService.getonecar(o1.getId_car()).getPrice());

        model.addAttribute("visitor", userService.findAllUser().size());
        model.addAttribute("orderscount", orderSerivce.findAllOrder().size());
        model.addAttribute("summa", ref.summa_all_order);
        model.addAttribute("sales", (int) orderSerivce.findAllOrder().stream().filter(o1 -> o1.getStatus_order().equals("SALES")).count());
        model.addAttribute("latestorder", orderSerivce.findAllOrder().stream().limit(9).collect(Collectors.toList()));
        model.addAttribute("carservice", carService);
        return "admin/admin_home";
    }

    @GetMapping("/carlist")
    public String carlist(Model model) {
        model.addAttribute("carlist", carService.findAllCar());
        return "admin/admin_list_of_car";
    }

    @GetMapping("/carlist/add")
    public String caraddpage(Model model) {
        return "admin/admin_add_car";
    }

    @PostMapping("/carlist/add")
    public String caradd(@RequestParam(name = "name") String name,
                         @RequestParam(name = "price") String price,
                         @RequestParam(name = "description") String description,
                         Model model) {
        Car car_save = new Car();
        car_save.setName(name);
        car_save.setDescription(description);
        car_save.setPrice(Float.parseFloat(price.replace(',', '.')));
        car_save.setCount_buy(0);

        boolean car_result_save = carService.savecar(car_save);

        if (car_result_save) {
            model.addAttribute("message_save_car", "Car save success!");
            model.addAttribute("carlist", carService.findAllCar());
            return "redirect:/admin/carlist";
        } else {
            model.addAttribute("message_save_car", "Car save not success! Try yet!");
            return "admin/admin_add_car";
        }
    }

    @GetMapping("/carlist/edit/{id}")
    public String careditpage(@PathVariable("id") String id, Model model) {
        Car editcar = carService.getonecar(Long.valueOf(id));
        String editprice = editcar.getPrice().toString().replace('.', ',');
        model.addAttribute("editcar", editcar);
        model.addAttribute("editprice", editprice);
        return "admin/admin_edit_car";
    }

    @PostMapping("/carlist/edit/{id}")
    public String caredit(@PathVariable("id") String id,
                          @RequestParam(name = "name") String name,
                          @RequestParam(name = "price") String price,
                          @RequestParam(name = "description") String description,
                          Model model) {

        Car editcar = carService.getonecar(Long.valueOf(id));
        editcar.setName(name);
        editcar.setPrice(Float.parseFloat(price.replace(',', '.')));
        editcar.setDescription(description);

        boolean car_edit_result = carService.updatecar(editcar);

        if (car_edit_result) {
            String editprice = editcar.getPrice().toString().replace('.', ',');
            model.addAttribute("editcar", editcar);
            model.addAttribute("editprice", editprice);
            model.addAttribute("message_edit_car", "Car edit success!");
            model.addAttribute("carlist", carService.findAllCar());
            return "redirect:/admin/carlist";
        } else {
            model.addAttribute("message_edit_car", "Car edit not success! Try yet!");
            model.addAttribute("editcar",editcar);
            return "admin/admin_edit_car";
        }
    }

    @GetMapping("/carlist/delete/{id}")
    public String carremove(@PathVariable("id") String id) {
        carService.deletecar(Long.valueOf(id));
        return "redirect:/admin/carlist";
    }

    @GetMapping("/carlist/carphotos/{id}")
    public String carphotolist(@PathVariable("id")String id,
                               Model model){
        model.addAttribute("carid",id);
        model.addAttribute("carphotolist",carPhotoService.findallByidCar(Long.valueOf(id)));
        return "admin/admin_list_of_car_photos";
    }

    @GetMapping("/carlist/carphotos/add/{id}")
    public String addcarphotopage(@PathVariable("id")String id,
                                  Model model){
        model.addAttribute("carid",id);
        return "admin/admin_add_car_photo";
    }

    @PostMapping("/carlist/carphotos/add/{id}")
    public String addcarphoto(@PathVariable("id")String id,
                              @RequestParam(name = "photo_url")String photo_url){
        CarPhoto carPhoto = new CarPhoto();
        carPhoto.setId_car(Long.valueOf(id));
        carPhoto.setPhotourl(photo_url);

        carPhotoService.savecarphoto(carPhoto);
        return "redirect:/admin/carlist/carphotos/"+id;
    }

    @GetMapping("/carlist/carphotos/remove/{id}/{idcar}")
    public String removecarphoto(@PathVariable("id")String id,@PathVariable("idcar")String idcar){
        carPhotoService.deletecarphoto(Long.valueOf(id));
        return "redirect:/admin/carlist/carphotos/"+idcar;
    }

    @GetMapping("/carlist/extracts/{id}")
    public String carextract(@PathVariable("id")String id,Model model){
        model.addAttribute("carextractlist", carExtractService.findcarextractbycarid(Long.valueOf(id)));
        model.addAttribute("carservice",carService);
        model.addAttribute("carid",id);
        return "admin/admin_list_of_car_extract";
    }

    @GetMapping("/carlist/extracts/add/{id}")
    public String carextractaddpage(@PathVariable("id")String id, Model model){
        model.addAttribute("carid",id);
        return "admin/admin_add_car_extract";
    }

    @PostMapping("/carlist/extracts/add/{id}")
    public String carextractadd(@PathVariable("id")String carid,
                                @RequestParam(name="extract")String extract){
        CarExtract carExtract = new CarExtract();
        carExtract.setExtract(extract);
        carExtract.setId_car(Long.valueOf(carid));
        carExtractService.savecarextract(carExtract);

        return "redirect:/admin/carlist/extracts/"+carid;
    }

    @GetMapping("/carlist/extacts/remove/{id}/{idcar}")
    public String removecarextract(@PathVariable("id")String id,
                                   @PathVariable("idcar")String carid){

        carExtractService.deletecarextract(Long.valueOf(id));

        return "redirect:/admin/carlist/extracts/"+carid;
    }

    @GetMapping("/carlist/carinfo/{id}")
    public String carinfo(@PathVariable("id")String id,
                          Model model){
        CarInfo carInfo = carInfoService.getonecarinfobycarid(Long.valueOf(id));
        model.addAttribute("carinfo", carInfo);
        model.addAttribute("idcar",id);
        return "admin/admin_car_info";
    }

    @GetMapping("/carlist/carinfo/add/{id}")
    public String carinfoaddpage(@PathVariable("id")String id, Model model){
        model.addAttribute("idcar",id);
        return "admin/admin_add_car_info";
    }

    @PostMapping("/carlist/carinfo/add/{id}")
    public String carinfoadd(@PathVariable("id")String id, Model model,
                             @RequestParam("type")String type,
                             @RequestParam("make")String make,
                             @RequestParam("models")String models,
                             @RequestParam("mileage")String mileage,
                             @RequestParam("fuel")String fuel,
                             @RequestParam("enginesize")String enginesize,
                             @RequestParam("power")String power,
                             @RequestParam("gearbox")String gearbox,
                             @RequestParam("numberseat")String numberseat,
                             @RequestParam("doors")String doors,
                             @RequestParam("color")String color) {
        model.addAttribute("idcar", id);
        CarInfo carInfo = new CarInfo();
        carInfo.setId_car(Long.valueOf(id));
        carInfo.setType(type);
        carInfo.setMake(make);
        carInfo.setModel(models);
        carInfo.setFirst_reg(new Date(new java.util.Date().getTime()));
        carInfo.setMileage(Integer.valueOf(mileage));
        carInfo.setFuel(fuel);
        carInfo.setEnginesize(Integer.valueOf(enginesize));
        carInfo.setPower(Integer.valueOf(power));
        carInfo.setGearbox(gearbox);
        carInfo.setNumberseat(Integer.valueOf(numberseat));
        carInfo.setDoors(doors);
        carInfo.setColor(color);

        carInfoService.savecarinfo(carInfo);
        return "redirect:/admin/carlist/carinfo/" + id;
    }

    @GetMapping("/contactlist/")
    public String contactlist(Model model) {
        model.addAttribute("contactlist", contactService.findAllContacts());
        return "admin/admin_list_of_contacts";
    }

    @GetMapping("/contactlist/remove/{id}")
    public String contactremove(@PathVariable("id") String id) {
        contactService.deletecontact(Long.valueOf(id));
        return "redirect:/admin/contactlist/";
    }

    @GetMapping("/testimonalslist/")
    public String testimonalslist(Model model) {
        model.addAttribute("testimonalslist", testimonalsService.findAllTestimonals());
        return "admin/admin_list_of_testimonals";
    }

    @GetMapping("/testimonalslist/remove/{id}")
    public String testimonalsremove(@PathVariable("id") String id) {
        testimonalsService.deletetestimonals(Long.valueOf(id));
        return "redirect:/admin/testimonalslist/";
    }

    @GetMapping("/userlist/")
    public String userlist(Model model) {
        model.addAttribute("userlist", userService.findAllUser());
        return "admin/admin_list_of_user";
    }

    @GetMapping("/userlist/remove/{id}")
    public String userremove(@PathVariable("id") String id) {
        userService.deleteuser(userService.getuserbyid(Long.valueOf(id)));
        return "redirect:/admin/userlist/";
    }

    @GetMapping("/userlist/update/{id}")
    public String userupdatepage(@PathVariable("id") String id, Model model) {
        model.addAttribute("updateuser", userService.getuserbyid(Long.valueOf(id)));
        return "admin/admin_edit_user";
    }

    @PostMapping("/userlist/update/{id}")
    public String userupdate(@PathVariable("id") String id, @RequestParam(name = "role") String role) {
        User user_update = userService.getuserbyid(Long.valueOf(id));
        user_update.setRoles(Role.valueOf(role));
        userService.updateuser(user_update);
        return "redirect:/admin/userlist/";
    }

    @GetMapping("/orderlist/")
    public String orderlist(Model model) {
        model.addAttribute("orderlist", orderSerivce.findAllOrder());
        model.addAttribute("carservice", carService);
        return "admin/admin_list_of_orders";
    }

    @GetMapping("/orderlist/remove/{id}")
    public String orderremove(@PathVariable("id") String id, Model model) {
        orderSerivce.deleteorder(orderSerivce.getorderbyid(Long.valueOf(id)));
        return "redirect:/admin/orderlist/";
    }

    @GetMapping("/orderlist/update/{id}")
    public String orderupdatepage(@PathVariable(name = "id") String id, Model model) {
        model.addAttribute("orderupdate", orderSerivce.getorderbyid(Long.valueOf(id)));
        return "admin/admin_edit_order";
    }

    @PostMapping("/orderlist/update/{id}")
    public String orderupdate(@PathVariable("id") String id,
                              @RequestParam("country") String country,
                              @RequestParam("city") String city,
                              @RequestParam("address") String address,
                              @RequestParam("contactphone") String contactphone,
                              @RequestParam("order_status") String orderstatus) {

        Order orderupdate = orderSerivce.getorderbyid(Long.valueOf(id));
        orderupdate.setCity(city);
        orderupdate.setCountry(country);
        orderupdate.setAddress(address);
        orderupdate.setContactphone(contactphone);
        orderupdate.setStatus_order(orderstatus);

        orderSerivce.updateorder(orderupdate);

        return "redirect:/admin/orderlist/";
    }

    @GetMapping("/orderlist/one/{id}")
    public String orderonepage(@PathVariable("id")String id, Model model){
        model.addAttribute("orderone",orderSerivce.getorderbyid(Long.valueOf(id)));
        return "admin/admin_one_order";
    }

    @GetMapping("/help")
    public String adminhelp(){
        return "admin/admin_help";
    }


}
