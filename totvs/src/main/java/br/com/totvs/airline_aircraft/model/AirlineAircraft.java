package br.com.totvs.airline_aircraft.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@Table(name = "airline_aircraft")
public class AirlineAircraft {
	
	@Id
	private String id;
	private String airlineId;
	private String aircraftId;
	private boolean ativo;
	
	
	//INCLUIR A LISTA DE AIRCRAFTS

	@Builder
	private AirlineAircraft(String id, String airlineId, String aircraftId) {
		this.id = id;
		this.airlineId = airlineId;
		this.aircraftId = aircraftId;
		this.ativo = true;
	}
	
	public void ativar() {
		this.ativo = true;
	}
	
	public void inativar() {
		this.ativo = false;
	}
}