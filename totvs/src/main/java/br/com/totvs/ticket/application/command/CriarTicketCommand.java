package br.com.totvs.ticket.application.command;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class CriarTicketCommand {
	private int amountLuggage;
	private double weightLuggage;
	//private String date;
	private double ticketPrice;	
	private String clientId;  // (FK_CLIENT_TICKET)
	//private String flightId;  // (FK_FLIGHT_TICKET)
	private String seatId;  // (FK_SEAT_TICKET)
}
