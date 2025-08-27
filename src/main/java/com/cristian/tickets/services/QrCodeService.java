package com.cristian.tickets.services;

import com.cristian.tickets.domain.entities.QrCode;
import com.cristian.tickets.domain.entities.Ticket;

import java.util.UUID;

public interface QrCodeService {
    QrCode generateQrCode(Ticket ticket);
    byte[] getQrCodeImageForUserAndTicket(UUID userId, UUID ticketId);
}
