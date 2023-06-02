package br.com.totvs.flight.application;

import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

import org.springframework.stereotype.Service;

import br.com.totvs.flight.model.FlightTicket;
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
		var flightId = UUID.randomUUID().toString();
		
		Flight flight = Flight.builder()
				.id(flightId)
				.departureTime(criarFlightCommand.getDepartureTime())
				.arrivalTime(criarFlightCommand.getArrivalTime())
				.date(criarFlightCommand.getDate())
				.numPassengers(criarFlightCommand.getNumPassengers())
				.aircraftId(criarFlightCommand.getAircraftId())
				.departureAirportId(criarFlightCommand.getDepartureAirportId())
				.arrivalAirportId(criarFlightCommand.getArrivalAirportId())
				.build();
		
		Set<FlightTicket> listaTicket = new HashSet<>();
		criarFlightCommand.getTickets().stream().forEach(ticket -> {
			listaTicket.add(FlightTicket.of(ticket, flightId));
		});
		flight.setTickets(listaTicket);
	
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
			
			Set<FlightTicket> listaTicket = new HashSet<>();
			alterarFlightCommand.getTickets().stream().forEach(ticket -> {
				listaTicket.add(FlightTicket.of(ticket, flight.getId()));
			});
			flight.setTickets(listaTicket);
				
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