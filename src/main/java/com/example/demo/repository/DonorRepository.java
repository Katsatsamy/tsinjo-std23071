package com.example.demo.repository;

import com.example.demo.model.Donor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DonorRepository extends JpaRepository<Donor, String> {
    // Méthodes personnalisées utiles :

    // Trouver un donateur par email (exemple)
    Donor findByEmail(String email);

    // Vérifier l'existence par email
    boolean existsByEmail(String email);

    // Trouver par nom (ignore la casse)
    List<Donor> findByNameContainingIgnoreCase(String name);
}