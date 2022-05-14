package com.carshoptiger.service.Implementation;

import com.carshoptiger.domain.User;
import com.carshoptiger.repository.API.UserRepository;
import com.carshoptiger.service.API.BasketService;
import com.carshoptiger.service.API.MailSender;
import com.carshoptiger.service.API.UserService;
import com.carshoptiger.util.validators.UserValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.util.StringUtils;

import java.sql.Date;
import java.util.List;
import java.util.Optional;
import java.util.UUID;


public class UserServiceImpl implements UserService {
    @Value("${hostname}")
    private String hostname;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private MailSender mailSender;

    @Autowired
    private BasketService basketService;

    @Autowired
    private BCryptPasswordEncoder passwordEncoder;

    @Override
    public boolean saveuser(User user) {
        boolean result_save;
        Optional<User> userfromdb = Optional.ofNullable(userRepository.findUserByUsername(user.getUsername(),user.getEmail()));
        if (!userfromdb.isPresent()) {
            if (UserValidator.UserValidation(user)) {

                user.setDate_add(new Date(new java.util.Date().getTime()));
                user.setPassword(passwordEncoder.encode(user.getPassword()));
                result_save = userRepository.saveuser(user);
                basketService.InitBasket(userRepository.findUserByUsername(user.getUsername(),user.getEmail()).getId());
                sendMessage(user,UUID.randomUUID().toString());
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
    public User findUserByUsername(String username,String email) {
        if (username.equals("")) {
            return null;
        } else {
            return userRepository.findUserByUsername(username,email);
        }
    }

    @Override
    public User getuserbyid(Long id) {
        return userRepository.getuserbyid(id);
    }

    @Override
    public boolean activateUser(String code,String username) {
        User user = userRepository.findUserByUsername(username,"");

        if (user == null) {
            return false;
        }

        user.setActivationcode(code);

        boolean result = userRepository.updateuser(user);

        System.out.println("SET ACTIVE - " + code);

        return true;
    }

    @Override
    public void sendMessage(User user,String code) {
        if (!StringUtils.isEmpty(user.getEmail())) {
            String message = String.format(
                    "Hello, %s! \n" +
                            "Welcome to Car dealer tiger. Please, visit next link: http://%s/signup/activate/%s/%s",
                    user.getUsername(),
                    hostname,
                    code,
                    user.getUsername()
            );
            mailSender.send(user.getEmail(), "Activation code", message);
        }
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<User> optionalUser = Optional.ofNullable
                (userRepository.findUserByUsername(username,""));
        if(optionalUser.isPresent()){
            return optionalUser.get();
        }else{
            throw new UsernameNotFoundException("User with username not found");
        }
    }
}
