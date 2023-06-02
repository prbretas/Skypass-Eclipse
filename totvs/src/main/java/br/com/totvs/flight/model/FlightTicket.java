package br.com.totvs.flight.model;

import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor(staticName = "of")
@NoArgsConstructor
@Entity
@IdClass(FlightTicketId.class)
@Table(name = "flight_ticket")
public class FlightTicket {

	@Id
	private String id;

	@Id
	@NotNull
	@Column(name = "flight_id")
	private String flightId;

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		FlightTicket other = (FlightTicket) obj;
		return Objects.equals(id, other.id) && Objects.equals(flightId, other.flightId);
	}

	@Override
	public int hashCode() {
		return Objects.hash(id, flightId);
	}
}