package com.example.demo.service;

import com.example.demo.model.PaymentStatus;
import lombok.Data;

@Data
public class PaymentStatusResponse {
    private PaymentStatus status;   // VERIFYING/SUCCEEDED/FAILED
    private String failureReason;   // Optionnel: raison de l'échec

    // Exemple de méthode utilitaire
    public boolean isCompleted() {
        return status != PaymentStatus.VERIFYING;
    }
}