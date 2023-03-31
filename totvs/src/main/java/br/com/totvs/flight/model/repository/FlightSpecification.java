package br.com.totvs.flight.model.repository;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.springframework.data.jpa.domain.Specification;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class FlightSpecification {
	
	public static Specification<FlightView> queContenhaDepartureTimeCom(String departureTime) {
		return new Specification<FlightView>() {
			private static final long serialVersionUID = -6511788273173081116L;
			public Predicate toPredicate(Root<FlightView> root, CriteriaQuery<?> query, CriteriaBuilder builder) {
				return builder.like(builder.upper(root.get("departureTime")), likeTerm(departureTime.trim().toUpperCase()));
			}
		};
	}
	
	public static Specification<FlightView> queContenhaArrivalTimeCom(String arrivalTime) {
		return new Specification<FlightView>() {
			private static final long serialVersionUID = -2105070315689140088L;
			public Predicate toPredicate(Root<FlightView> root, CriteriaQuery<?> query, CriteriaBuilder builder) {
				return builder.like(builder.upper(root.get("arrivalTime")), likeTerm(arrivalTime.trim().toUpperCase()));
			}
		};
	}
		
	public static Specification<FlightView> queContenhaDateCom(String date) {
		return new Specification<FlightView>() {
			private static final long serialVersionUID = 2312637368452138989L;
			public Predicate toPredicate(Root<FlightView> root, CriteriaQuery<?> query, CriteriaBuilder builder) {
				return builder.like(builder.upper(root.get("date")), likeTerm(date.trim().toUpperCase()));
			}
		};
	}
	
	public static Specification<FlightView> queContenhaAircraftIdCom(String aircraftId) {
		return new Specification<FlightView>() {
			private static final long serialVersionUID = 6625077496742149898L;

			public Predicate toPredicate(Root<FlightView> root, CriteriaQuery<?> query, CriteriaBuilder builder) {
				return builder.like(builder.upper(root.get("aircraftId")), likeTerm(aircraftId.trim().toUpperCase()));
			}
		};
	}
	
	public static Specification<FlightView> queContenhaDepartureAirportIdCom(String departureAirportId) {
		return new Specification<FlightView>() {
			private static final long serialVersionUID = 6214777485984339666L;

			public Predicate toPredicate(Root<FlightView> root, CriteriaQuery<?> query, CriteriaBuilder builder) {
				return builder.like(builder.upper(root.get("departureAirportId")), likeTerm(departureAirportId.trim().toUpperCase()));
			}
		};
	}
	
	public static Specification<FlightView> queContenhaArrivalAirportIdCom(String arrivalAirportId) {
		return new Specification<FlightView>() {
			private static final long serialVersionUID = 2899607750858570653L;

			public Predicate toPredicate(Root<FlightView> root, CriteriaQuery<?> query, CriteriaBuilder builder) {
				return builder.like(builder.upper(root.get("arrivalAirportId")), likeTerm(arrivalAirportId.trim().toUpperCase()));
			}
		};
	}
	

	private static String likeTerm(String term) {
		return new StringBuilder().append('%').append(term).append('%').toString();
	}
}
