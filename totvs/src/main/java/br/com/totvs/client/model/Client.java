package br.com.totvs.client.model;

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
@Table(name = "client")
public class Client {
	@Id
	private String id;
	@NotBlank
    @Column(nullable = false, unique = true)
	private String userName;
	private String name;
	private String lastName;
	@NotBlank
    @Column(nullable = false, unique = true)
	private String numReg;
	private String phone;
	private String email;
	private String password;
	private String birthdate;
	private boolean ativo;
	
	private String addressId; //fk_address

	@Builder
	private Client(String id, String userName, String name,
			String lastName, String numReg,String phone, String email,
			String password, String birthdate, String addressId) {
		this.id = id;
		this.userName = userName;
		this.name = name;
		this.lastName = lastName;
		this.numReg = numReg;
		this.phone = phone;
		this.email = email;
		this.password = password;
		this.birthdate = birthdate;
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