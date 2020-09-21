package com.sid.monbike;

import com.sid.monbike.entities.Client;
import com.sid.monbike.entities.Reparation;
import com.sid.monbike.repository.ClientRepository;
import com.sid.monbike.repository.ReparationRepository;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.info.License;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@OpenAPIDefinition(info =
@Info(
        title = "the title",
        version = "0.0",
        description = "My API",
        license = @License(name = "Apache 2.0", url = "http://foo.bar"),
        contact = @Contact(url = "http://gigantic-server.com", name = "Fred", email = "Fred@gigagantic-server.com")
)
)
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

 /*    Client client = new Client();
        client.setPrenom("ibraa");
        client.setNom("boye");
        client.setTel("778261466");
        client.setAdresse("dakar");
        client.setEmail("abc@gmail.com");

        Reparation reparation = new Reparation();
        reparation.setLibelle("velo");
        reparation.setPrix(14501d);
        reparationRepository.save(reparation);
        clientRepository.save(client);

        Long  l =   (long)(Math.random()*100000 + 3122000000L);

        System.out.println(l);

  */


    }
}
