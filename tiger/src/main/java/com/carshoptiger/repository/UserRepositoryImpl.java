package com.carshoptiger.repository;

import com.carshoptiger.domain.User;
import com.carshoptiger.util.exception.UserNotFound;
import lombok.AllArgsConstructor;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;

@AllArgsConstructor
public final class UserRepositoryImpl implements UserRepository {

    private final JdbcTemplate databaseMysql;

    @Override
    public boolean saveuser(User user) {
        return databaseMysql.update("insert into user(id, name, soname, username, password, roles, activationcode, email)values(?,?,?,?,?,?,?,?)",
                user.getId(), user.getName(), user.getSoname(), user.getUsername(), user.getPassword(), user.getRoles().name(), user.getActivationcode(), user.getEmail()) > 0;
    }

    @Override
    public boolean updateuser(User user) {
        return databaseMysql.update("update user set name=?,soname=?,username=?,password=?,roles=?,email=? where id=",
                user.getName(), user.getSoname(), user.getUsername(), user.getPassword(), user.getRoles().name(), user.getEmail(), user.getId()) > 0;
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
    public User findUserByUsername(String username) {
        String findname = "%" + username + "%";
        try {
            return databaseMysql.queryForObject("select * from user where username=?", new BeanPropertyRowMapper<>(User.class), findname);
        } catch (UserNotFound userNotFound) {
            return null;
        }
    }

    @Override
    public User getuserbyid(Long id) {
        try {
            return databaseMysql.queryForObject("select * from user where id =?", new BeanPropertyRowMapper<>(User.class), id);
        }catch (UserNotFound userNotFound){
            return null;
        }
    }
}
