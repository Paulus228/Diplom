package com.carshoptiger.domain;

import lombok.*;

import java.util.Set;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@EqualsAndHashCode
class User {
    private Long id;
    private String name;
    private String soname;
    private String username;
    private String password;
    private Set<Role> roles;
    private String email;
    private String activationcode;


}
