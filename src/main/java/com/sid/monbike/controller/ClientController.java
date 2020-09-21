package com.sid.monbike.controller;


import com.sid.monbike.dto.ClientDto;
import com.sid.monbike.entities.Client;
import com.sid.monbike.error.ClientNotFoundException;
import com.sid.monbike.service.ClientServices;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("alquiler")
public class ClientController {


        @Autowired
        private ClientServices clientServices;
    /**
     * GET /services : get the "email" client.
     */
    @Operation(summary = "Get users",
            description = "Get list of users")
    @GetMapping("/all-client")
        List<ClientDto> findAll() {
            return clientServices.findAll();
        }

        // Save
        //return 201 instead of 200


    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("/add-client")
    Client newClient(@RequestBody  ClientDto clientDto) {

            return clientServices.save(clientDto);
        }


    @GetMapping("/client/{id}")
    Client findOneCar(@PathVariable  Long id) {
            return clientServices.findClientById(id)
                    .orElseThrow(() -> new ClientNotFoundException(id));
        }

    @Operation(summary = "Get user by user name",
            responses = {
                    @ApiResponse(description = "The user",
                            content = @Content(mediaType = "application/json",
                                    schema = @Schema(implementation = Client.class))),
                    @ApiResponse(responseCode = "400", description = "User not found")})
    @GetMapping("/client")
    ClientDto findbymail(@Parameter(description = "The name that needs to be fetched. Use user1 for testing. ", required = true)@Param("tel") String tel)
            {

        return clientServices.findClientByTel(tel);


    }

    @Operation(summary = "Delete user",
            description = "This can only be done by the logged in user.")
    @ApiResponse(responseCode = "200", description = "user deteled")
    @ApiResponse(responseCode = "400", description = "Invalid username supplied")
    @ApiResponse(responseCode = "404", description = "User not found")
    @ResponseStatus(HttpStatus.CREATED)
     @DeleteMapping("/client/{id}")
        void deleteBook(@PathVariable Long id) {
            clientServices.deleteById(id);
        }


}
