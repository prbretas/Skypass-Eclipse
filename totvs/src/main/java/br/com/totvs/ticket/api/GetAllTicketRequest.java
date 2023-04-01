package br.com.totvs.ticket.api;

import static org.springframework.util.StringUtils.hasText;

import org.springframework.data.jpa.domain.Specification;

import br.com.totvs.ticket.model.repository.TicketSpecification;
import br.com.totvs.ticket.model.repository.TicketView;
import lombok.Data;

@Data
public class GetAllTicketRequest {
	private String amountLuggage;
	private String weightLuggage;
	private String date;
	private String ticketPrice;
	private String searchTerm;

	public Specification<TicketView> buildSpecification() {
		Specification<TicketView> specs = Specification.where(null);

		if (hasText(this.searchTerm)) {
			specs = specs.or(TicketSpecification.queContenhaAmountLuggageCom(this.searchTerm));
			specs = specs.or(TicketSpecification.queContenhaWeightLuggageCom(this.searchTerm));
			specs = specs.or(TicketSpecification.queContenhaDateCom(this.searchTerm));
			specs = specs.or(TicketSpecification.queContenhaTicketPriceCom(this.searchTerm));
		
		
		} else {
			if (hasText(this.amountLuggage))
				specs = specs.and(TicketSpecification.queContenhaAmountLuggageCom(this.amountLuggage));
			
			if (hasText(this.weightLuggage))
				specs = specs.and(TicketSpecification.queContenhaWeightLuggageCom(this.weightLuggage));

			if (hasText(this.date))
				specs = specs.and(TicketSpecification.queContenhaDateCom(this.date));
			
			if (hasText(this.ticketPrice))
				specs = specs.and(TicketSpecification.queContenhaTicketPriceCom(this.ticketPrice));
			

			}

		return specs;
	}
}