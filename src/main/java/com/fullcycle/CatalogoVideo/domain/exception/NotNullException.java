package com.fullcycle.CatalogoVideo.domain.exception;

public class NotNullException extends DomainException {
    public NotNullException() {
        super("Can't be null");
    }

    public NotNullException(String message) {
        super(message);
    }
}
