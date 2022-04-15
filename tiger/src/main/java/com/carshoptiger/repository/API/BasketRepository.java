package com.carshoptiger.repository.API;

import com.carshoptiger.domain.Basket;

import java.util.List;

public interface BasketRepository {
    boolean save(Basket basket, Long id_user);
    boolean delete(Basket basket, Long id_user);
    List<Basket> findAllByBasketId(Long id_user);
    boolean InitBasket(Long id_user);
    boolean DestroyBasket(Long id_user);
}
