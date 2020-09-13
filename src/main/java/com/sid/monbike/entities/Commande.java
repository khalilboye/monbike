package com.sid.monbike.entities;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
public class Commande {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY )
    private  Long id;
    private Long numeroCommende ;
    private String libelle;
    private LocalDate dateCommande;
    private LocalDate datelivraisonprevu;
    private LocalDate getDatelivraisonreel;
    @OneToOne(cascade = CascadeType.ALL)
    private Client client;
    @ManyToOne(cascade = CascadeType.ALL)
    private Reparation reparation;

   /* @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name="reparation_id", nullable=false)
    private Reparation reparation;
    */

    public Reparation getReparation() {
        return reparation;
    }

    public void setReparation(Reparation reparation) {
        this.reparation = reparation;
    }

    public Commande() {
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
