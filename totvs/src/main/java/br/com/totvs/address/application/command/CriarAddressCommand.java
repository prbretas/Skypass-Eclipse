package br.com.totvs.address.application.command;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class CriarAddressCommand {
	private String street;
	private int number;
	private String addInfo;
	private String city;
	private String state;
	private String stateCode;
	private String zipCode;
	private String country;
}
