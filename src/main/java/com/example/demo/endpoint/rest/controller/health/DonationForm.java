package com.example.demo.endpoint.rest.controller.health;

import com.example.demo.model.PaymentType;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class DonationForm {
    private String donorId;
    private long amount;
    private PaymentType paymentType;

    public String getDonorId() {
        return donorId;
    }

    public void setDonorId(String donorId) {
        this.donorId = donorId;
    }

    public long getAmount() {
        return amount;
    }

    public void setAmount(long amount) {
        this.amount = amount;
    }

    public PaymentType getPaymentType() {
        return paymentType;
    }

    public void setPaymentType(PaymentType paymentType) {
        this.paymentType = paymentType;
    }
}
