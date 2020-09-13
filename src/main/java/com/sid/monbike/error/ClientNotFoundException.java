package com.sid.monbike.error;

public class ClientNotFoundException extends RuntimeException {

    public ClientNotFoundException(Long id) {
        super("Car not found "+id);
    }
    public ClientNotFoundException(String tel) {
        super("Car not found "+tel);
    }
}
