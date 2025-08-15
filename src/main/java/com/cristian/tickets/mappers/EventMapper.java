package com.cristian.tickets.mappers;

import com.cristian.tickets.domain.CreateEventRequest;
import com.cristian.tickets.domain.CreateTicketTypeRequest;
import com.cristian.tickets.domain.dtos.CreateEventRequestDto;
import com.cristian.tickets.domain.dtos.CreateEventResponseDto;
import com.cristian.tickets.domain.dtos.CreateTicketTypeRequestDto;
import com.cristian.tickets.domain.entities.Event;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface EventMapper {
    CreateTicketTypeRequest fromDto(CreateTicketTypeRequestDto dto);
    CreateEventRequest fromDto(CreateEventRequestDto dto);
    CreateEventResponseDto toDto(Event event);
}
