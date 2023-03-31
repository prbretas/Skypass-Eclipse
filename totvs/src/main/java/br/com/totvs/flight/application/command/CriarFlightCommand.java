package br.com.totvs.flight.application.command;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class CriarFlightCommand {
	private String departureTime;
	private String arrivalTime;
	private String date;
	private String numPassengers; 
	private String aircraftId;  
	private String departureAirportId;
	private String arrivalAirportId;
}
