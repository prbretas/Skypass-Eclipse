package br.com.totvs.airport.api;

import static org.springframework.util.StringUtils.hasText;

import org.springframework.data.jpa.domain.Specification;

import br.com.totvs.airport.model.repository.AirportSpecification;
import br.com.totvs.airport.model.repository.AirportView;
import lombok.Data;

@Data
public class GetAllAirportRequest {
	private String companyName;
	private String numReg;
	private String phone;
	private String email;
	private String searchTerm;

	public Specification<AirportView> buildSpecification() {
		Specification<AirportView> specs = Specification.where(null);

		if (hasText(this.searchTerm)) {
			specs = specs.or(AirportSpecification.queContenhaCompanyNameCom(this.searchTerm));
			specs = specs.or(AirportSpecification.queContenhaNumRegCom(this.searchTerm));
			specs = specs.or(AirportSpecification.queContenhaPhoneCom(this.searchTerm));
			specs = specs.or(AirportSpecification.queContenhaEmailCom(this.searchTerm));
		
		
		} else {
			if (hasText(this.companyName))
				specs = specs.and(AirportSpecification.queContenhaCompanyNameCom(this.companyName));
			
			if (hasText(this.numReg))
				specs = specs.and(AirportSpecification.queContenhaNumRegCom(this.numReg));
			
			if (hasText(this.phone))
				specs = specs.and(AirportSpecification.queContenhaPhoneCom(this.phone));

			if (hasText(this.email))
				specs = specs.and(AirportSpecification.queContenhaEmailCom(this.email));
			
		}

		return specs;
	}
}