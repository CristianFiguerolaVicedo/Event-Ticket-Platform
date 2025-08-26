package com.cristian.tickets.services.impl;

import com.cristian.tickets.domain.entities.Ticket;
import com.cristian.tickets.domain.entities.TicketStatusEnum;
import com.cristian.tickets.domain.entities.TicketType;
import com.cristian.tickets.domain.entities.User;
import com.cristian.tickets.exceptions.TicketSoldOutException;
import com.cristian.tickets.exceptions.TicketTypeNotFoundException;
import com.cristian.tickets.exceptions.UserNotFoundException;
import com.cristian.tickets.repositories.TicketRepository;
import com.cristian.tickets.repositories.TicketTypeRepository;
import com.cristian.tickets.repositories.UserRepository;
import com.cristian.tickets.services.QrCodeService;
import com.cristian.tickets.services.TicketTypeService;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class TicketTypeServiceImpl implements TicketTypeService {

    private final UserRepository userRepository;
    private final TicketRepository ticketRepository;
    private final TicketTypeRepository ticketTypeRepository;
    private final QrCodeService qrCodeService;

    @Override
    @Transactional
    public Ticket purchaseTicket(UUID userId, UUID ticketTypeId) {
        User user = userRepository.findById(userId).orElseThrow(() -> new UserNotFoundException(
                String.format("User with ID '%s' not found", userId)
        ));

        TicketType ticketType = ticketTypeRepository.findByIdWithLock(ticketTypeId).orElseThrow(() -> new TicketTypeNotFoundException(
                String.format("Ticket type with ID '%s' not found", ticketTypeId)
        ));

        int purchasedTickets = ticketRepository.countByTicketTypeId(ticketType.getId());
        Integer totalAvailable = ticketType.getTotalAvailable();

        if (purchasedTickets + 1 > totalAvailable) {
            throw new TicketSoldOutException();
        }
        Ticket ticket = new Ticket();
        ticket.setStatus(TicketStatusEnum.PURCHASED);
        ticket.setTicketType(ticketType);
        ticket.setPurchaser(user);

        Ticket savedTicket = ticketRepository.save(ticket);
        qrCodeService.generateQrCode(savedTicket);

        return ticketRepository.save(savedTicket);
    }
}
