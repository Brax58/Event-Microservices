package com.parreiras.event_microservices.exception;

public class EventNotFoundException extends RuntimeException {
    public EventNotFoundException() {
        super("Evento não encontrado");
    }

    public EventNotFoundException(String message) {
        super(message);
    }
}
