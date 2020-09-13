package com.sid.monbike.repository;

import com.sid.monbike.entities.Commande;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

public interface CommandeRepository extends JpaRepository<Commande,Long> {

    Optional<List<Commande>> findCommandesByClientNomContaining(String nom);
    Optional<List<Commande>> findCommandesByDateCommandeBetween(LocalDate datedebut, LocalDate datefin);

    Optional<List<Commande>> findCommandesByNumeroCommende(Long numero);
}

