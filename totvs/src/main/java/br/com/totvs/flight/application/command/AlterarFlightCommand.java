package br.com.totvs.flight.application.command;

import java.util.Set;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class AlterarFlightCommand {
	private String id;
	private String departureTime;
	private String arrivalTime;
	private String date;
	private String numPassengers; 
	private String aircraftId;  
	private String departureAirportId;
	private String arrivalAirportId;
	private Set<String> tickets;
	
}