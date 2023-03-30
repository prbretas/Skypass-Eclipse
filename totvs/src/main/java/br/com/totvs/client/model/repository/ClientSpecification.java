package br.com.totvs.client.model.repository;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.springframework.data.jpa.domain.Specification;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class ClientSpecification {
	
	public static Specification<ClientView> queContenhaUserNameCom(String userName) {
		return new Specification<ClientView>() {
			private static final long serialVersionUID = 4451395911759887462L;

			public Predicate toPredicate(Root<ClientView> root, CriteriaQuery<?> query, CriteriaBuilder builder) {
				return builder.like(builder.upper(root.get("userName")), likeTerm(userName.trim().toUpperCase()));
			}
		};
	}
	
	public static Specification<ClientView> queContenhaNameCom(String name) {
		return new Specification<ClientView>() {
			private static final long serialVersionUID = -1959210750393180992L;

			public Predicate toPredicate(Root<ClientView> root, CriteriaQuery<?> query, CriteriaBuilder builder) {
				return builder.like(builder.upper(root.get("name")), likeTerm(name.trim().toUpperCase()));
			}
		};
	}
		
	public static Specification<ClientView> queContenhaLastNameCom(String lastName) {
		return new Specification<ClientView>() {
	
			private static final long serialVersionUID = 6671107574918108018L;

			public Predicate toPredicate(Root<ClientView> root, CriteriaQuery<?> query, CriteriaBuilder builder) {
				return builder.like(builder.upper(root.get("lastName")), likeTerm(lastName.trim().toUpperCase()));
			}
		};
	}
		
	public static Specification<ClientView> queContenhaNumRegCom(String numReg) {
		return new Specification<ClientView>() {
			private static final long serialVersionUID = 1328568327463966463L;

			public Predicate toPredicate(Root<ClientView> root, CriteriaQuery<?> query, CriteriaBuilder builder) {
				return builder.like(builder.upper(root.get("numReg")), likeTerm(numReg.trim().toUpperCase()));
			}
		};
	}

	public static Specification<ClientView> queContenhaPhoneCom(String phone) {
		return new Specification<ClientView>() {
			private static final long serialVersionUID = -2810378777392539835L;

			public Predicate toPredicate(Root<ClientView> root, CriteriaQuery<?> query, CriteriaBuilder builder) {
				return builder.like(builder.upper(root.get("phone")), likeTerm(phone.trim().toUpperCase()));
			}
		};
	}
	
	public static Specification<ClientView> queContenhaEmailCom(String email) {
		return new Specification<ClientView>() {
			private static final long serialVersionUID = -1813180900458686033L;

			public Predicate toPredicate(Root<ClientView> root, CriteriaQuery<?> query, CriteriaBuilder builder) {
				return builder.like(builder.upper(root.get("email")), likeTerm(email.trim().toUpperCase()));
			}
		};
	}
	
	public static Specification<ClientView> queContenhaBirthdateCom(String birthdate) {
		return new Specification<ClientView>() {
			private static final long serialVersionUID = -1813180900458686033L;

			public Predicate toPredicate(Root<ClientView> root, CriteriaQuery<?> query, CriteriaBuilder builder) {
				return builder.like(builder.upper(root.get("birthdate")), likeTerm(birthdate.trim().toUpperCase()));
			}
		};
	}
	

	private static String likeTerm(String term) {
		return new StringBuilder().append('%').append(term).append('%').toString();
	}
}
