package br.com.totvs.aircraft.model.repository;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "aircraft")
public class AircraftView implements Serializable {
	private static final long serialVersionUID = -6603195158796035142L;
	@Id
	private String id;
	private String model;
	private String numSerie;
	private String infoSystem;
	private String latitude;
	private String longitude;
	private double cargoWeight;
	
	@OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL, orphanRemoval = true)
	@JoinColumn(name = "aircraft_id")
	private Set<AircraftSeatView> seats;
}