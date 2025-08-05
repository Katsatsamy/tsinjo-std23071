package com.example.demo.model;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Getter
@Setter
public class Help {
    @Id
    @GeneratedValue
  private String id;
  private Beneficiary beneficiary;
  private Payment payment;
  private String description;
}
