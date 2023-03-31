package br.com.totvs.airline.api.dto;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor(staticName = "of")
@NoArgsConstructor(access = AccessLevel.PRIVATE, force = true)
public class AlterarAirlineDTO {
	private String companyName;
	private String numReg;
	private String phone;
	private String email;
	private String addressId;
	//INCLUIR LISTA DE AIRCRAFTS
}