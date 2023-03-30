package br.com.totvs.client.application.command;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class CriarClientCommand {
	private String userName;
	private String name;
	private String lastName;
	private String numReg;
	private String phone;
	private String email;
	private String password;
	private String birthdate;
	private String addressId;
}
