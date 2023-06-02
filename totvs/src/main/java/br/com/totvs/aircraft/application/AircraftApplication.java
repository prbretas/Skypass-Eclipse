package br.com.totvs.aircraft.application;

import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

import org.springframework.stereotype.Service;

import br.com.totvs.aircraft.application.command.AlterarAircraftCommand;
import br.com.totvs.aircraft.application.command.CriarAircraftCommand;
import br.com.totvs.aircraft.model.Aircraft;
import br.com.totvs.aircraft.model.AircraftSeat;
import br.com.totvs.aircraft.model.repository.AircraftRepository;
import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class AircraftApplication {
	private final AircraftRepository repository;

	Set<Aircraft> aircrafts = new HashSet<>();

	public String criar(CriarAircraftCommand criarAircraftCommand) {
		var aircraftId = UUID.randomUUID().toString();
		
		Aircraft aircraft = Aircraft.builder()
				.id(aircraftId)
				.model(criarAircraftCommand.getModel())
				.numSerie(criarAircraftCommand.getNumSerie())
				.infoSystem(criarAircraftCommand.getInfoSystem())
				.latitude(criarAircraftCommand.getLatitude())	
				.longitude(criarAircraftCommand.getLongitude())
				.cargoWeight(criarAircraftCommand.getCargoWeight())
				.build();
		
		Set<AircraftSeat> listaSeat = new HashSet<>();
		criarAircraftCommand.getSeats().stream().forEach(seat -> {
			listaSeat.add(AircraftSeat.of(seat, aircraftId));
		});
		aircraft.setSeats(listaSeat);
		

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
			
			Set<AircraftSeat> listaSeat = new HashSet<>();
			alterarAircraftCommand.getSeats().stream().forEach(seat -> {
				listaSeat.add(AircraftSeat.of(seat, aircraft.getId()));
			});
			aircraft.setSeats(listaSeat);

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