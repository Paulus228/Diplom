package com.carshoptiger.service.API;

import com.carshoptiger.domain.Basket;

import java.util.List;

public interface BasketService {
    boolean save(Basket basket, Long id_user);
    boolean delete(Basket basket);
    List<Basket> findAllByBasketId(Long id_user);
    boolean InitBasket(Long id_user);
    boolean DestroyBasket(Long id_user);

}
