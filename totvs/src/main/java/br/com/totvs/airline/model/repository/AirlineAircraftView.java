package br.com.totvs.airline.model.repository;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.ConstraintMode;
import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import org.hibernate.annotations.DynamicUpdate;
import org.hibernate.annotations.NotFound;
import org.hibernate.annotations.NotFoundAction;

import com.fasterxml.jackson.annotation.JsonUnwrapped;

import br.com.totvs.aircraft.model.repository.AircraftView;
import br.com.totvs.airline.model.AirlineAircraftId;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@DynamicUpdate
@IdClass(AirlineAircraftId.class)
@Table(name = "airline_aircraft")
public class AirlineAircraftView implements Serializable {
	private static final long serialVersionUID = 2713761454318830623L;

	@Id
	private String id;

	@Id
	@NotNull
	@Column(name = "airline_id")
	private String airlineId;

	@OneToOne
	@NotFound(action = NotFoundAction.IGNORE)
	@JoinColumn(name = "id", referencedColumnName = "id", foreignKey = @ForeignKey(value = ConstraintMode.NO_CONSTRAINT), insertable = false, updatable = false)
	@JsonUnwrapped
	private AircraftView aircraft;
}