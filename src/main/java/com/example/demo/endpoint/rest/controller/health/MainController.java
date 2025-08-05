package com.example.demo.endpoint.rest.controller.health;

import com.example.demo.model.*;
import com.example.demo.repository.DonationRepository;
import com.example.demo.repository.DonorRepository;
import com.example.demo.repository.HelpRepository;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.UUID;

@Controller
@RequiredArgsConstructor
public class MainController {
    private final DonationRepository donationRepo;
    private final DonorRepository donorRepo;
    private final HelpRepository helpRepo;

    public MainController(DonationRepository donationRepo, DonorRepository donorRepo, HelpRepository helpRepo) {
        this.donationRepo = donationRepo;
        this.donorRepo = donorRepo;
        this.helpRepo = helpRepo;
    }

    @GetMapping("/")
    public String showAll(Model model) {
        model.addAttribute("donations", donationRepo.findAllByOrderByDateDesc());
        model.addAttribute("helps", helpRepo.findAllByOrderByDateDesc());

        // Pour le formulaire
        model.addAttribute("newDonation", new DonationForm());
        model.addAttribute("donors", donorRepo.findAll()); // Liste des donateurs existants

        return "index";
    }

    @PostMapping("/donate")
    public String submitDonation(@ModelAttribute DonationForm form) {
        Donor donor = donorRepo.findById(form.getDonorId())
                .orElseThrow(() -> new IllegalArgumentException("Donateur invalide"));

        Payment payment = new Payment();
        payment.setPrice(form.getAmount());
        payment.setPaymentStatus(PaymentStatus.VERIFYING);
        payment.setPayementType(form.getPaymentType());
        payment.setReference(UUID.randomUUID().toString());

        Donation donation = new Donation();
        donation.setDonor(donor);
        donation.setPayment(payment);

        donationRepo.save(donation);
        return "redirect:/";
    }
}
