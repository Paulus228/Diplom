package com.carshoptiger.domain;

import lombok.*;

import java.sql.Date;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@EqualsAndHashCode
public class Order {
    private Long id;
    private Long id_car;
    private String name;
    private String soname;
    private String faname;
    private String priceorder;
    private String country;
    private String city;
    private String address;
    private String contactphone;
    private String commentorder;
    private Date date_order;
}
