package com.carshoptiger.service.Implementation;

import com.carshoptiger.domain.User;
import com.carshoptiger.repository.API.UserRepository;
import com.carshoptiger.service.API.BasketService;
import com.carshoptiger.service.API.UserService;
import com.carshoptiger.util.validators.UserValidator;
import org.springframework.beans.factory.annotation.Autowired;

import java.sql.Date;
import java.util.List;


public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private BasketService basketService;

    @Override
    public boolean saveuser(User user) {
        boolean result_save;
        User userIsexists = userRepository.findUserByUsername(user.getUsername());
        if (userIsexists == null) {
            if (UserValidator.UserValidation(user)) {
                user.setDate_add(new Date(new java.util.Date().getTime()));
                result_save = userRepository.saveuser(user);
                basketService.InitBasket(userRepository.findUserByUsername(user.getUsername()).getId());
            } else {
                result_save = false;
            }
        } else {
            result_save = false;
        }
        return result_save;
    }

    @Override
    public boolean updateuser(User user) {
        boolean result_update;
        User userIsexists = userRepository.getuserbyid(user.getId());

        if (userIsexists != null) {
                 result_update = userRepository.updateuser(user);
        } else {
            result_update = false;
        }
        return result_update;
    }

    @Override
    public boolean deleteuser(User user) {
        boolean result_delete;
        User userIsexists = userRepository.getuserbyid(user.getId());

        if (userIsexists != null) {
            result_delete = userRepository.deleteuser(user);
        } else {
            result_delete = false;
        }
        return result_delete;
    }

    @Override
    public List<User> findAllUser() {
        return userRepository.findAllUser();
    }

    @Override
    public User findUserByUsername(String username) {
        if (username.equals("")) {
            return null;
        } else {
            return userRepository.findUserByUsername(username);
        }
    }

    @Override
    public User getuserbyid(Long id) {
        return userRepository.getuserbyid(id);
    }
}
