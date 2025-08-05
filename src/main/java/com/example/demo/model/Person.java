package com.example.demo.model;

import jakarta.persistence.Column;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.data.annotation.Id;

@Getter
@Setter
@ToString
public class Person {
    @Id
  private String id;
    @Column(nullable = false, unique = true)
  private String mail;
    @Column(nullable = false)
  private String name;

  public Person(String id, String mail, String name) {
    this.id = id;
    this.mail = mail;
    this.name = name;
  }
}
