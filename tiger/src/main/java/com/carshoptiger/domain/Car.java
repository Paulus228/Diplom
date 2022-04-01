package com.carshoptiger.domain;

import lombok.*;

import java.sql.Date;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@EqualsAndHashCode
public class Car {
    private Long id;
    private String name;
    private Float price;
    private Date date_add;
    private Integer count_buy;
    private String description;
}
