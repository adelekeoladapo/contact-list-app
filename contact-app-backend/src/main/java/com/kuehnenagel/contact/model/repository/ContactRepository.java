package com.kuehnenagel.contact.model.repository;

import com.kuehnenagel.contact.model.Contact;
import io.ebean.PagedList;

public interface ContactRepository {

    Contact save(Contact contact);

    Contact findById(Long id);

    Contact findByName(String name);

    PagedList<Contact> list(int page, int limit, String filter, String sortField, String sortOrder);

}
