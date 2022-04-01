package com.carshoptiger.domain;

import lombok.*;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@EqualsAndHashCode
public class User {
    private Long id;
    private String name;
    private String soname;
    private String username;
    private String password;
    private Role roles;
    private String email;
    private String activationcode;


}
