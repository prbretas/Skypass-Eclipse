package br.com.totvs.ticket.application.command;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class AlterarTicketCommand {
	private String id;
	private int amountLuggage;
	private double weightLuggage;
	//private String date; ---> A DATA JA ESTA INSERIDA NO FLIGHT
	private double ticketPrice;
	//private String clientId; 
	//private String flightId;  
	private String seatId;  
}