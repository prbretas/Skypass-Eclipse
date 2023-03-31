package br.com.totvs.aircraft.api.dto;


import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor(staticName = "of")
@NoArgsConstructor(access = AccessLevel.PRIVATE, force = true)
public class CriarAircraftDTO {
	private String model;
	private String numSerie;
	private String infoSystem;
	private String latitude;
	private String longitude;
	private double cargoWeight;
	//ADD LISTA DE SEATS
	//ADD AIRLINE
}