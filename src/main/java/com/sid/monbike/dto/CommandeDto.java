package com.sid.monbike.dto;


import com.sid.monbike.entities.Client;
import com.sid.monbike.entities.Reparation;

import java.time.LocalDate;

public class CommandeDto {

    private  Long id;
    private String libelle;
    private Long numeroCommende ;
    private LocalDate dateCommande;
    private LocalDate datelivraisonprevu;
    private LocalDate getDatelivraisonreel;
    private Client client;
    private Reparation reparation;


    public CommandeDto() {
    }

    public Long getNumeroCommende() {
        return numeroCommende;
    }

    public void setNumeroCommende(Long numeroCommende) {
        this.numeroCommende = numeroCommende;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public Reparation getReparation() {
        return reparation;
    }

    public void setReparation(Reparation reparation) {
        this.reparation = reparation;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getLibelle() {
        return libelle;
    }

    public void setLibelle(String libelle) {
        this.libelle = libelle;
    }

    public LocalDate getDateCommande() {
        return dateCommande;
    }

    public void setDateCommande(LocalDate dateCommande) {
        this.dateCommande = dateCommande;
    }

    public LocalDate getDatelivraisonprevu() {
        return datelivraisonprevu;
    }

    public void setDatelivraisonprevu(LocalDate datelivraisonprevu) {
        this.datelivraisonprevu = datelivraisonprevu;
    }

    public LocalDate getGetDatelivraisonreel() {
        return getDatelivraisonreel;
    }

    public void setGetDatelivraisonreel(LocalDate getDatelivraisonreel) {
        this.getDatelivraisonreel = getDatelivraisonreel;
    }
}
