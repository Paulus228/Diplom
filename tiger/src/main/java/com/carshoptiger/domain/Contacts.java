package com.carshoptiger.domain;


import lombok.*;

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

}
