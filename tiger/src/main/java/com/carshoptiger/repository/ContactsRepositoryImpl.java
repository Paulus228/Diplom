package com.carshoptiger.repository;

import com.carshoptiger.domain.Contacts;
import lombok.AllArgsConstructor;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;

@AllArgsConstructor
public class ContactsRepositoryImpl implements ContactsRepository{

    private final JdbcTemplate databaseMysql;

    @Override
    public boolean savecontact(Contacts contact) {
        return databaseMysql.update("insert into contacts(id, fullname, email, subject, message, date_send) " +
                "values(?,?,?,?,?,?)",contact.getId(),contact.getFullname(),
                contact.getEmail(),contact.getMessage(),contact.getDate_send())>0;
    }

    @Override
    public boolean deletecontact(Long id) {
        return databaseMysql.update("delete contacts from contacts where id=?",id)>0;
    }

    @Override
    public List<Contacts> findAllContacts() {
        return databaseMysql.query("select * from contacts", new BeanPropertyRowMapper<>(Contacts.class));
    }
}
