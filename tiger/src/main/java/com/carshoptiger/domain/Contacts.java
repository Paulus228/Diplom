package com.carshoptiger.domain;


import lombok.*;

import java.sql.Date;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@EqualsAndHashCode
public class Contacts {
    private Long id;
    private String fullname;
    private String email;
    private String subject;
    private String message;
    private Date date_send;
}
