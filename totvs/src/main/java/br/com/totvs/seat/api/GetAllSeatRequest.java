package br.com.totvs.seat.api;

import static org.springframework.util.StringUtils.hasText;

import org.springframework.data.jpa.domain.Specification;

import br.com.totvs.seat.model.repository.SeatSpecification;
import br.com.totvs.seat.model.repository.SeatView;
import lombok.Data;

@Data
public class GetAllSeatRequest {
	private String seatName;
	private String category;
	private String searchTerm;

	public Specification<SeatView> buildSpecification() {
		Specification<SeatView> specs = Specification.where(null);

		if (hasText(this.searchTerm)) {
			specs = specs.or(SeatSpecification.queContenhaSeatNameCom(this.searchTerm));
			specs = specs.or(SeatSpecification.queContenhaCategoryCom(this.searchTerm));
	
		} else {
			if (hasText(this.seatName))
				specs = specs.and(SeatSpecification.queContenhaSeatNameCom(this.seatName));
			
			if (hasText(this.category))
				specs = specs.and(SeatSpecification.queContenhaCategoryCom(this.category));
			}
		return specs;
	}
}