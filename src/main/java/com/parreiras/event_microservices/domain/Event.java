package com.parreiras.event_microservices.domain;

import com.parreiras.event_microservices.dto.EventRequestDto;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Entity(name = "event")
@Table(name = "event")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(of = "id")
public class Event {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;
    private int maxParticipants = 0;
    private int registeredParticipants = 0;
    private LocalDateTime date;
    private String title;
    private String description;

    public Event(EventRequestDto eventRequest){
        this.date = eventRequest.date();
        this.maxParticipants = eventRequest.maxParticipants();
        this.registeredParticipants = eventRequest.registeredParticipants();
        this.title = eventRequest.title();
        this.description = eventRequest.description();
    }

    public int getRegisteredParticipants() {
        return registeredParticipants;
    }

    public int getMaxParticipants() {
        return maxParticipants;
    }

    public void setRegisteredParticipants(int registeredParticipants) {
        this.registeredParticipants = registeredParticipants;
    }
}
