package com.parreiras.event_microservices.repository;

import com.parreiras.event_microservices.domain.Event;
import feign.Param;
import lombok.NonNull;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

public interface EventRepository extends JpaRepository<Event, Long> {

    @Query(value = "SELECT * FROM event e WHERE parsedatetime(e.date, 'dd/MM/yyyy') > :currentDate", nativeQuery = true)
    List<Event> findUpcomingEvents(@Param("currentDate") LocalDateTime currentDate);

    @NonNull
    Optional<Event> findById(@NonNull String id);
}
