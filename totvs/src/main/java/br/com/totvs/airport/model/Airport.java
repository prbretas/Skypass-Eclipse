package br.com.totvs.airport.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@Table(name = "airport")
public class Airport {
	@Id
	private String id;
	@NotBlank
    @Column(nullable = false, unique = true)
	private String airportName;
	@NotBlank
    @Column(nullable = false, unique = true)
	private String iataCode;
	private String phone;
	@Email
	private String email;
	private boolean ativo;
	
	private String addressId; //fk_address

	@Builder
	private Airport(String id,String airportName, String iataCode, String phone, String email, String addressId) {
		this.id = id;
		this.airportName = airportName;
		this.iataCode = iataCode;
		this.phone = phone;
		this.email = email;
		this.addressId = addressId;
		this.ativo = true;
	}
	
	public void ativar() {
		this.ativo = true;
	}
	
	public void inativar() {
		this.ativo = false;
	}
}