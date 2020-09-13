package com.sid.monbike.error;

import java.util.Set;

public class ClientUnSupportedFieldPatchException extends RuntimeException {

    public ClientUnSupportedFieldPatchException(Set<String> keys) {
        super("Field " + keys.toString() + " update is not allow.");
    }
}
