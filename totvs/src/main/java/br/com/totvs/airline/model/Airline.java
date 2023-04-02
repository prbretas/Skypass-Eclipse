package br.com.totvs.airline.model;

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
@Table(name = "airline")
public class Airline {
	@Id
	private String id;
	@NotBlank
	@Column(nullable = false, unique = true)
	private String companyName;
	@NotBlank
	@Column(nullable = false, unique = true)
	private String numReg;
	private String phone;
	@Email
	private String email;
	private boolean ativo;
	
	private String addressId;

	@Builder
	private Airline(String id,String companyName, String numReg, String phone, String email, String addressId) {
		this.id = id;
		this.companyName = companyName;
		this.numReg = numReg;
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