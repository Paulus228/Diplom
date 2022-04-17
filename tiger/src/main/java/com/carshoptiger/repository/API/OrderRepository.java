package com.carshoptiger.repository.API;

import com.carshoptiger.domain.Order;

import java.util.List;

public interface OrderRepository {
    boolean saveorder(Order order);
    boolean updateorder(Order order);
    boolean deleteorder(Order order);
    List<Order>findAllOrder();
    Order getorderbyid(Long id_order);
}
