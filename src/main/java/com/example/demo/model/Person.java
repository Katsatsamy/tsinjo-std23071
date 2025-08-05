package com.example.demo.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class Person {
    private String id;
    private String mail;
    private String name;

    public Person(String id, String mail, String name) {
        this.id = id;
        this.mail = mail;
        this.name = name;
    }
}
