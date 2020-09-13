package com.sid.monbike.controller;


import com.sid.monbike.dto.CommandeDto;
import com.sid.monbike.entities.Commande;
import com.sid.monbike.service.CommandeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("alquiler")
public class CommandeController {


        @Autowired
        private CommandeService commandeService;

        @GetMapping("/all-commande")
        List<Commande> findAllCommande() {
            return commandeService.findAll()
                    ;
        }

        //return 201 instead of 200
        @ResponseStatus(HttpStatus.CREATED)
        @PostMapping("/add-commande")
        public Commande  newCommande(@RequestBody CommandeDto commandeDto) {

          return commandeService.save(commandeDto); //reparationServices.save(clientDto);
        }
        // Find
        @GetMapping("/commande")
        Optional<List<Commande>> findbycommeByname(@Param("nom") String nom) {
                return commandeService.findClientBynom(nom);
                      //  .orElseThrow(() -> new ClientNotFoundException(nom));
        }

        @GetMapping("/commande-by-date")
        Optional<List<Commande>> findCommandeBetweenDate(@Param("datedebut") String datedebut , @Param("datefin") String datefin ) {
                return commandeService.findClientBetweenDate(datedebut, datefin);
                //  .orElseThrow(() -> new ClientNotFoundException(nom));
        }

        @GetMapping("/num-commande")
        Optional<List<Commande>> findbycommeBynumero(@Param("nom") Long numero) {
                return commandeService.findClientBynumero(numero);
                //  .orElseThrow(() -> new ClientNotFoundException(nom));
        }
}
