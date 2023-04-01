package br.com.totvs.airline_aircraft.model.repository;

import java.io.Serializable;

import javax.persistence.ConstraintMode;
import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.NotFound;
import org.hibernate.annotations.NotFoundAction;

import br.com.totvs.aircraft.model.repository.AircraftView;
import br.com.totvs.airline.model.repository.AirlineView;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "airline_aircraft")
public class AirlineAircraftView implements Serializable {
	private static final long serialVersionUID = -305706725568098024L;
	@Id
	private String id;
	
	@OneToMany
	@NotFound(action = NotFoundAction.IGNORE)
	@JoinColumn(name = "airlineId", referencedColumnName = "id", foreignKey = @ForeignKey(value = ConstraintMode.NO_CONSTRAINT), insertable = false, updatable = false)
	AirlineView airline;
	
	@ManyToOne
	@NotFound(action = NotFoundAction.IGNORE)
	@JoinColumn(name = "aircraftId", referencedColumnName = "id", foreignKey = @ForeignKey(value = ConstraintMode.NO_CONSTRAINT), insertable = false, updatable = false)
	AircraftView aircraft;
	

}