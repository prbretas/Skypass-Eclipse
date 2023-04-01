package br.com.totvs.seat.model.repository;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.springframework.data.jpa.domain.Specification;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class SeatSpecification {
	
	public static Specification<SeatView> queContenhaSeatNameCom(String seatName) {
		return new Specification<SeatView>() {
			private static final long serialVersionUID = -6511788273173081116L;
			public Predicate toPredicate(Root<SeatView> root, CriteriaQuery<?> query, CriteriaBuilder builder) {
				return builder.like(builder.upper(root.get("seatName")), likeTerm(seatName.trim().toUpperCase()));
			}
		};
	}
	
	public static Specification<SeatView> queContenhaCategoryCom(String category) {
		return new Specification<SeatView>() {
			private static final long serialVersionUID = 6381586421283215091L;

			public Predicate toPredicate(Root<SeatView> root, CriteriaQuery<?> query, CriteriaBuilder builder) {
				return builder.equal(root.get("category"), category);
			}
		};
	}
		
	private static String likeTerm(String term) {
		return new StringBuilder().append('%').append(term).append('%').toString();
	}
}
