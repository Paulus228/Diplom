package com.carshoptiger.controller;

import com.carshoptiger.domain.Contacts;
import com.carshoptiger.service.API.ContactService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@RequestMapping("/contact")
@Controller
public class ContactUsController {
    @Autowired
    private ContactService contactService;

    @GetMapping("/")
    public String contactusPage(){
        return "user/contactus";
    }

    @PostMapping("/send")
    public String contactusSend(@RequestParam(name = "fullname")String fullname,
                                @RequestParam(name = "email")String email,
                                @RequestParam(name = "subject")String subject,
                                @RequestParam(name = "message")String message){
        Contacts contacts_save = new Contacts();
        contacts_save.setFullname(fullname);
        contacts_save.setEmail(email);
        contacts_save.setSubject(subject);
        contacts_save.setMessage(message);

        contactService.savecontact(contacts_save);

        return "redirect:/";
    }


}
