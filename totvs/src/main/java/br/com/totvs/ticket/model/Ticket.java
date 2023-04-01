package br.com.totvs.ticket.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import br.com.totvs.seat.model.enums.Category;
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
	private Category category;
	private int amountLuggage;
	private double weightLuggage;
	private String date;
	private double ticketPrice;
	private boolean ativo;
	
	private String clientId;  // (FK_CLIENT_TICKET)
	private String flightId;  // (FK_FLIGHT_TICKET)
	private String seatId;  // (FK_SEAT_TICKET)

	@Builder
	private Ticket(String id, Category category, int amountLuggage,
			double weightLuggage, String date, double ticketPrice, String clientId,
			String flightId, String seatId) {
		this.id = id;
		this.category = category;
		this.amountLuggage = amountLuggage;
		this.weightLuggage = weightLuggage;
		this.date = date;
		this.ticketPrice = ticketPrice;
		this.clientId = clientId;
		this.flightId = flightId;
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