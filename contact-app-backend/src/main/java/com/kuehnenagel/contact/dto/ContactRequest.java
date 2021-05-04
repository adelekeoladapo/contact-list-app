package com.kuehnenagel.contact.dto;

import lombok.Getter;
import lombok.Setter;

@Setter @Getter
public class ContactRequest {
    String name;
    String photoUrl;

    public ContactRequest(String name, String photoUrl) {
        this.name = name;
        this.photoUrl = photoUrl;
    }
}
