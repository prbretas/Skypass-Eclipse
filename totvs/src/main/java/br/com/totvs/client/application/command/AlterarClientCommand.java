package br.com.totvs.client.application.command;

import java.util.Set;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class AlterarClientCommand {
	private String id;
	private String userName;
	private String name;
	private String lastName;
	private String numReg;
	private String phone;
	private String email;
	private String password;
	private String birthdate;
	private String addressId;
	private Set<String> tickets;
}