package br.com.totvs.aircraft.application.command;

import java.util.Set;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class CriarAircraftCommand {
	private String model;
	private String numSerie;
	private String infoSystem;
	private String latitude;
	private String longitude;
	private double cargoWeight;
	private Set<String> seats;
}
