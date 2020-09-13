package com.sid.monbike.service;


import com.sid.monbike.dto.CommandeDto;
import com.sid.monbike.entities.Commande;
import com.sid.monbike.mapper.CommandeMapper;
import com.sid.monbike.repository.CommandeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Optional;

@Service
public class CommandeService {
    @Autowired
    private CommandeRepository commandeRepository;

    @Autowired
    private CommandeMapper commandeMapper;

    @Autowired
    private ClientServices clientServices;

    @Autowired
    private ReparationService reparationService;


    public List<Commande> findAll() {
        return commandeRepository.findAll();
    }

    public Commande save(CommandeDto commandeDto) {

        Commande commande =  commandeMapper.toCommande(commandeDto);
        commandeRepository.save(commande);
        return commande;

    }


    public  Optional<List<Commande>> findClientBynom(String nom) {
       if(nom==null){
           throw new RuntimeException("renseigner le nom");
       }
        return commandeRepository.findCommandesByClientNomContaining(nom);
    }

    public Optional<List<Commande>> findClientBetweenDate(String datedebut, String datefin) {

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("YYYY-MM-dd");
        LocalDate date_debut = LocalDate.parse(datedebut,formatter);
        LocalDate date_fin = LocalDate.parse(datedebut,formatter) ;
        return commandeRepository.findCommandesByDateCommandeBetween(date_debut, date_fin);
    }

    public Optional<List<Commande>> findClientBynumero(Long numero) {

        return  commandeRepository.findCommandesByNumeroCommende(numero);
    }
}