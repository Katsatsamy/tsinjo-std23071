package com.example.demo.service;

import com.example.demo.dto.PaymentResponse;
import com.example.demo.model.Payment;
import com.example.demo.model.PaymentStatus;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

@Service
public class VolaPaymentService {
  private final WebClient volaWebClient;

  public VolaPaymentService(WebClient volaWebClient) {
    this.volaWebClient = volaWebClient;
  }

  public Mono<String> submitPayment(Payment payment) {
    return volaWebClient
        .post()
        .uri("/payments/submit")
        .bodyValue(payment)
        .retrieve()
        .bodyToMono(PaymentResponse.class)
        .map(PaymentResponse::getReference);
  }

  // Vérifier l'état du paiement
  public Mono<PaymentStatus> checkPaymentStatus(String reference) {
    return volaWebClient
        .get()
        .uri("/payments/{reference}/status", reference)
        .retrieve()
        .bodyToMono(PaymentStatusResponse.class)
        .map(PaymentStatusResponse::getStatus);
  }
}
