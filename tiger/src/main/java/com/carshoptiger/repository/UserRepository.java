package com.carshoptiger.repository;

import com.carshoptiger.domain.User;

import java.util.List;

public interface UserRepository {
    boolean saveuser(User user);
    boolean updateuser(User user);
    boolean deleteuser(User user);
    List<User>findAllUser();
    User findUserByUsername(String username);
    User getuserbyid(Long id);
}
