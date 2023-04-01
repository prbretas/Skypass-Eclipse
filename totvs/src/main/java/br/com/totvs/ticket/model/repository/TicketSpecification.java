package br.com.totvs.ticket.model.repository;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.springframework.data.jpa.domain.Specification;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class TicketSpecification {
	
	public static Specification<TicketView> queContenhaCategoryCom(String category) {
		return new Specification<TicketView>() {
			private static final long serialVersionUID = -8822706372313942406L;

			public Predicate toPredicate(Root<TicketView> root, CriteriaQuery<?> query, CriteriaBuilder builder) {
				return builder.equal(root.get("category"), category);
			}
		};
	}
	
	public static Specification<TicketView> queContenhaAmountLuggageCom(String amountLuggage) {
		return new Specification<TicketView>() {
			private static final long serialVersionUID = 5208243239467290446L;

			public Predicate toPredicate(Root<TicketView> root, CriteriaQuery<?> query, CriteriaBuilder builder) {
				return builder.equal(root.get("amountLuggage"), amountLuggage);
			}
		};
	}
		
	public static Specification<TicketView> queContenhaWeightLuggageCom(String weightLuggage) {
		return new Specification<TicketView>() {
			private static final long serialVersionUID = -7820541392450753330L;

			public Predicate toPredicate(Root<TicketView> root, CriteriaQuery<?> query, CriteriaBuilder builder) {
				return builder.equal(root.get("weightLuggage"), weightLuggage);
			}
		};
	}
	
	public static Specification<TicketView> queContenhaDateCom(String date) {
		return new Specification<TicketView>() {
			private static final long serialVersionUID = -930628243515951063L;

			public Predicate toPredicate(Root<TicketView> root, CriteriaQuery<?> query, CriteriaBuilder builder) {
				return builder.like(builder.upper(root.get("date")), likeTerm(date.trim().toUpperCase()));
			}
		};
	}
	
	public static Specification<TicketView> queContenhaTicketPriceCom(String ticketPrice) {
		return new Specification<TicketView>() {
			private static final long serialVersionUID = 5149273053539333665L;

			public Predicate toPredicate(Root<TicketView> root, CriteriaQuery<?> query, CriteriaBuilder builder) {
				return builder.equal(root.get("ticketPrice"), ticketPrice);
			}
		};
	}
		

	private static String likeTerm(String term) {
		return new StringBuilder().append('%').append(term).append('%').toString();
	}
}
