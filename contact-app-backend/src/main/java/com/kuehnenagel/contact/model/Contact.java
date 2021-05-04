package com.kuehnenagel.contact.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.time.LocalDate;

@Entity
@Setter @Getter
public class Contact {
    @Id
    @GeneratedValue
    Long id;
    String name;
    String photoUrl;
    LocalDate dateCreated;
}
