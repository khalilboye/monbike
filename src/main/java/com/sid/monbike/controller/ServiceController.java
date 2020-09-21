package com.sid.monbike.controller;


import com.sid.monbike.dto.ClientServiceDto;
import com.sid.monbike.dto.ServiceDto;
import com.sid.monbike.entities.Service;
import com.sid.monbike.service.ClientServices;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.net.URISyntaxException;

@RestController
@RequestMapping("services")
public class ServiceController {

    private static final Logger LOGGER = LoggerFactory.getLogger(ServiceController.class);

    @Autowired
    private ClientServices clientServices ;

    /**
     * POST /services : Create a new service.
     */
    @Operation(summary = "Delete user",
            description = "This can only be done by the logged in user.")
    @ApiResponse(responseCode = "201", description = "user deteled")
    @ApiResponse(responseCode = "404", description = "User not found")
    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("/client-service")
    public void associateToServiceClient(@RequestBody ClientServiceDto clientServiceDto)
            throws URISyntaxException {

        LOGGER.debug("REST request to associate Client to Service : {}");
        clientServices.associateServiceClient(clientServiceDto);
    }


    //return 201 instead of 200
    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("/add-service")
    Service newClient(@RequestBody ServiceDto serviceDto) {

        return clientServices.saveService(serviceDto);
    }


}
