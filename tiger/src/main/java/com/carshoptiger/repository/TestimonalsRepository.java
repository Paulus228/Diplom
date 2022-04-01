package com.carshoptiger.repository;

import com.carshoptiger.domain.Testimonals;

import java.util.List;

public interface TestimonalsRepository {
    boolean savecontact(Testimonals testimonals);
    boolean deletecontact(Long id);
    List<Testimonals> findAllContacts();
}
