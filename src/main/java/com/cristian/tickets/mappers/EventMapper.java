package com.cristian.tickets.mappers;

import com.cristian.tickets.domain.CreateEventRequest;
import com.cristian.tickets.domain.CreateTicketTypeRequest;
import com.cristian.tickets.domain.UpdateEventRequest;
import com.cristian.tickets.domain.UpdateTicketTypeRequest;
import com.cristian.tickets.domain.dtos.*;
import com.cristian.tickets.domain.entities.Event;
import com.cristian.tickets.domain.entities.TicketType;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface EventMapper {
    CreateTicketTypeRequest fromDto(CreateTicketTypeRequestDto dto);
    CreateEventRequest fromDto(CreateEventRequestDto dto);
    CreateEventResponseDto toDto(Event event);
    ListEventTicketTypeResponseDto toDto(TicketType ticket);
    ListEventResponseDto toListEventResponseDto(Event event);
    GetEventDetailsTicketTypesResponseDto toGetEventDetailsTicketTypesResponseDto(TicketType ticketType);
    GetEventDetailsResponseDto toGetEventDetailsResponseDto(Event event);
    UpdateTicketTypeRequest fromDto(UpdateTicketTypeRequestDto dto);
    UpdateEventRequest fromDto(UpdateEventRequestDto dto);
    UpdateTicketTypeResponseDto toUpdateTicketTypeResponseDto(TicketType ticketType);
    UpdateEventResponseDto toUpdateEventResponseDto(Event event);
}
