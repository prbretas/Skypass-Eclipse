package br.com.totvs.airline.model;

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
@IdClass(AirlineAircraftId.class)
@Table(name = "airline_aircraft")
public class AirlineAircraft {

	@Id
	private String id;

	@Id
	@NotNull
	@Column(name = "airline_id")
	private String airlineId;

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		AirlineAircraft other = (AirlineAircraft) obj;
		return Objects.equals(id, other.id) && Objects.equals(airlineId, other.airlineId);
	}

	@Override
	public int hashCode() {
		return Objects.hash(id, airlineId);
	}
}