package com.kuehnenagel.contact.service;

import com.kuehnenagel.contact.dto.ContactRequest;
import com.kuehnenagel.contact.dto.ContactResponse;
import com.kuehnenagel.contact.dto.ListResponse;
import com.opencsv.CSVReader;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import java.io.FileReader;
import java.util.List;

@Component
public class PostConstruct {

    private final Logger LOGGER = LoggerFactory.getLogger(PostConstruct.class);

    private final ContactService contactService;

    @Value("${csvFilePath}")
    private String filePath;

    @Autowired
    public PostConstruct(ContactService contactService) {
        this.contactService = contactService;
    }

    @javax.annotation.PostConstruct
    public void init() {
        ListResponse<ContactResponse> list = this.contactService.listContacts(1, 1, "", "id", "ASC");
        if (list.getTotal() == 0) {
            LOGGER.info("Initializing contact list.");
            try (CSVReader reader = new CSVReader(new FileReader(filePath))) {
                List<String[]> r = reader.readAll();
                r.forEach(row -> {
                    this.contactService.saveContact(new ContactRequest(row[0], row[1]));
                });
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }



}
