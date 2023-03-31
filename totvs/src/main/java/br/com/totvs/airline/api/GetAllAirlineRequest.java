package br.com.totvs.airline.api;

import static org.springframework.util.StringUtils.hasText;

import org.springframework.data.jpa.domain.Specification;

import br.com.totvs.airline.model.repository.AirlineSpecification;
import br.com.totvs.airline.model.repository.AirlineView;
import lombok.Data;

@Data
public class GetAllAirlineRequest {
	private String companyName;
	private String numReg;
	private String phone;
	private String email;
	private String searchTerm;

	public Specification<AirlineView> buildSpecification() {
		Specification<AirlineView> specs = Specification.where(null);

		if (hasText(this.searchTerm)) {
			specs = specs.or(AirlineSpecification.queContenhaCompanyNameCom(this.searchTerm));
			specs = specs.or(AirlineSpecification.queContenhaNumRegCom(this.searchTerm));
			specs = specs.or(AirlineSpecification.queContenhaPhoneCom(this.searchTerm));
			specs = specs.or(AirlineSpecification.queContenhaEmailCom(this.searchTerm));
		
		
		} else {
			if (hasText(this.companyName))
				specs = specs.and(AirlineSpecification.queContenhaCompanyNameCom(this.companyName));
			
			if (hasText(this.numReg))
				specs = specs.and(AirlineSpecification.queContenhaNumRegCom(this.numReg));
			
			if (hasText(this.phone))
				specs = specs.and(AirlineSpecification.queContenhaPhoneCom(this.phone));

			if (hasText(this.email))
				specs = specs.and(AirlineSpecification.queContenhaEmailCom(this.email));
			
		}

		return specs;
	}
}