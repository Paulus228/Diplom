package com.carshoptiger.service.Implementation;

import com.carshoptiger.domain.Contacts;
import com.carshoptiger.repository.API.ContactsRepository;
import com.carshoptiger.service.API.ContactService;
import com.carshoptiger.util.validators.ContactValidator;
import lombok.AllArgsConstructor;

import java.sql.Date;
import java.util.List;

@AllArgsConstructor
public class ContactServiceImpl implements ContactService {

    private final ContactsRepository contactsRepository;

    @Override
    public boolean savecontact(Contacts contact) {
        boolean result_save;
        if(ContactValidator.ContactValidation(contact)){
            contact.setDate_send(new Date(new java.util.Date().getTime()));
            result_save = contactsRepository.savecontact(contact);
        }else{
            result_save = false;
        }
        return result_save;
    }

    @Override
    public boolean deletecontact(Long id) {
        boolean result_delete;
        Contacts contactIsexists = contactsRepository.findAllContacts().stream().filter((o1)->o1.getId().equals(id)).findAny().orElse(null);
        if(contactIsexists!=null){
            result_delete = contactsRepository.deletecontact(id);
        }else{
            result_delete=false;
        }
        return result_delete;
    }

    @Override
    public List<Contacts> findAllContacts() {
        return contactsRepository.findAllContacts();
    }
}
