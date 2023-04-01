package br.com.totvs.ticket.api.dto;

import br.com.totvs.seat.model.enums.Category;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor(staticName = "of")
@NoArgsConstructor(access = AccessLevel.PRIVATE, force = true)
public class AlterarTicketDTO {
	private Category category;
	private int amountLuggage;
	private double weightLuggage;
	private String date;
	private double ticketPrice;
	private String clientId;  
	private String flightId; 
	private String seatId;  
	
}