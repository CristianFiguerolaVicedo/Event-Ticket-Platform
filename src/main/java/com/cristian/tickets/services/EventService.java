package com.cristian.tickets.services;

import com.cristian.tickets.domain.CreateEventRequest;
import com.cristian.tickets.domain.entities.Event;

import java.util.UUID;

public interface EventService {
    Event createEvent(UUID organizerId, CreateEventRequest event);
}
