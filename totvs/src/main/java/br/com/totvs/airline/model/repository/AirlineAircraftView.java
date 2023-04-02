package br.com.totvs.airline.model.repository;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import org.hibernate.annotations.DynamicUpdate;

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
	private static final long serialVersionUID = 3472570579292671019L;

	@Id
	private String id;

	@Id
	@NotNull
	@Column(name = "airline_id")
	private String airlineId;
}