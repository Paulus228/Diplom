package com.carshoptiger.service.API;

import com.carshoptiger.domain.Contacts;

import java.util.List;

public interface ContactService {
    boolean savecontact(Contacts contact);
    boolean deletecontact(Long id);
    List<Contacts> findAllContacts();
}
