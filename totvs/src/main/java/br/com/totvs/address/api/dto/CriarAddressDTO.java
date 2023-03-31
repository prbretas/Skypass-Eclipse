package br.com.totvs.address.api.dto;


import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor(staticName = "of")
@NoArgsConstructor(access = AccessLevel.PRIVATE, force = true)
public class CriarAddressDTO {
	private String street;
	private int number;
	private String addInfo;
	private String city;
	private String state;
	private String stateCode;
	private String zipCode;
	private String country;
}