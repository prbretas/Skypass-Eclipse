package br.com.totvs.aircraft.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
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
	
	//ADD LIST SEATS - ONETOMANY
	//ADD AIRLINE - MANYTOONE

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
}