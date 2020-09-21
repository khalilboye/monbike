package com.sid.monbike.dto;

import org.springframework.validation.annotation.Validated;
import javax.validation.constraints.NotNull;

@Validated
public class ClientDto {

    //@ApiModelProperty(value = "id", example = "2")
    private Long id ;

    @NotNull
    private String nom;

    @NotNull
    private String prenom;

    @NotNull
    private String adresse;

    @NotNull
    private String tel;

    @NotNull
    private String email;

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getAdresse() {
        return adresse;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }
}
