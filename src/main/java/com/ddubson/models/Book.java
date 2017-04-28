package com.ddubson.models;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "books")
@Data
public class Book {
    @Id
    @GeneratedValue
    private Long id;
    private String title;
}
