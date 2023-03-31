package br.com.totvs.flight.application;

import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

import org.springframework.stereotype.Service;

import br.com.totvs.flight.application.command.AlterarFlightCommand;
import br.com.totvs.flight.application.command.CriarFlightCommand;
import br.com.totvs.flight.model.Flight;
import br.com.totvs.flight.model.repository.FlightRepository;
import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class FlightApplication {
	private final FlightRepository repository;

	Set<Flight> flights = new HashSet<>();

	public String criar(CriarFlightCommand criarFlightCommand) {
		Flight flight = Flight.builder().id(UUID.randomUUID().toString())
				.departureTime(criarFlightCommand.getDepartureTime())
				.arrivalTime(criarFlightCommand.getArrivalTime())
				.date(criarFlightCommand.getDate())
				.numPassengers(criarFlightCommand.getNumPassengers())
				.aircraftId(criarFlightCommand.getAircraftId())
				.departureAirportId(criarFlightCommand.getDepartureAirportId())
				.arrivalAirportId(criarFlightCommand.getArrivalAirportId())
				.build();

		this.repository.save(flight);

		return flight.getId();
	}

	public void alterar(AlterarFlightCommand alterarFlightCommand) {
		this.repository.findById(alterarFlightCommand.getId()).ifPresent(flight -> {
			flight.setDepartureTime(alterarFlightCommand.getDepartureTime());
			flight.setArrivalTime(alterarFlightCommand.getArrivalTime());
			flight.setDate(alterarFlightCommand.getDate());
			flight.setNumPassengers(alterarFlightCommand.getNumPassengers());
			flight.setAircraftId(alterarFlightCommand.getAircraftId());
			flight.setDepartureAirportId(alterarFlightCommand.getDepartureAirportId());
			flight.setArrivalAirportId(alterarFlightCommand.getArrivalAirportId());
			
			this.repository.save(flight);
		});
	}

	public void ativar(String id) {
		this.repository.findById(id).ifPresent(flight -> {
			flight.ativar();

			this.repository.save(flight);
		});
	}

	public void inativar(String id) {
		this.repository.findById(id).ifPresent(flight -> {
			flight.inativar();

			this.repository.save(flight);
		});
	}
}