package com.carshoptiger.service.API;

import com.carshoptiger.domain.User;
import org.springframework.security.core.userdetails.UserDetailsService;

import java.util.List;

public interface UserService extends UserDetailsService {
    boolean saveuser(User user);
    boolean updateuser(User user);
    boolean deleteuser(User user);
    List<User> findAllUser();
    User findUserByUsername(String username,String email);
    User getuserbyid(Long id);
}
