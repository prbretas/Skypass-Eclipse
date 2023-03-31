package br.com.totvs.airline.model.repository;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.springframework.data.jpa.domain.Specification;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class AirlineSpecification {
	
	public static Specification<AirlineView> queContenhaCompanyNameCom(String companyName) {
		return new Specification<AirlineView>() {

			private static final long serialVersionUID = -2152102211884913166L;

			public Predicate toPredicate(Root<AirlineView> root, CriteriaQuery<?> query, CriteriaBuilder builder) {
				return builder.like(builder.upper(root.get("companyName")), likeTerm(companyName.trim().toUpperCase()));
			}
		};
	}
	
		
	public static Specification<AirlineView> queContenhaNumRegCom(String numReg) {
		return new Specification<AirlineView>() {

			private static final long serialVersionUID = 1110943931371013169L;

			public Predicate toPredicate(Root<AirlineView> root, CriteriaQuery<?> query, CriteriaBuilder builder) {
				return builder.like(builder.upper(root.get("numReg")), likeTerm(numReg.trim().toUpperCase()));
			}
		};
	}
		
	public static Specification<AirlineView> queContenhaPhoneCom(String phone) {
		return new Specification<AirlineView>() {

			private static final long serialVersionUID = -8004274870509890272L;

			public Predicate toPredicate(Root<AirlineView> root, CriteriaQuery<?> query, CriteriaBuilder builder) {
				return builder.like(builder.upper(root.get("phone")), likeTerm(phone.trim().toUpperCase()));
			}
		};
	}

	public static Specification<AirlineView> queContenhaEmailCom(String email) {
		return new Specification<AirlineView>() {
			
			private static final long serialVersionUID = -1953330972125926784L;

			public Predicate toPredicate(Root<AirlineView> root, CriteriaQuery<?> query, CriteriaBuilder builder) {
				return builder.like(builder.upper(root.get("email")), likeTerm(email.trim().toUpperCase()));
			}
		};
	}
	
	
	private static String likeTerm(String term) {
		return new StringBuilder().append('%').append(term).append('%').toString();
	}
}
