package com.fullcycle.CatalogoVideo.domain.exception;

public class NotBlankException extends DomainException {
    public NotBlankException() {
        super("Can't be blank");
    }

    public NotBlankException(String message) {
        super(message);
    }

}
