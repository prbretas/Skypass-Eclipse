package br.com.totvs.ticket.model.repository;

import java.io.Serializable;
//import java.util.Date;

import javax.persistence.ConstraintMode;
import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.annotations.NotFound;
import org.hibernate.annotations.NotFoundAction;

//import br.com.totvs.client.model.repository.ClientView;
//import br.com.totvs.flight.model.repository.FlightView;
import br.com.totvs.seat.model.repository.SeatView;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "ticket")
public class TicketView implements Serializable {

	private static final long serialVersionUID = 6160670597179814786L;
	@Id
	private String id;
	private int amountLuggage;
	private double weightLuggage;
	//private Date date;
	private double ticketPrice;
	private boolean ativo;
	
	/* ESTÁ NA TABELA INTERMEDIARIA (ClientTicket) EM CLIENT
	@OneToOne
	@NotFound(action = NotFoundAction.IGNORE)
	@JoinColumn(name = "clientId", referencedColumnName = "id", foreignKey = @ForeignKey(value = ConstraintMode.NO_CONSTRAINT), insertable = false, updatable = false)
	ClientView client;
	*/
	
	/*ESTÁ NA TABELA INTERMEDIARIA (FlightTicket) EM FLIGHT
	 * 
	 * @OneToOne
	@NotFound(action = NotFoundAction.IGNORE)
	@JoinColumn(name = "flightId", referencedColumnName = "id", foreignKey = @ForeignKey(value = ConstraintMode.NO_CONSTRAINT), insertable = false, updatable = false)
	FlightView flight;
	*/
	
	@OneToOne
	@NotFound(action = NotFoundAction.IGNORE)
	@JoinColumn(name = "seatId", referencedColumnName = "id", foreignKey = @ForeignKey(value = ConstraintMode.NO_CONSTRAINT), insertable = false, updatable = false)
	SeatView seat;
	
}