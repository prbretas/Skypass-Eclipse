package br.com.totvs.airline.api;

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

import br.com.totvs.airline.api.dto.AlterarAirlineDTO;
import br.com.totvs.airline.api.dto.CriarAirlineDTO;
import br.com.totvs.airline.application.AirlineApplication;
import br.com.totvs.airline.application.command.AlterarAirlineCommand;
import br.com.totvs.airline.application.command.CriarAirlineCommand;
import br.com.totvs.airline.model.repository.AirlineRepositoryView;
import br.com.totvs.airline.model.repository.AirlineView;
import lombok.AllArgsConstructor;

@AllArgsConstructor
@RestController
@RequestMapping(path = "/api/v1/airlines")
public class AirlineController {

	@Autowired
	AirlineApplication airlineApp;

	AirlineRepositoryView repositoryView;

	@PostMapping
	public String criar(@RequestBody CriarAirlineDTO airlineDTO) {
		CriarAirlineCommand command = CriarAirlineCommand.builder()
				.companyName(airlineDTO.getCompanyName())
				.numReg(airlineDTO.getNumReg())
				.phone(airlineDTO.getPhone())
				.email(airlineDTO.getEmail())
				.addresses(airlineDTO.getListaAddress())
				.aircrafts(airlineDTO.getListaAircraft())
				.build();

		return airlineApp.criar(command);
	}

	@PostMapping(path = "/{id}/update")
	public ResponseEntity<Void> alterar(@PathVariable String id, @RequestBody AlterarAirlineDTO airlineDTO) {
		AlterarAirlineCommand command = AlterarAirlineCommand.builder()
				.id(id)
				.companyName(airlineDTO.getCompanyName())
				.numReg(airlineDTO.getNumReg())
				.phone(airlineDTO.getPhone())
				.email(airlineDTO.getEmail())
				.addresses(airlineDTO.getListaAddress())
				.aircrafts(airlineDTO.getListaAircraft())
				.build();

		airlineApp.alterar(command);

		return ResponseEntity.ok().build();
	}

	@PostMapping(path = "/{id}/ativar")
	public ResponseEntity<Void> ativar(@PathVariable String id) {
		airlineApp.ativar(id);

		return ResponseEntity.ok().build();
	}

	@PostMapping(path = "/{id}/inativar")
	public ResponseEntity<Void> inativar(@PathVariable String id) {
		airlineApp.inativar(id);

		return ResponseEntity.ok().build();
	}

	@GetMapping
	public Page<AirlineView> getAll(GetAllAirlineRequest filterRequest, Pageable pageable) {
		return this.repositoryView.findAll(filterRequest.buildSpecification(), pageable);
	}

	@GetMapping(path = "/{id}")
	public AirlineView getById(@PathVariable String id) {
		return Optional.ofNullable(this.repositoryView.findById(id, AirlineView.class)).orElseThrow();
	}
}
