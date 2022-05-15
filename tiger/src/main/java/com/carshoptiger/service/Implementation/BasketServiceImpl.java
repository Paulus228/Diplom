package com.carshoptiger.service.Implementation;

import com.carshoptiger.domain.Basket;
import com.carshoptiger.domain.Car;
import com.carshoptiger.domain.User;
import com.carshoptiger.repository.API.BasketRepository;
import com.carshoptiger.service.API.BasketService;
import com.carshoptiger.service.API.CarService;
import com.carshoptiger.service.API.UserService;
import org.springframework.beans.factory.annotation.Autowired;

import java.sql.Date;
import java.util.List;


public class BasketServiceImpl implements BasketService {

    @Autowired
    private  BasketRepository basketRepository;

    @Autowired
    private UserService userService;

    @Autowired
    private CarService carService;

    @Override
    public boolean save(Basket basket, Long id_user) {
        boolean result_save;
        User userIsExists = userService.getuserbyid(id_user);
        Car carIsExists = carService.getonecar(basket.getId_car());

        if (userIsExists != null && carIsExists != null) {
            basket.setDate_add(new Date(new java.util.Date().getTime()));
            result_save = basketRepository.save(basket, id_user);
        } else {
            result_save = false;
        }
        return result_save;
    }

    @Override
    public boolean delete(Basket basket) {
        boolean result_delete;
        User userIsExists = userService.getuserbyid(basket.getId_basket_user());
        Car carIsExists = carService.getonecar(basket.getId_car());

        if (userIsExists != null && carIsExists != null) {
            result_delete = basketRepository.delete(basket.getId());
        } else {
            result_delete = false;
        }
        return result_delete;
    }

    @Override
    public List<Basket> findAllByBasketId(Long id_user) {
        User userIsExists = userService.getuserbyid(id_user);

        if (userIsExists != null) {
            return basketRepository.findAllByBasketId(id_user);
        } else {
            return null;
        }
    }

    @Override
    public boolean InitBasket(Long id_user) {
        boolean result_init;
        User userIsExists = userService.getuserbyid(id_user);

        if (userIsExists != null) {
            result_init = basketRepository.InitBasket(id_user);
        } else {
            result_init = false;
        }
        return result_init;
    }

    @Override
    public boolean DestroyBasket(Long id_user) {
        boolean result_destroy;
        User userIsExists = userService.getuserbyid(id_user);
        if (userIsExists != null) {
            result_destroy = basketRepository.DestroyBasket(id_user);
        } else {
            result_destroy = false;
        }
        return result_destroy;
    }
}
