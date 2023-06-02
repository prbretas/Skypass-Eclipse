package br.com.totvs.aircraft.model.repository;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.springframework.data.jpa.domain.Specification;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class AircraftSpecification {
	
	public static Specification<AircraftView> queContenhaModelCom(String model) {
		return new Specification<AircraftView>() {

			private static final long serialVersionUID = -970190263871477033L;

			public Predicate toPredicate(Root<AircraftView> root, CriteriaQuery<?> query, CriteriaBuilder builder) {
				return builder.like(builder.upper(root.get("model")), likeTerm(model.trim().toUpperCase()));
			}
		};
	}
			
	public static Specification<AircraftView> queContenhaNumSerieCom(String numSerie) {
		return new Specification<AircraftView>() {

			private static final long serialVersionUID = 6643063366410532139L;

			public Predicate toPredicate(Root<AircraftView> root, CriteriaQuery<?> query, CriteriaBuilder builder) {
				return builder.like(builder.upper(root.get("numSerie")), likeTerm(numSerie.trim().toUpperCase()));
			}
		};
	}
		
	public static Specification<AircraftView> queContenhaInfoSystemCom(String infoSystem) {
		return new Specification<AircraftView>() {
			
			private static final long serialVersionUID = 8145086135248132807L;

			public Predicate toPredicate(Root<AircraftView> root, CriteriaQuery<?> query, CriteriaBuilder builder) {
				return builder.like(builder.upper(root.get("infoSystem")), likeTerm(infoSystem.trim().toUpperCase()));
			}
		};
	}
	
	private static String likeTerm(String term) {
		return new StringBuilder().append('%').append(term).append('%').toString();
	}
}
