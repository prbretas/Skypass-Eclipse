package br.com.totvs.aircraft.application;

import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

import org.springframework.stereotype.Service;

import br.com.totvs.aircraft.application.command.AlterarAircraftCommand;
import br.com.totvs.aircraft.application.command.CriarAircraftCommand;
import br.com.totvs.aircraft.model.Aircraft;
import br.com.totvs.aircraft.model.repository.AircraftRepository;
import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class AircraftApplication {
	private final AircraftRepository repository;

	Set<Aircraft> aircrafts = new HashSet<>();

	public String criar(CriarAircraftCommand criarAircraftCommand) {
		Aircraft aircraft = Aircraft.builder().id(UUID.randomUUID().toString())
				.model(criarAircraftCommand.getModel())
				.numSerie(criarAircraftCommand.getNumSerie())
				.infoSystem(criarAircraftCommand.getInfoSystem())
				.latitude(criarAircraftCommand.getLatitude())	
				.longitude(criarAircraftCommand.getLongitude())
				.cargoWeight(criarAircraftCommand.getCargoWeight())
				//ADD SEATS
				//ADD AIRLINE
				.build();

		this.repository.save(aircraft);
		return aircraft.getId();
	}

	public void alterar(AlterarAircraftCommand alterarAircraftCommand) {
		this.repository.findById(alterarAircraftCommand.getId()).ifPresent(aircraft -> {
			aircraft.setModel(alterarAircraftCommand.getModel());
			aircraft.setNumSerie(alterarAircraftCommand.getNumSerie());
			aircraft.setInfoSystem(alterarAircraftCommand.getInfoSystem());
			aircraft.setLatitude(alterarAircraftCommand.getLatitude());
			aircraft.setLongitude(alterarAircraftCommand.getLongitude());
			aircraft.setCargoWeight(alterarAircraftCommand.getCargoWeight());
			//ADD SEATS
			//ADD AIRLINE
			this.repository.save(aircraft);
		});
	}

	public void ativar(String id) {
		this.repository.findById(id).ifPresent(aircraft -> {
			aircraft.ativar();

			this.repository.save(aircraft);
		});
	}

	public void inativar(String id) {
		this.repository.findById(id).ifPresent(aircraft -> {
			aircraft.inativar();

			this.repository.save(aircraft);
		});
	}
}