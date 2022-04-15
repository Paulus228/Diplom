package com.carshoptiger.repository;

import com.carshoptiger.domain.Basket;

import java.util.List;

public interface BasketRepository {
    int save(Basket basket, Long id_user);
    int delete(Basket basket, Long id_user);
    List<Basket> findAllByBasketId(Long id_user);
    int InitBasket(Long id_user);
    int DestroyBasket(Long id_user);
}
