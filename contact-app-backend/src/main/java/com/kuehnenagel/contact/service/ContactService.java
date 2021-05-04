package com.kuehnenagel.contact.service;

import com.kuehnenagel.contact.dto.ContactRequest;
import com.kuehnenagel.contact.dto.ContactResponse;
import com.kuehnenagel.contact.dto.ListResponse;

public interface ContactService {

    ListResponse<ContactResponse> listContacts(int page, int limit, String filter, String sortField, String sortOrder);

    ContactResponse saveContact(ContactRequest request);

}
