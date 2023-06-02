package br.com.totvs.aircraft.model;

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
@IdClass(AircraftSeatId.class)
@Table(name = "aircraft_seat")
public class AircraftSeat {

	@Id
	private String id;

	@Id
	@NotNull
	@Column(name = "aircraft_id")
	private String aircraftId;

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		AircraftSeat other = (AircraftSeat) obj;
		return Objects.equals(id, other.id) && Objects.equals(aircraftId, other.aircraftId);
	}

	@Override
	public int hashCode() {
		return Objects.hash(id, aircraftId);
	}
}