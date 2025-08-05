package com.example.demo.endpoint.rest.controller.health;

import com.example.demo.model.Payment;
import com.example.demo.model.PaymentStatus;
import com.example.demo.repository.PaymentRepository;
import com.example.demo.service.VolaPaymentService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/payments")
@RequiredArgsConstructor
public class PaymentController {
  private final VolaPaymentService volaService;
  private final PaymentRepository paymentRepo;

  public PaymentController(VolaPaymentService volaService, PaymentRepository paymentRepo) {
    this.volaService = volaService;
    this.paymentRepo = paymentRepo;
  }

  @PostMapping
  public ResponseEntity<String> submitPayment(@RequestBody Payment payment) {
    payment.setPaymentStatus(PaymentStatus.VERIFYING); // Statut initial
    Payment savedPayment = paymentRepo.save(payment);

    // Soumission asynchrone à Vola
    volaService
        .submitPayment(savedPayment)
        .subscribe(ref -> System.out.println("Paiement soumis avec référence: " + ref));

    return ResponseEntity.ok(
        "Paiement en cours de vérification. Référence: " + savedPayment.getReference());
  }
}
