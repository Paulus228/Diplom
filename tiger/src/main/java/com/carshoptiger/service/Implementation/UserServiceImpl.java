package com.carshoptiger.service.Implementation;

import com.carshoptiger.domain.User;
import com.carshoptiger.repository.API.UserRepository;
import com.carshoptiger.service.API.UserService;
import com.carshoptiger.util.validators.UserValidator;
import lombok.AllArgsConstructor;

import java.util.List;

@AllArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    @Override
    public boolean saveuser(User user) {
        boolean result_save;
        User userIsexists = userRepository.findUserByUsername(user.getUsername());
        if(userIsexists==null){
            if(UserValidator.UserValidation(user)){
                result_save = userRepository.saveuser(user);
            }else{
                result_save=false;
            }
        }else{
            result_save=false;
        }
        return result_save;
    }

    @Override
    public boolean updateuser(User user) {
        boolean result_update;
        User userIsexists = userRepository.getuserbyid(user.getId());

        if(userIsexists!=null){
            if(UserValidator.UserValidation(user)){
                result_update = userRepository.updateuser(user);
            }else{
                result_update = false;
            }
        }else{
            result_update = false;
        }
        return result_update;
    }

    @Override
    public boolean deleteuser(User user) {
        boolean result_delete;
        User userIsexists = userRepository.getuserbyid(user.getId());

        if(userIsexists!=null){
            if(UserValidator.UserValidation(user)){
                result_delete = userRepository.deleteuser(user);
            }else{
                result_delete = false;
            }
        }else{
            result_delete = false;
        }
        return result_delete;    }

    @Override
    public List<User> findAllUser() {
        return userRepository.findAllUser();
    }

    @Override
    public User findUserByUsername(String username) {
        if(username.equals("")){
           return null;
        }else {
            return userRepository.findUserByUsername(username);
        }
    }

    @Override
    public User getuserbyid(Long id) {
        return userRepository.getuserbyid(id);
    }
}
