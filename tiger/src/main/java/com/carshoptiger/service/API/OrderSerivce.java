package com.carshoptiger.service.API;

import com.carshoptiger.domain.Order;

import java.util.List;

public interface OrderSerivce {
    boolean saveorder(Order order);
    boolean updateorder(Order order);
    boolean deleteorder(Order order);
    List<Order> findAllOrder();
    Order getorderbyid(Long id_order);
}
