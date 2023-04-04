package br.com.totvs.airline.model.repository;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "airline")
public class AirlineView implements Serializable {
	private static final long serialVersionUID = 9075777705759167322L;
	@Id
	private String id;
	private String companyName;
	private String numReg;
	private String phone;
	private String email;


	@OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL, orphanRemoval = true)
	@JoinColumn(name = "airline_id")
	private Set<AirlineAircraftView> aircrafts;
	
	@OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL, orphanRemoval = true)
	@JoinColumn(name = "airline_id")
	private Set<AirlineAddressView> addresses;
}