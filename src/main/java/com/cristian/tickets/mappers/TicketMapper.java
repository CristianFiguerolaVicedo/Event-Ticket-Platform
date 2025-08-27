package com.cristian.tickets.mappers;

import com.cristian.tickets.domain.dtos.ListTicketResponseDto;
import com.cristian.tickets.domain.dtos.ListTicketTicketTypeResponseDto;
import com.cristian.tickets.domain.entities.Ticket;
import com.cristian.tickets.domain.entities.TicketType;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface TicketMapper {
    ListTicketTicketTypeResponseDto toListTicketTicketTypeResponseDto(TicketType ticketType);
    ListTicketResponseDto toListTicketResponseDto(Ticket ticket);
}
