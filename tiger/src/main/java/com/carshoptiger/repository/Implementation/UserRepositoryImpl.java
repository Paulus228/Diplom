package com.carshoptiger.repository.Implementation;

import com.carshoptiger.domain.User;
import com.carshoptiger.repository.API.UserRepository;
import com.carshoptiger.util.exception.UserNotFoundException;
import lombok.AllArgsConstructor;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;

@AllArgsConstructor
public final class UserRepositoryImpl implements UserRepository {

    private final JdbcTemplate databaseMysql;

    @Override
    public boolean saveuser(User user) {
        return databaseMysql.update("insert into user(id, name, soname, username, password, roles, activationcode, email,date_add)values(?,?,?,?,?,?,?,?,?)",
                user.getId(), user.getName(), user.getSoname(), user.getUsername(), user.getPassword(), user.getRoles().name(), user.getActivationcode(), user.getEmail(),user.getDate_add()) > 0;
    }

    @Override
    public boolean updateuser(User user) {
        return databaseMysql.update("update user set name=?,soname=?,username=?,password=?,roles=?,email=?,activationcode=? where id=?",
                user.getName(), user.getSoname(), user.getUsername(), user.getPassword(), user.getRoles().name(), user.getEmail(), user.getActivationcode(),user.getId()) > 0;
    }

    @Override
    public boolean deleteuser(User user) {
        return databaseMysql.update("delete user from user where id=?", user.getId()) > 0;
    }

    @Override
    public List<User> findAllUser() {
        return databaseMysql.query("select * from user", new BeanPropertyRowMapper<>(User.class));
    }

    @Override
    public User findUserByUsername(String username,String email) {
        try {
            return databaseMysql.queryForObject("select * from user where username=? or email=?",
                    new BeanPropertyRowMapper<>(User.class), username,email);
        } catch (EmptyResultDataAccessException userNotFoundException) {
            return null;
        }
    }

    @Override
    public User getuserbyid(Long id) {
        try {
            return databaseMysql.queryForObject("select * from user where id =?", new BeanPropertyRowMapper<>(User.class), id);
        }catch (UserNotFoundException userNotFoundException){
            return null;
        }
    }

    @Override
    public User findUserByActivationCode(String activationCode) {
        try {
            return databaseMysql.queryForObject("select * from user where activationcode =?", new BeanPropertyRowMapper<>(User.class), activationCode);
        }catch (UserNotFoundException userNotFoundException){
            return null;
        }
    }
}
