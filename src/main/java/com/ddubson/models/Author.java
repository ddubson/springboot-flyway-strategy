package com.ddubson.models;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="authors")
@Data
public class Author {
    @Id
    @GeneratedValue
    private Long id;

    private String firstName;
    private String lastName;
}
