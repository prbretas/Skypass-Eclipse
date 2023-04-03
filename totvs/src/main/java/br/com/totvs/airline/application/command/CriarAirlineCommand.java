package br.com.totvs.airline.application.command;

import java.util.Set;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class CriarAirlineCommand {
	private String companyName;
	private String numReg;
	private String phone;
	private String email;
	private String addressId;
	private Set<String> aircrafts;
}