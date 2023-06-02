package br.com.totvs.client.api;

import static org.springframework.util.StringUtils.hasText;

import org.springframework.data.jpa.domain.Specification;

import br.com.totvs.client.model.repository.ClientSpecification;
import br.com.totvs.client.model.repository.ClientView;
import lombok.Data;

@Data
public class GetAllClientRequest {
	private String userName;
	private String name;
	private String lastName;
	private String numReg;
	private String phone;
	private String email;
	private String password;
	private String birthdate;
	private String searchTerm;

	public Specification<ClientView> buildSpecification() {
		Specification<ClientView> specs = Specification.where(null);

		if (hasText(this.searchTerm)) {
			specs = specs.or(ClientSpecification.queContenhaUserNameCom(this.searchTerm));
			specs = specs.or(ClientSpecification.queContenhaNameCom(this.searchTerm));
			specs = specs.or(ClientSpecification.queContenhaLastNameCom(this.searchTerm));
			specs = specs.or(ClientSpecification.queContenhaNumRegCom(this.searchTerm));
			specs = specs.or(ClientSpecification.queContenhaPhoneCom(this.searchTerm));
			specs = specs.or(ClientSpecification.queContenhaEmailCom(this.searchTerm));
			specs = specs.or(ClientSpecification.queContenhaBirthdateCom(this.searchTerm));
		
		} else {
			if (hasText(this.userName))
				specs = specs.and(ClientSpecification.queContenhaUserNameCom(this.userName));
			
			if (hasText(this.name))
				specs = specs.and(ClientSpecification.queContenhaNameCom(this.name));
			
			if (hasText(this.lastName))
				specs = specs.and(ClientSpecification.queContenhaLastNameCom(this.lastName));

			if (hasText(this.numReg))
				specs = specs.and(ClientSpecification.queContenhaNumRegCom(this.numReg));
			
			if (hasText(this.phone))
				specs = specs.and(ClientSpecification.queContenhaPhoneCom(this.phone));
			
			if (hasText(this.email))
				specs = specs.and(ClientSpecification.queContenhaEmailCom(this.email));
			
			if (hasText(this.birthdate))
				specs = specs.and(ClientSpecification.queContenhaBirthdateCom(this.birthdate));
		}

		return specs;
	}
}