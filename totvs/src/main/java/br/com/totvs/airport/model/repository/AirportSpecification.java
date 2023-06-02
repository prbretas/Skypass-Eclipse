package br.com.totvs.airport.model.repository;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.springframework.data.jpa.domain.Specification;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class AirportSpecification {
	
	public static Specification<AirportView> queContenhaAirportNameCom(String airportName) {
		return new Specification<AirportView>() {

			private static final long serialVersionUID = -3062376224830843147L;

			public Predicate toPredicate(Root<AirportView> root, CriteriaQuery<?> query, CriteriaBuilder builder) {
				return builder.like(builder.upper(root.get("airportName")), likeTerm(airportName.trim().toUpperCase()));
			}
		};
	}
			
	public static Specification<AirportView> queContenhaIataCodeCom(String iataCode) {
		return new Specification<AirportView>() {

			private static final long serialVersionUID = 6643063366410532139L;

			public Predicate toPredicate(Root<AirportView> root, CriteriaQuery<?> query, CriteriaBuilder builder) {
				return builder.like(builder.upper(root.get("iataCode")), likeTerm(iataCode.trim().toUpperCase()));
			}
		};
	}
		
	public static Specification<AirportView> queContenhaPhoneCom(String phone) {
		return new Specification<AirportView>() {

			private static final long serialVersionUID = -8004274870509890272L;

			public Predicate toPredicate(Root<AirportView> root, CriteriaQuery<?> query, CriteriaBuilder builder) {
				return builder.like(builder.upper(root.get("phone")), likeTerm(phone.trim().toUpperCase()));
			}
		};
	}

	public static Specification<AirportView> queContenhaEmailCom(String email) {
		return new Specification<AirportView>() {

			private static final long serialVersionUID = -1953330972125926784L;

			public Predicate toPredicate(Root<AirportView> root, CriteriaQuery<?> query, CriteriaBuilder builder) {
				return builder.like(builder.upper(root.get("email")), likeTerm(email.trim().toUpperCase()));
			}
		};
	}
	
	private static String likeTerm(String term) {
		return new StringBuilder().append('%').append(term).append('%').toString();
	}
}
