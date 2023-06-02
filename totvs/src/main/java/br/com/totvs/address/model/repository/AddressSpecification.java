package br.com.totvs.address.model.repository;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.springframework.data.jpa.domain.Specification;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class AddressSpecification {
	
	public static Specification<AddressView> queContenhaStreetCom(String street) {
		return new Specification<AddressView>() {

			private static final long serialVersionUID = 6812808606555874411L;

			public Predicate toPredicate(Root<AddressView> root, CriteriaQuery<?> query, CriteriaBuilder builder) {
				return builder.like(builder.upper(root.get("street")), likeTerm(street.trim().toUpperCase()));
			}
		};
	}
		
	public static Specification<AddressView> queContenhaCityCom(String city) {
		return new Specification<AddressView>() {
			private static final long serialVersionUID = 6239255138715697522L;

			public Predicate toPredicate(Root<AddressView> root, CriteriaQuery<?> query, CriteriaBuilder builder) {
				return builder.like(builder.upper(root.get("city")), likeTerm(city.trim().toUpperCase()));
			}
		};
	}
		
	public static Specification<AddressView> queContenhaStateCom(String state) {
		return new Specification<AddressView>() {
			
			private static final long serialVersionUID = 2209862599175835673L;

			public Predicate toPredicate(Root<AddressView> root, CriteriaQuery<?> query, CriteriaBuilder builder) {
				return builder.like(builder.upper(root.get("state")), likeTerm(state.trim().toUpperCase()));
			}
		};
	}

	public static Specification<AddressView> queContenhaZipCodeCom(String zipCode) {
		return new Specification<AddressView>() {
			
			private static final long serialVersionUID = -1910711168376979490L;

			public Predicate toPredicate(Root<AddressView> root, CriteriaQuery<?> query, CriteriaBuilder builder) {
				return builder.like(builder.upper(root.get("zipCode")), likeTerm(zipCode.trim().toUpperCase()));
			}
		};
	}
	
	public static Specification<AddressView> queContenhaCountryCom(String country) {
		return new Specification<AddressView>() {

			private static final long serialVersionUID = -1505556416112096855L;

			public Predicate toPredicate(Root<AddressView> root, CriteriaQuery<?> query, CriteriaBuilder builder) {
				return builder.like(builder.upper(root.get("country")), likeTerm(country.trim().toUpperCase()));
			}
		};
	}
	
	private static String likeTerm(String term) {
		return new StringBuilder().append('%').append(term).append('%').toString();
	}
}
