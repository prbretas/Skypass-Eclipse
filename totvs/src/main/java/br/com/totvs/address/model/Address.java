package br.com.totvs.address.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@Table(name = "address")
public class Address {
	@Id
	private String id;
	private String street;
	private int number;
	private String addInfo;
	private String city;
	private String state;
	private String stateCode;
	private String zipCode;
	private String country;
	private boolean ativo;

	@Builder
	private Address(String id,
			String street, int number, String addInfo, String city, String state,String stateCode,
			String zipCode, String country) {
		this.id = id;
		this.street = street;
		this.number = number;
		this.addInfo = addInfo;
		this.city = city;
		this.state = state;
		this.stateCode = stateCode;
		this.zipCode = zipCode;
		this.country = country;
		this.ativo = true;
	}
	
	public void ativar() {
		this.ativo = true;
	}
	
	public void inativar() {
		this.ativo = false;
	}
}