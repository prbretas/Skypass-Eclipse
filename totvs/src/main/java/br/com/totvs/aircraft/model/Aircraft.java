package br.com.totvs.aircraft.model;

import static javax.persistence.FetchType.EAGER;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;

import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@Table(name = "aircraft")
public class Aircraft {
	@Id
	private String id;
	private String model;
	
	@NotBlank
	@Column(nullable = false, unique = true)
	private String numSerie;
	private String infoSystem;
	private String latitude;
	private String longitude;
	private double cargoWeight;
	private boolean ativo;
	
	@OneToMany(cascade = CascadeType.ALL, orphanRemoval = true, fetch = EAGER)
	@JoinColumn(name = "aircraft_id", nullable = false, insertable = false, updatable = false)
	private Set<AircraftSeat> seats;

	@Builder
	private Aircraft(String id,String model, String numSerie,
			String infoSystem, String latitude, String longitude,
			double cargoWeight) {
		this.id = id;
		this.model = model;
		this.numSerie = numSerie;
		this.infoSystem = infoSystem;
		this.latitude = latitude;
		this.longitude = longitude;
		this.cargoWeight = cargoWeight;
		this.ativo = true;
		//ADD LIST SEATS
		//ADD AIRLINE
		
	}
	
	public void ativar() {
		this.ativo = true;
	}
	
	public void inativar() {
		this.ativo = false;
	}
	
	public void setSeats(Set<AircraftSeat> seats) {
		if (this.seats == null)
			this.seats = new HashSet<AircraftSeat>();
		
		this.seats.clear();
		this.seats.addAll(seats);
	}
}