package br.com.totvs.flight.api;

import static org.springframework.util.StringUtils.hasText;

import org.springframework.data.jpa.domain.Specification;

import br.com.totvs.flight.model.repository.FlightSpecification;
import br.com.totvs.flight.model.repository.FlightView;
import lombok.Data;

@Data
public class GetAllFlightRequest {
	private String departureTime;
	private String arrivalTime;
	private String date;
	private String aircraftId; 
	private String departureAirportId;
	private String arrivalAirportId;
	private String searchTerm;

	public Specification<FlightView> buildSpecification() {
		Specification<FlightView> specs = Specification.where(null);

		if (hasText(this.searchTerm)) {
			specs = specs.or(FlightSpecification.queContenhaDepartureTimeCom(this.searchTerm));
			specs = specs.or(FlightSpecification.queContenhaArrivalTimeCom(this.searchTerm));
			specs = specs.or(FlightSpecification.queContenhaDateCom(this.searchTerm));
			specs = specs.or(FlightSpecification.queContenhaAircraftIdCom(this.searchTerm));
			specs = specs.or(FlightSpecification.queContenhaDepartureAirportIdCom(this.searchTerm));
			specs = specs.or(FlightSpecification.queContenhaArrivalAirportIdCom(this.searchTerm));
	
		} else {
			if (hasText(this.departureTime))
				specs = specs.and(FlightSpecification.queContenhaDepartureTimeCom(this.departureTime));
			
			if (hasText(this.arrivalTime))
				specs = specs.and(FlightSpecification.queContenhaArrivalTimeCom(this.arrivalTime));
			
			if (hasText(this.date))
				specs = specs.and(FlightSpecification.queContenhaDateCom(this.date));

			if (hasText(this.aircraftId))
				specs = specs.and(FlightSpecification.queContenhaAircraftIdCom(this.aircraftId));
			
			if (hasText(this.departureAirportId))
				specs = specs.and(FlightSpecification.queContenhaDepartureAirportIdCom(this.departureAirportId));
			
			if (hasText(this.arrivalAirportId))
				specs = specs.and(FlightSpecification.queContenhaArrivalAirportIdCom(this.arrivalAirportId));
			}
		return specs;
	}
}