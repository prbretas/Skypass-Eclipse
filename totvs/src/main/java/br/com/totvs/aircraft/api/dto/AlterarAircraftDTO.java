package br.com.totvs.aircraft.api.dto;

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
public class AlterarAircraftDTO {
	private String model;
	private String numSerie;
	private String infoSystem;
	private String latitude;
	private String longitude;
	private double cargoWeight;
	private Set<String> listaSeat;
}