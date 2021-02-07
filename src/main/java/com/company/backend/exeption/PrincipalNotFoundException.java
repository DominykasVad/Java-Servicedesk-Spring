package com.company.backend.exeption;

import java.security.Principal;

public class PrincipalNotFoundException extends RuntimeException {

    public PrincipalNotFoundException(Principal principal) {
        super(String.format("Principal with Username: %s was not found!", principal.getName()));
    }

}
