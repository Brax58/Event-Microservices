package com.parreiras.event_microservices.dto;

import java.time.LocalDateTime;

public record EventRequestDto(int maxParticipants, int registeredParticipants, LocalDateTime date, String title, String description) {
}
