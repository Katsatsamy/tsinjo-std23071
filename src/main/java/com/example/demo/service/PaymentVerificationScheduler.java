package com.example.demo.service;

import com.example.demo.model.Payment;
import com.example.demo.model.PaymentStatus;
import com.example.demo.repository.PaymentRepository;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

@Service
public class PaymentVerificationScheduler {
  private final VolaPaymentService volaService;
  private final PaymentRepository paymentRepo;

  public PaymentVerificationScheduler(
      VolaPaymentService volaService, PaymentRepository paymentRepo) {
    this.volaService = volaService;
    this.paymentRepo = paymentRepo;
  }

  @Scheduled(fixedRate = 5000) // Toutes les 5 secondes
  public void verifyPendingPayments() {
    List<Payment> pendingPayments = paymentRepo.findByStatus(PaymentStatus.VERIFYING);

    pendingPayments.forEach(
        payment -> {
          volaService
              .checkPaymentStatus(payment.getReference())
              .subscribe(
                  status -> {
                    payment.setPaymentStatus(status);
                    paymentRepo.save(payment);
                    System.out.println(
                        "Statut mis à jour pour " + payment.getReference() + ": " + status);
                  });
        });
  }
}
