package br.com.totvs.airline_aircraft.application;

import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

import org.springframework.stereotype.Service;

import br.com.totvs.airline_aircraft.application.command.AlterarAirlineAircraftCommand;
import br.com.totvs.airline_aircraft.application.command.CriarAirlineAircraftCommand;
import br.com.totvs.airline_aircraft.model.AirlineAircraft;
import br.com.totvs.airline_aircraft.model.repository.AirlineAircraftRepository;
import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class AirlineAircraftApplication {
	private final AirlineAircraftRepository repository;

	Set<AirlineAircraft> airline_aircrafts = new HashSet<>();

	public String criar(CriarAirlineAircraftCommand criarAirlineAircraftCommand) {
		AirlineAircraft airline_aircraft = AirlineAircraft.builder().id(UUID.randomUUID().toString())
				.airlineId(criarAirlineAircraftCommand.getAirlineId())
				.aircraftId(criarAirlineAircraftCommand.getAircraftId())
				.build();

		this.repository.save(airline_aircraft);
		return airline_aircraft.getId();
	}

	public void alterar(AlterarAirlineAircraftCommand alterarAirlineAircraftCommand) {
		this.repository.findById(alterarAirlineAircraftCommand.getId()).ifPresent(airline_aircraft -> {
			airline_aircraft.setAirlineId(alterarAirlineAircraftCommand.getAirlineId());
			airline_aircraft.setAircraftId(alterarAirlineAircraftCommand.getAircraftId());
			this.repository.save(airline_aircraft);
		});
	}

	public void ativar(String id) {
		this.repository.findById(id).ifPresent(airline_aircraft -> {
			airline_aircraft.ativar();

			this.repository.save(airline_aircraft);
		});
	}

	public void inativar(String id) {
		this.repository.findById(id).ifPresent(airline_aircraft -> {
			airline_aircraft.inativar();

			this.repository.save(airline_aircraft);
		});
	}
}