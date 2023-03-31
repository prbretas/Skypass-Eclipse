package br.com.totvs.airport.application.command;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class AlterarAirportCommand {
	private String id;
	private String companyName;
	private String numReg;
	private String phone;
	private String email;
	private String addressId;
}