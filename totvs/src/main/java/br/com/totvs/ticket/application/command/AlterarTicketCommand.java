package br.com.totvs.ticket.application.command;

import br.com.totvs.seat.model.enums.Category;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class AlterarTicketCommand {
	private String id;
	private Category category;
	private int amountLuggage;
	private double weightLuggage;
	private String date;
	private double ticketPrice;
	private String clientId; 
	private String flightId;  
	private String seatId;  
}