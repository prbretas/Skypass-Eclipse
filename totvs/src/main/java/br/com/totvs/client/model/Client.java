package br.com.totvs.client.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@Table(name = "cliente")
public class Client {
	@Id
	private String id;
	private String userName;
	private String name;
	private String lastName;
	private String numReg;
	private String phone;
	private String email;
	private String password;
	private String birthdate;
	private boolean ativo;

	@Builder
	private Client(String id, String userName, String name, String lastName, String numReg,String phone, String email, String password, String birthdate) {
		this.id = id;
		this.userName = userName;
		this.name = name;
		this.lastName = lastName;
		this.numReg = numReg;
		this.phone = phone;
		this.email = email;
		this.password = password;
		this.birthdate = birthdate;
		this.ativo = true;
	}
	
	public void ativar() {
		this.ativo = true;
	}
	
	public void inativar() {
		this.ativo = false;
	}
}