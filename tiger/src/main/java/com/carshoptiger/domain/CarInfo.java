package com.carshoptiger.domain;

import lombok.*;

import java.sql.Date;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@EqualsAndHashCode
public class CarInfo {
    private Long id;
    private Long id_car;
    private String type;
    private String make;
    private Date first_reg;
    private Integer mileage;
    private String fuel;
    private Integer enginesize;
    private Integer power;
    private String gearbox;
    private Integer numberseat;
    private String doors;
    private String color;
}
