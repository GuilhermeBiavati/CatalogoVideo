package com.fullcycle.CatalogoVideo.domain.exception;

import java.util.UUID;

public class DomainException extends RuntimeException {

    public DomainException() {
        super();
    }

    public DomainException(String message) {
        super(message);
    }

}
