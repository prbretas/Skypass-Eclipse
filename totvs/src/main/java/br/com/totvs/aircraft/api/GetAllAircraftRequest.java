package br.com.totvs.aircraft.api;

import static org.springframework.util.StringUtils.hasText;

import org.springframework.data.jpa.domain.Specification;

import br.com.totvs.aircraft.model.repository.AircraftSpecification;
import br.com.totvs.aircraft.model.repository.AircraftView;
import lombok.Data;

@Data
public class GetAllAircraftRequest {
	private String model;
	private String numSerie;
	private String infoSystem;
	private String searchTerm;

	public Specification<AircraftView> buildSpecification() {
		Specification<AircraftView> specs = Specification.where(null);

		if (hasText(this.searchTerm)) {
			specs = specs.or(AircraftSpecification.queContenhaModelCom(this.searchTerm));
			specs = specs.or(AircraftSpecification.queContenhaNumSerieCom(this.searchTerm));
			specs = specs.or(AircraftSpecification.queContenhaInfoSystemCom(this.searchTerm));
		
		
		} else {
			if (hasText(this.model))
				specs = specs.and(AircraftSpecification.queContenhaModelCom(this.model));
			
			if (hasText(this.numSerie))
				specs = specs.and(AircraftSpecification.queContenhaNumSerieCom(this.numSerie));
			
			if (hasText(this.infoSystem))
				specs = specs.and(AircraftSpecification.queContenhaInfoSystemCom(this.infoSystem));
			
		}

		return specs;
	}
}