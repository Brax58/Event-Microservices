package com.parreiras.event_microservices.exception;

public class EventFullException extends RuntimeException {
    public EventFullException() {
        super("Evento está lotado!");
    }

    public EventFullException(String message) {
        super(message);
    }
}