package com.carshoptiger.service.API;


public interface MailSender {
    void send(String emailTo,String subject, String message);
}
