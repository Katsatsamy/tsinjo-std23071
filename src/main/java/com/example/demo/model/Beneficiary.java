package com.example.demo.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class Beneficiary extends Person{

    public Beneficiary(String id, String mail, String name) {
        super(id, mail, name);
    }
}
