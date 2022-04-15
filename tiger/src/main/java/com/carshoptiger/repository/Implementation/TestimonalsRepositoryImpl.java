package com.carshoptiger.repository.Implementation;

import com.carshoptiger.domain.Testimonals;
import com.carshoptiger.repository.API.TestimonalsRepository;
import lombok.AllArgsConstructor;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;

@AllArgsConstructor
public class TestimonalsRepositoryImpl implements TestimonalsRepository {

    private final JdbcTemplate databaseMysql;

    @Override
    public boolean savecontact(Testimonals testimonals) {
        return databaseMysql.update("insert into testimonals(id, fullname, message_testimonals, date_send) values(?,?,?,?)",
                testimonals.getId(),testimonals.getFullname(),testimonals.getMessage_testimonals(),testimonals.getDate_send())>0;
    }

    @Override
    public boolean deletecontact(Long id) {
        return databaseMysql.update("delete testimonals from testimonals where id=?",id)>0;
    }

    @Override
    public List<Testimonals> findAllContacts() {
        return databaseMysql.query("select * from testimonals",new BeanPropertyRowMapper<>(Testimonals.class));
    }
}
