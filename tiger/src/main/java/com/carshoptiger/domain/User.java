package com.carshoptiger.domain;

import lombok.*;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.sql.Date;
import java.util.Collection;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@EqualsAndHashCode
public class User implements UserDetails {
    private Long id;
    private String name;
    private String soname;
    private String username;
    private String password;
    private Role roles;
    private String email;
    private String activationcode;
    private Date date_add;

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return null;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }

    public boolean isAdmin(){
        return this.roles==Role.ADMIN || this.roles==Role.MANAGER;
    }

    public boolean isManager(){
        return this.roles==Role.MANAGER;
    }
}
