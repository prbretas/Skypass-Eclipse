package br.com.totvs.airport.api;

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

import br.com.totvs.airport.api.dto.AlterarAirportDTO;
import br.com.totvs.airport.api.dto.CriarAirportDTO;
import br.com.totvs.airport.application.AirportApplication;
import br.com.totvs.airport.application.command.AlterarAirportCommand;
import br.com.totvs.airport.application.command.CriarAirportCommand;
import br.com.totvs.airport.model.repository.AirportRepositoryView;
import br.com.totvs.airport.model.repository.AirportView;
import lombok.AllArgsConstructor;

@AllArgsConstructor
@RestController
@RequestMapping(path = "/api/v1/airports")
public class AirportController {

	@Autowired
	AirportApplication airportApp;

	AirportRepositoryView repositoryView;

	@PostMapping
	public String criar(@RequestBody CriarAirportDTO airportDTO) {
		CriarAirportCommand command = CriarAirportCommand.builder()
				.airportName(airportDTO.getAirportName())
				.iataCode(airportDTO.getIataCode())
				.phone(airportDTO.getPhone())
				.email(airportDTO.getEmail())		
				.addressId(airportDTO.getAddressId())
				.build();

		return airportApp.criar(command);
	}

	@PostMapping(path = "/{id}/update")
	public ResponseEntity<Void> alterar(@PathVariable String id, @RequestBody AlterarAirportDTO airportDTO) {
		AlterarAirportCommand command = AlterarAirportCommand.builder()
				.id(id)
				.airportName(airportDTO.getAirportName())
				.iataCode(airportDTO.getIataCode())
				.phone(airportDTO.getPhone())
				.email(airportDTO.getEmail())
				.addressId(airportDTO.getAddressId())
				.build();

		airportApp.alterar(command);

		return ResponseEntity.ok().build();
	}

	@PostMapping(path = "/{id}/ativar")
	public ResponseEntity<Void> ativar(@PathVariable String id) {
		airportApp.ativar(id);

		return ResponseEntity.ok().build();
	}

	@PostMapping(path = "/{id}/inativar")
	public ResponseEntity<Void> inativar(@PathVariable String id) {
		airportApp.inativar(id);

		return ResponseEntity.ok().build();
	}

	@GetMapping
	public Page<AirportView> getAll(GetAllAirportRequest filterRequest, Pageable pageable) {
		return this.repositoryView.findAll(filterRequest.buildSpecification(), pageable);
	}

	@GetMapping(path = "/{id}")
	public AirportView getById(@PathVariable String id) {
		return Optional.ofNullable(this.repositoryView.findById(id, AirportView.class)).orElseThrow();
	}
}
