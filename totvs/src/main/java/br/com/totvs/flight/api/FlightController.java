package br.com.totvs.flight.api;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.totvs.flight.api.dto.AlterarFlightDTO;
import br.com.totvs.flight.api.dto.CriarFlightDTO;
import br.com.totvs.flight.application.FlightApplication;
import br.com.totvs.flight.application.command.AlterarFlightCommand;
import br.com.totvs.flight.application.command.CriarFlightCommand;
import br.com.totvs.flight.model.repository.FlightRepositoryView;
import br.com.totvs.flight.model.repository.FlightView;
import lombok.AllArgsConstructor;

@AllArgsConstructor
@RestController
@RequestMapping(path = "/api/v1/flights")
public class FlightController {

	@Autowired
	FlightApplication flightApp;

	private final FlightRepositoryView repositoryView;

	@PostMapping
	public String criar(@RequestBody CriarFlightDTO flightDTO) {
		CriarFlightCommand command = CriarFlightCommand.builder()
				.departureTime(flightDTO.getDepartureTime())
				.arrivalTime(flightDTO.getArrivalTime())
				.date(flightDTO.getDate())
				.numPassengers(flightDTO.getNumPassengers())
				.aircraftId(flightDTO.getAircraftId())
				.departureAirportId(flightDTO.getDepartureAirportId())
				.arrivalAirportId(flightDTO.getArrivalAirportId())
				.tickets(flightDTO.getListaTicket())
				.build();

		return flightApp.criar(command);
	}

	@PostMapping(path = "/{id}/update")
	public ResponseEntity<Void> alterar(@PathVariable String id, @RequestBody AlterarFlightDTO flightDTO) {
		AlterarFlightCommand command = AlterarFlightCommand.builder()
				.id(id)
				.departureTime(flightDTO.getDepartureTime())
				.arrivalTime(flightDTO.getArrivalTime())
				.date(flightDTO.getDate())
				.numPassengers(flightDTO.getNumPassengers())
				.aircraftId(flightDTO.getAircraftId())
				.departureAirportId(flightDTO.getDepartureAirportId())
				.arrivalAirportId(flightDTO.getArrivalAirportId())	
				.tickets(flightDTO.getListaTicket())
				.build();

		flightApp.alterar(command);

		return ResponseEntity.ok().build();
	}

	@PostMapping(path = "/{id}/ativar")
	public ResponseEntity<Void> ativar(@PathVariable String id) {
		flightApp.ativar(id);

		return ResponseEntity.ok().build();
	}

	@PostMapping(path = "/{id}/inativar")
	public ResponseEntity<Void> inativar(@PathVariable String id) {
		flightApp.inativar(id);

		return ResponseEntity.ok().build();
	}

	@GetMapping
	public Page<FlightView> getAll(GetAllFlightRequest filterRequest, Pageable pageable) {
		return this.repositoryView.findAll(filterRequest.buildSpecification(), pageable);
	}

	@GetMapping(path = "/{id}")
	public FlightView getById(@PathVariable String id) {
		return Optional.ofNullable(this.repositoryView.findById(id, FlightView.class)).orElseThrow();
	}
}
