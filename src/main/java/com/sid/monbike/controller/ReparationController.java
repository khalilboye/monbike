package com.sid.monbike.controller;


import com.sid.monbike.entities.Reparation;
import com.sid.monbike.service.ReparationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("alquiler")
public class ReparationController {

    @Autowired
    private ReparationService reparationService;

    @GetMapping("/all-reparations")
    List<Reparation> findAllReparations() {
        return reparationService.findAll();
    }

    // Save
    //return 201 instead of 200
    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("/add-reparation")
    void newreparation(@RequestBody Reparation reparation) {

        reparationService.save(reparation); //reparationServices.save(clientDto);
    }

}
