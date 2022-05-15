package com.carshoptiger.domain;

import lombok.*;

import java.sql.Date;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@EqualsAndHashCode
public class Basket {
    private Long id;
    private Long id_basket_user;
    private Long id_car;
    private Date date_add;
}
