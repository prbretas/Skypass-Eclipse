package br.com.totvs.ticket.model;
//import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@Table(name = "ticket")
public class Ticket {
	@Id
	private String id;
	private int amountLuggage;
	private double weightLuggage;
	private double ticketPrice;
	private boolean ativo;
	//private Date date;
	private String clientId;  // (FK_CLIENT_TICKET)
	//private String flightId;  // (FK_FLIGHT_TICKET)
	private String seatId;  // (FK_SEAT_TICKET)

	@Builder
	private Ticket(String id, int amountLuggage,
			double weightLuggage, double ticketPrice, String clientId,
			String flightId, String seatId) {
		this.id = id;
		this.amountLuggage = amountLuggage;
		this.weightLuggage = weightLuggage;
		this.ticketPrice = ticketPrice;
		//this.date = date;
		this.clientId = clientId;
		//this.flightId = flightId;
		this.seatId = seatId;
		this.ativo = true;
	}
	
	public void ativar() {
		this.ativo = true;
	}
	
	public void inativar() {
		this.ativo = false;
	}
}