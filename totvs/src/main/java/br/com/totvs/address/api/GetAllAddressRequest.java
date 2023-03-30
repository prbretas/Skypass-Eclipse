package br.com.totvs.address.api;

import static org.springframework.util.StringUtils.hasText;

import org.springframework.data.jpa.domain.Specification;

import br.com.totvs.address.model.repository.AddressSpecification;
import br.com.totvs.address.model.repository.AddressView;
import lombok.Data;

@Data
public class GetAllAddressRequest {
	private String street;
	private String city;
	private String state;
	private String stateCode;
	private String zipCode;
	private String country;
	private String searchTerm;

	public Specification<AddressView> buildSpecification() {
		Specification<AddressView> specs = Specification.where(null);

		if (hasText(this.searchTerm)) {
			specs = specs.or(AddressSpecification.queContenhaStreetCom(this.searchTerm));
			specs = specs.or(AddressSpecification.queContenhaCityCom(this.searchTerm));
			specs = specs.or(AddressSpecification.queContenhaStateCom(this.searchTerm));
			specs = specs.or(AddressSpecification.queContenhaZipCodeCom(this.searchTerm));
			specs = specs.or(AddressSpecification.queContenhaCountryCom(this.searchTerm));
		
		} else {
			if (hasText(this.street))
				specs = specs.and(AddressSpecification.queContenhaStreetCom(this.street));
			
			if (hasText(this.city))
				specs = specs.and(AddressSpecification.queContenhaCityCom(this.city));
			
			if (hasText(this.state))
				specs = specs.and(AddressSpecification.queContenhaStateCom(this.state));

			if (hasText(this.zipCode))
				specs = specs.and(AddressSpecification.queContenhaZipCodeCom(this.zipCode));
			
			if (hasText(this.country))
				specs = specs.and(AddressSpecification.queContenhaCountryCom(this.country));	
		}

		return specs;
	}
}