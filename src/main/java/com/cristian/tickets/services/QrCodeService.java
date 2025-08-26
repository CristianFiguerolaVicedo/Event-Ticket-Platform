package com.cristian.tickets.services;

import com.cristian.tickets.domain.entities.QrCode;
import com.cristian.tickets.domain.entities.Ticket;

public interface QrCodeService {
    QrCode generateQrCode(Ticket ticket);
}
