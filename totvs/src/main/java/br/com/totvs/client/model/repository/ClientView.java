package br.com.totvs.client.model.repository;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;
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
@Table(name = "cliente")
public class ClientView implements Serializable {
	
	private static final long serialVersionUID = -8813647313035444500L;

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
}