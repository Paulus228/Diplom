package com.carshoptiger.controller;

import com.carshoptiger.domain.Role;
import com.carshoptiger.domain.User;
import com.carshoptiger.service.API.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.sql.Date;

@Controller
@RequestMapping("/signup")
public class SignupController {

    @Autowired
    private UserService userService;

    @GetMapping("/")
    public String signUpPage(){
        return "user/signup";
    }

    @PostMapping("/save")
    public String signUpSave(@RequestParam("name")String name,
                             @RequestParam("soname")String soname,
                             @RequestParam("username")String username,
                             @RequestParam("password")String password,
                             @RequestParam("email")String email, Model model){

        User user = new User();
        user.setName(name);
        user.setSoname(soname);
        user.setUsername(username);
        user.setPassword(password);
        user.setEmail(email);
        user.setDate_add(new Date(new java.util.Date().getTime()));
        user.setRoles(Role.USER);

        boolean user_save = userService.saveuser(user);
        System.out.println("USER - " + user_save);
        if(user_save){
            model.addAttribute("message","Success sign up! Thank you!");
            return "redirect:/login";
        }else{
            model.addAttribute("message","User exists!");
            return "user/signup";
        }


    }
}
