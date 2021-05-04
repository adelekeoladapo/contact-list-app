package com.kuehnenagel.contact.controller;

import com.kuehnenagel.contact.dto.ContactResponse;
import com.kuehnenagel.contact.dto.ListResponse;
import com.kuehnenagel.contact.service.ContactService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1/contacts")
public class ContactController {

    private final ContactService contactService;

    @Autowired
    public ContactController(ContactService contactService) {
        this.contactService = contactService;
    }

    @RequestMapping(path = "", method = RequestMethod.GET)
    public ListResponse<ContactResponse> data(
            @RequestParam(name = "page", defaultValue = "0") int page,
            @RequestParam(name = "limit", defaultValue = "10") int limit,
            @RequestParam(name = "filter", defaultValue = "") String filter,
            @RequestParam(name = "sort-field", defaultValue = "name") String sortField,
            @RequestParam(name = "sort-order", defaultValue = "ASC") String sortOrder
    ) {
        try {
            page = (page < 1) ? 1 : page;
            limit = (limit < 0) ? 0 : limit;
            return this.contactService.listContacts(page, limit, filter, sortField, sortOrder);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

}
