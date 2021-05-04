package com.kuehnenagel.contact.service.impl;

import com.kuehnenagel.contact.dto.ContactRequest;
import com.kuehnenagel.contact.dto.ContactResponse;
import com.kuehnenagel.contact.dto.ListResponse;
import com.kuehnenagel.contact.model.Contact;
import com.kuehnenagel.contact.model.repository.ContactRepository;
import com.kuehnenagel.contact.service.ContactService;
import io.ebean.PagedList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.stream.Collectors;

@Service
public class ContactServiceImpl implements ContactService {

    private final ContactRepository contactRepository;

    @Autowired
    public ContactServiceImpl(ContactRepository contactRepository) {
        this.contactRepository = contactRepository;
    }

    @Override
    public ListResponse<ContactResponse> listContacts(int page, int limit, String filter, String sortField, String sortOrder) {
        PagedList<Contact> pagedList = this.contactRepository.list(page, limit, filter, sortField, sortOrder);
        return new ListResponse<>(
                page,
                limit,
                pagedList.getTotalCount(),
                pagedList.getList().stream().map(data -> new ContactResponse(data.getId(), data.getName(), data.getPhotoUrl())).collect(Collectors.toList())
        );
    }

    @Override
    public ContactResponse saveContact(ContactRequest request) {
        Contact contact = new Contact();
        contact.setName(request.getName());
        contact.setPhotoUrl(request.getPhotoUrl());
        contact = this.contactRepository.save(contact);
        return new ContactResponse(contact.getId(), contact.getName(), contact.getPhotoUrl());
    }
}
