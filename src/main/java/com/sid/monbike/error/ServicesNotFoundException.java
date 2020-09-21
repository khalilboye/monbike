package com.sid.monbike.error;

import javassist.NotFoundException;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;

public class ServicesNotFoundException extends ResourceNotFoundException {

    public ServicesNotFoundException() {
        super("Service not found ");
    }
}
