package br.com.totvs.airline.api.dto;

import java.util.Set;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor(staticName = "of")
@NoArgsConstructor(access = AccessLevel.PRIVATE, force = true)
public class CriarAirlineDTO {
	private String companyName;
	private String numReg;
	private String phone;
	private String email;
	private String addressId;
	private Set<String> listaAircraft;
}