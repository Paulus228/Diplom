package com.carshoptiger.util.validators;

import com.carshoptiger.domain.Order;

public class OrderValidator {
    public static boolean OrderValidation(Order order){
        return (!order.getName().isEmpty() && order.getName().length()>=5 && order.getName().length()<=45)
                &&(!order.getSoname().isEmpty() && order.getSoname().length()>=5 && order.getSoname().length()<=45)
                &&(!order.getFaname().isEmpty() && order.getFaname().length()>=5 && order.getFaname().length()<=45)
                &&(!order.getPriceorder().isEmpty())
                &&(!order.getCountry().isEmpty() && order.getCountry().length()>=4 && order.getCountry().length()<=35)
                &&(!order.getCity().isEmpty() && order.getCity().length()>=5 && order.getCity().length()<=40)
                &&(!order.getAddress().isEmpty() && order.getAddress().length()>=20 && order.getAddress().length()<=255)
                &&(!order.getContactphone().isEmpty() && order.getContactphone().length()>=10 && order.getContactphone().length()<=25)
                &&(!order.getCommentorder().isEmpty() && order.getCommentorder().length()>=10 && order.getCommentorder().length()<=255);
    }
}
