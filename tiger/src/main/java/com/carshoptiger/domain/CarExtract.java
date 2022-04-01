package com.carshoptiger.domain;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@EqualsAndHashCode
public class CarExtract {
    private Long id;
    private Long id_car;
    private String extract;
}
