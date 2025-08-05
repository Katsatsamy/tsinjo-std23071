package com.example.demo.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@ToString
@Getter
@Setter
public class Donor extends Person{
    public Donor(String id, String mail, String name) {
        super(id, mail, name);
    }
}
