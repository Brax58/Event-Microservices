package com.parreiras.event_microservices.service;

import com.parreiras.event_microservices.domain.Event;
import com.parreiras.event_microservices.domain.Subscription;
import com.parreiras.event_microservices.dto.EmailRequestDto;
import com.parreiras.event_microservices.dto.EventRequestDto;
import com.parreiras.event_microservices.exception.EventFullException;
import com.parreiras.event_microservices.exception.EventNotFoundException;
import com.parreiras.event_microservices.repository.EventRepository;
import com.parreiras.event_microservices.repository.SubscriptionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class EventService {
    @Autowired
    private EventRepository eventRepository;

    @Autowired
    private SubscriptionRepository subscriptionRepository;

    @Autowired
    private EmailClientService emailServiceClient;

    public void registerParticipant(String eventId, String participantEmail) {
        Event event = eventRepository.findById(eventId).orElseThrow(EventNotFoundException::new);

        if(isEventFull(event)) {
            throw new EventFullException();
        }

        Subscription subscription = new Subscription(event, participantEmail);
        subscriptionRepository.save(subscription);

        event.setRegisteredParticipants(event.getRegisteredParticipants() + 1);

        EmailRequestDto emailRequest = new EmailRequestDto(participantEmail, "Confirmação de Inscrição", "Você foi inscrito no evento com sucesso!");

        emailServiceClient.sendEmail(emailRequest);
    }

    public List<Event> getAllEvents() {
        return eventRepository.findAll();
    }

    public List<Event> getUpcomingEvents() {
        return eventRepository.findUpcomingEvents(LocalDateTime.now());
    }

    public Event createEvent(EventRequestDto eventRequest) {
        Event newEvent = new Event(eventRequest);
        return eventRepository.save(newEvent);
    }

    private Boolean isEventFull(Event event){
        return event.getRegisteredParticipants() >= event.getMaxParticipants();
    }
}
