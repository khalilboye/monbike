package com.sid.monbike.service;


import com.sid.monbike.entities.Reparation;
import com.sid.monbike.error.ClientNotFoundException;
import com.sid.monbike.repository.ReparationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ReparationService {


    @Autowired
    private ReparationRepository reparationRepository;


    public List<Reparation> findAll() {
        return reparationRepository.findAll();
    }

    public void save(Reparation reparation) {

        reparationRepository.save(reparation);
    }

    public  Optional<Reparation> findReparationById(long id) {
        Optional<Reparation> reparation = reparationRepository.findById(id);
        if(!reparation.isPresent() ||  reparation==null ){
            throw new ClientNotFoundException(id);
        }

        return reparation;
    }


}
