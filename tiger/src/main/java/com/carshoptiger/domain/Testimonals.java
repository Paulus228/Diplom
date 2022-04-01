package com.carshoptiger.domain;

import lombok.*;

import java.sql.Date;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@EqualsAndHashCode
public class Testimonals {
    private Long id;
    private String fullname;
    private String message_testimonals;
    private Date date_send;
}
