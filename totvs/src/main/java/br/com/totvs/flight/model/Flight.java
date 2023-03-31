package br.com.totvs.flight.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@Table(name = "flight")
public class Flight {
	@Id
	private String id;
	private String departureTime;
	private String arrivalTime;
	private String date;
	private String numPassengers; //TICKETS TRUE COM ID DO FLIGHT
	private boolean ativo;
	
	private String aircraftId;  // (FK_AIRCRAFT_FLIGHT)
	private String departureAirportId;  // (FK_AIRPORT_FLIGHT)
	private String arrivalAirportId;  // (FK_AIRPORT_FLIGHT)

	@Builder
	private Flight(String id, String departureTime, String arrivalTime,
			String date, String numPassengers,String aircraftId,
			String departureAirportId, String arrivalAirportId) {
		this.id = id;
		this.departureTime = departureTime;
		this.arrivalTime = arrivalTime;
		this.date = date;
		this.numPassengers = numPassengers;
		this.aircraftId = aircraftId;
		this.departureAirportId = departureAirportId;
		this.arrivalAirportId = arrivalAirportId;
		this.ativo = true;
	}
	
	public void ativar() {
		this.ativo = true;
	}
	
	public void inativar() {
		this.ativo = false;
	}
}