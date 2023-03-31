package br.com.totvs.flight.api.dto;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor(staticName = "of")
@NoArgsConstructor(access = AccessLevel.PRIVATE, force = true)
public class AlterarFlightDTO {
	private String departureTime;
	private String arrivalTime;
	private String date;
	private String numPassengers; 
	private String aircraftId;  
	private String departureAirportId;
	private String arrivalAirportId;
	
}