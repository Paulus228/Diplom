package com.carshoptiger.repository;

import com.carshoptiger.domain.Contacts;

import java.util.List;

public interface ContactsRepository {
    boolean savecontact(Contacts contact);
    boolean deletecontact(Long id);
    List<Contacts>findAllContacts();
}
