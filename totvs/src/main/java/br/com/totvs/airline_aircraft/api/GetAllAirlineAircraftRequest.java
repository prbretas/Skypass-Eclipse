package br.com.totvs.airline_aircraft.api;

import static org.springframework.util.StringUtils.hasText;

import org.springframework.data.jpa.domain.Specification;

import br.com.totvs.airline_aircraft.model.repository.AirlineAircraftSpecification;
import br.com.totvs.airline_aircraft.model.repository.AirlineAircraftView;
import lombok.Data;

@Data
public class GetAllAirlineAircraftRequest {
	private String airlineId;
	private String aircraftId;
	private String searchTerm;

	public Specification<AirlineAircraftView> buildSpecification() {
		Specification<AirlineAircraftView> specs = Specification.where(null);

		if (hasText(this.searchTerm)) {
			specs = specs.or(AirlineAircraftSpecification.queContenhaAirlineIdCom(this.searchTerm));
			specs = specs.or(AirlineAircraftSpecification.queContenhaAircraftIdCom(this.searchTerm));
		
		} else {
			if (hasText(this.airlineId))
				specs = specs.and(AirlineAircraftSpecification.queContenhaAirlineIdCom(this.airlineId));
			
			if (hasText(this.aircraftId))
				specs = specs.and(AirlineAircraftSpecification.queContenhaAircraftIdCom(this.aircraftId));
	
		}

		return specs;
	}
}