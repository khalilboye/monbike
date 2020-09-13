package com.sid.monbike;

import com.sid.monbike.entities.Client;
import com.sid.monbike.entities.Reparation;
import com.sid.monbike.repository.ClientRepository;
import com.sid.monbike.repository.ReparationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class MonbikeApplication implements CommandLineRunner {

    @Autowired
    private ClientRepository clientRepository;

    @Autowired
    private ReparationRepository reparationRepository;

    public static void main(String[] args) {
        SpringApplication.run(MonbikeApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {

        Client client = new Client();
        client.setPrenom("ibraa");
        client.setNom("boye");
        client.setTel("778261466");
        client.setAdresse("dakar");
        client.setEmail("ibr@gmail.com");

        Reparation reparation = new Reparation();
        reparation.setLibelle("velo");
        reparation.setPrix(14501d);
        reparationRepository.save(reparation);
        clientRepository.save(client);

        Long  l =   (long)(Math.random()*100000 + 3122000000L);

        System.out.println(l);

    }
}
