package com.kuehnenagel.contact.model.repository.impl;

import com.kuehnenagel.contact.model.Contact;
import com.kuehnenagel.contact.model.repository.ContactRepository;
import io.ebean.EbeanServer;
import io.ebean.ExpressionList;
import io.ebean.PagedList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class ContactRepositoryEbean implements ContactRepository {

    private EbeanServer store;

    @Autowired
    public ContactRepositoryEbean(EbeanServer store) {
        this.store = store;
    }

    @Override
    public Contact save(Contact contact) {
        this.store.save(contact);
        return contact;
    }

    @Override
    public Contact findById(Long id) {
        return this.store.find(Contact.class).where().idEq(id).findOne();
    }

    @Override
    public Contact findByName(String name) {
        return this.store.find(Contact.class).where().eq("name", name).findOne();
    }

    @Override
    public PagedList<Contact> list(int page, int limit, String filter, String sortField, String sortOrder) {
        ExpressionList<Contact> expressionList = this.store.find(Contact.class).where();
        if (!filter.equals("")) {
            expressionList = expressionList.or().ilike("name", "%" + filter + "%");
        }
        if (!sortField.equals("")) {
            if (sortOrder.equals("DESC")) {
                expressionList.order().desc(sortField);
            } else {
                expressionList.order().asc(sortField);
            }
        }
        expressionList.setFirstRow((page-1) * limit).setMaxRows(limit);
        return expressionList.findPagedList();
    }
}
