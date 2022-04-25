package com.carshoptiger.service.Implementation;

import com.carshoptiger.domain.Car;
import com.carshoptiger.domain.Order;
import com.carshoptiger.repository.API.OrderRepository;
import com.carshoptiger.service.API.CarService;
import com.carshoptiger.service.API.OrderSerivce;
import com.carshoptiger.util.validators.OrderValidator;
import lombok.AllArgsConstructor;

import java.util.List;

@AllArgsConstructor
public class OrderServiceImpl implements OrderSerivce {

    private final OrderRepository orderRepository;

    private final CarService carService;

    @Override
    public boolean saveorder(Order order) {
        boolean result_save;
        Car carIsexists = carService.getonecar(order.getId_car());
        if(carIsexists!=null){
            if(OrderValidator.OrderValidation(order)){
                result_save = orderRepository.saveorder(order);
            }else{
                result_save = false;
            }
        }else{
            result_save = false;
        }
        return result_save;
    }

    @Override
    public boolean updateorder(Order order) {
        boolean result_update;
        Order orderIsexists = orderRepository.getorderbyid(order.getId());

        if(orderIsexists!=null){
                result_update = orderRepository.updateorder(order);
        }else{
            result_update = false;
        }
        return result_update;
    }

    @Override
    public boolean deleteorder(Order order) {
        boolean result_delete;
        Order orderIsexists = orderRepository.getorderbyid(order.getId());
        if(orderIsexists!=null){
            result_delete = orderRepository.deleteorder(order);
        }else{
            result_delete = false;
        }
        return result_delete;
    }

    @Override
    public List<Order> findAllOrder() {
        return orderRepository.findAllOrder();
    }

    @Override
    public Order getorderbyid(Long id_order) {
        return orderRepository.getorderbyid(id_order);
    }
}
