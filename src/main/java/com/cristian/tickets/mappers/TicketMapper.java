package com.cristian.tickets.mappers;

import com.cristian.tickets.domain.dtos.GetTicketResponseDto;
import com.cristian.tickets.domain.dtos.ListTicketResponseDto;
import com.cristian.tickets.domain.dtos.ListTicketTicketTypeResponseDto;
import com.cristian.tickets.domain.entities.Ticket;
import com.cristian.tickets.domain.entities.TicketType;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface TicketMapper {
    ListTicketTicketTypeResponseDto toListTicketTicketTypeResponseDto(TicketType ticketType);
    ListTicketResponseDto toListTicketResponseDto(Ticket ticket);

    @Mapping(target = "price", source = "ticket.ticketType.price")
    @Mapping(target = "description", source = "ticket.ticketType.description")
    @Mapping(target = "eventName", source = "ticket.ticketType.eventName")
    @Mapping(target = "eventVenue", source = "ticket.ticketType.eventVenue")
    @Mapping(target = "eventStart", source = "ticket.ticketType.eventStart")
    @Mapping(target = "eventEnd", source = "ticket.ticketType.eventEnd")
    GetTicketResponseDto toGetTicketResponseDto(Ticket ticket);
}
