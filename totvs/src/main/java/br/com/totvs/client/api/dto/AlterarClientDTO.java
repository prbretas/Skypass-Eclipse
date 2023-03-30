package br.com.totvs.client.api.dto;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor(staticName = "of")
@NoArgsConstructor(access = AccessLevel.PRIVATE, force = true)
public class AlterarClientDTO {
	private String userName;
	private String name;
	private String lastName;
	private String numReg;
	private String phone;
	private String email;
	private String password;
	private String birthdate;
}