package com.kuehnenagel.contact.dto;

import lombok.Getter;
import lombok.Setter;

@Setter @Getter
public class ContactResponse {
    Long id;
    String name;
    String photoUrl;

    public ContactResponse(Long id, String name, String photoUrl) {
        this.id = id;
        this.name = name;
        this.photoUrl = photoUrl;
    }
}
