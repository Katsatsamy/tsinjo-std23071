package com.example.demo.dto;

import lombok.Data;

@Data
public class PaymentResponse {
    private String reference;       // Référence du paiement chez Vola
    private String paymentId;      // ID unique du paiement
    private String statusUrl;      // URL pour vérifier le statut

    // Constructeur par défaut nécessaire pour la désérialisation JSON
    public PaymentResponse() {}

    public String getReference() {
        return reference;
    }

    public void setReference(String reference) {
        this.reference = reference;
    }

    public String getPaymentId() {
        return paymentId;
    }

    public void setPaymentId(String paymentId) {
        this.paymentId = paymentId;
    }

    public String getStatusUrl() {
        return statusUrl;
    }

    public void setStatusUrl(String statusUrl) {
        this.statusUrl = statusUrl;
    }
}