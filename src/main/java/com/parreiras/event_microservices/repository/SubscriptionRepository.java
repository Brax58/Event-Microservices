package com.parreiras.event_microservices.repository;

import com.parreiras.event_microservices.domain.Subscription;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SubscriptionRepository extends JpaRepository<Subscription, Long>
{

}
