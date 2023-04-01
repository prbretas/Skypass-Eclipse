package br.com.totvs.airline_aircraft.api;

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

import br.com.totvs.airline_aircraft.api.dto.AlterarAirlineAircraftDTO;
import br.com.totvs.airline_aircraft.api.dto.CriarAirlineAircraftDTO;
import br.com.totvs.airline_aircraft.application.AirlineAircraftApplication;
import br.com.totvs.airline_aircraft.application.command.AlterarAirlineAircraftCommand;
import br.com.totvs.airline_aircraft.application.command.CriarAirlineAircraftCommand;
import br.com.totvs.airline_aircraft.model.repository.AirlineAircraftRepositoryView;
import br.com.totvs.airline_aircraft.model.repository.AirlineAircraftView;
import lombok.AllArgsConstructor;

@AllArgsConstructor
@RestController
@RequestMapping(path = "/api/v1/airline_aircrafts")
public class AirlineAircraftController {

	@Autowired
	AirlineAircraftApplication airline_aircraftApp;

	AirlineAircraftRepositoryView repositoryView;

	@PostMapping
	public String criar(@RequestBody CriarAirlineAircraftDTO airline_aircraftDTO) {
		CriarAirlineAircraftCommand command = CriarAirlineAircraftCommand.builder()
				.airlineId(airline_aircraftDTO.getAirlineId())
				.aircraftId(airline_aircraftDTO.getAircraftId())
				.build();

		return airline_aircraftApp.criar(command);
	}

	@PostMapping(path = "/{id}/update")
	public ResponseEntity<Void> alterar(@PathVariable String id, @RequestBody AlterarAirlineAircraftDTO airline_aircraftDTO) {
		AlterarAirlineAircraftCommand command = AlterarAirlineAircraftCommand.builder()
				.id(id)
				.airlineId(airline_aircraftDTO.getAirlineId())
				.aircraftId(airline_aircraftDTO.getAircraftId())
				.build();

		airline_aircraftApp.alterar(command);

		return ResponseEntity.ok().build();
	}

	@PostMapping(path = "/{id}/ativar")
	public ResponseEntity<Void> ativar(@PathVariable String id) {
		airline_aircraftApp.ativar(id);

		return ResponseEntity.ok().build();
	}

	@PostMapping(path = "/{id}/inativar")
	public ResponseEntity<Void> inativar(@PathVariable String id) {
		airline_aircraftApp.inativar(id);

		return ResponseEntity.ok().build();
	}

	@GetMapping
	public Page<AirlineAircraftView> getAll(GetAllAirlineAircraftRequest filterRequest, Pageable pageable) {
		return this.repositoryView.findAll(filterRequest.buildSpecification(), pageable);
	}

	@GetMapping(path = "/{id}")
	public AirlineAircraftView getById(@PathVariable String id) {
		return Optional.ofNullable(this.repositoryView.findById(id, AirlineAircraftView.class)).orElseThrow();
	}
}
