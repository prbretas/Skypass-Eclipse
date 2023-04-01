package br.com.totvs.airline_aircraft.model.repository;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.springframework.data.jpa.domain.Specification;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class AirlineAircraftSpecification {
	
	public static Specification<AirlineAircraftView> queContenhaAirlineIdCom(String airlineId) {
		return new Specification<AirlineAircraftView>() {
			private static final long serialVersionUID = -1727941994532826996L;

			public Predicate toPredicate(Root<AirlineAircraftView> root, CriteriaQuery<?> query, CriteriaBuilder builder) {
				return builder.like(builder.upper(root.get("airlineId")), likeTerm(airlineId.trim().toUpperCase()));
			}
		};
	}
		
	public static Specification<AirlineAircraftView> queContenhaAircraftIdCom(String aircraftId) {
		return new Specification<AirlineAircraftView>() {
			private static final long serialVersionUID = -1139245463344744603L;

			public Predicate toPredicate(Root<AirlineAircraftView> root, CriteriaQuery<?> query, CriteriaBuilder builder) {
				return builder.like(builder.upper(root.get("aircraftId")), likeTerm(aircraftId.trim().toUpperCase()));
			}
		};
	}
	
	private static String likeTerm(String term) {
		return new StringBuilder().append('%').append(term).append('%').toString();
	}
}
