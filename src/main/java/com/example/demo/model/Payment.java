package com.example.demo.model;

import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import java.time.LocalDate;
import lombok.AllArgsConstructor;
import lombok.ToString;

@AllArgsConstructor
@ToString
public class Payment {
  private String reference;
  private LocalDate date;
  private long price;

  @Enumerated(EnumType.STRING)
  private PaymentType payementType;

  @Enumerated(EnumType.STRING)
  private PaymentStatus paymentStatus;

    public Payment(long amount, PaymentStatus paymentStatus, PaymentType paymentType, String string) {
    }

    public String getReference() {
        return reference;
    }

    public void setReference(String reference) {
        this.reference = reference;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public long getPrice() {
        return price;
    }

    public void setPrice(long price) {
        this.price = price;
    }

    public PaymentType getPayementType() {
        return payementType;
    }

    public void setPayementType(PaymentType payementType) {
        this.payementType = payementType;
    }

    public PaymentStatus getPaymentStatus() {
        return paymentStatus;
    }

    public void setPaymentStatus(PaymentStatus paymentStatus) {
        this.paymentStatus = paymentStatus;
    }
}
