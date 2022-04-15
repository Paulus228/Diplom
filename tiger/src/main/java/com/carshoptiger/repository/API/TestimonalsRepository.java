package com.carshoptiger.repository.API;

import com.carshoptiger.domain.Testimonals;

import java.util.List;

public interface TestimonalsRepository {
    boolean savecontact(Testimonals testimonals);
    boolean deletecontact(Long id);
    List<Testimonals> findAllContacts();
}
