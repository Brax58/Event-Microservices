package com.parreiras.event_microservices.controller;

import com.parreiras.event_microservices.domain.Event;
import com.parreiras.event_microservices.dto.EventRequestDto;
import com.parreiras.event_microservices.dto.SubscriptionRequestDto;
import com.parreiras.event_microservices.service.EventService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/events")
@Tag(name = "Eventos", description = "Operações para gerenciamento de eventos e inscrições")
public class EventController {

    @Autowired
    private EventService eventService;

    @GetMapping
    @Operation(
            summary = "Listar todos os eventos",
            description = "Retorna uma lista completa de todos os eventos cadastrados",
            responses = {
                    @ApiResponse(responseCode = "200", description = "Lista de eventos recuperada com sucesso")
            }
    )
    public List<Event> getAllEvents() {
        return eventService.getAllEvents();
    }

    @GetMapping("/upcoming")
    @Operation(
            summary = "Listar eventos futuros",
            description = "Retorna uma lista de eventos com datas posteriores à atual",
            responses = {
                    @ApiResponse(responseCode = "200", description = "Lista de eventos futuros recuperada com sucesso")
            }
    )
    public List<Event> getUpcomingEvents() {
        return eventService.getUpcomingEvents();
    }

    @PostMapping
    @Operation(
            summary = "Criar novo evento",
            description = "Cadastra um novo evento no sistema",
            responses = {
                    @ApiResponse(responseCode = "200", description = "Evento criado com sucesso"),
                    @ApiResponse(responseCode = "400", description = "Dados inválidos fornecidos")
            }
    )
    public Event createEvent(
            @io.swagger.v3.oas.annotations.parameters.RequestBody(
                    description = "Dados do evento a ser criado",
                    required = true
            )
            @org.springframework.web.bind.annotation.RequestBody EventRequestDto event) {
        return eventService.createEvent(event);
    }

    @PostMapping("/{eventId}/register")
    @Operation(
            summary = "Registrar participante",
            description = "Inscreve um participante em um evento específico",
            responses = {
                    @ApiResponse(responseCode = "200", description = "Participante inscrito com sucesso"),
                    @ApiResponse(responseCode = "404", description = "Evento não encontrado"),
                    @ApiResponse(responseCode = "400", description = "Dados de inscrição inválidos")
            }
    )
    public void registerParticipant(
            @Parameter(
                    description = "ID do evento para inscrição",
                    required = true,
                    example = "123e4567-e89b-12d3-a456-426614174000"
            )
            @PathVariable String eventId,

            @io.swagger.v3.oas.annotations.parameters.RequestBody(
                    description = "Dados de inscrição do participante",
                    required = true
            )
            @org.springframework.web.bind.annotation.RequestBody SubscriptionRequestDto subscriptionRequest) {
        eventService.registerParticipant(eventId, subscriptionRequest.participantEmail());
    }
}