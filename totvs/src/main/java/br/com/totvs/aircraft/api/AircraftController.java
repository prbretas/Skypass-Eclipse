package br.com.totvs.aircraft.api;

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

import br.com.totvs.aircraft.api.dto.AlterarAircraftDTO;
import br.com.totvs.aircraft.api.dto.CriarAircraftDTO;
import br.com.totvs.aircraft.application.AircraftApplication;
import br.com.totvs.aircraft.application.command.AlterarAircraftCommand;
import br.com.totvs.aircraft.application.command.CriarAircraftCommand;
import br.com.totvs.aircraft.model.repository.AircraftRepositoryView;
import br.com.totvs.aircraft.model.repository.AircraftView;
import lombok.AllArgsConstructor;

@AllArgsConstructor
@RestController
@RequestMapping(path = "/api/v1/aircrafts")
public class AircraftController {

	@Autowired
	AircraftApplication aircraftApp;

	AircraftRepositoryView repositoryView;

	@PostMapping
	public String criar(@RequestBody CriarAircraftDTO aircraftDTO) {
		CriarAircraftCommand command = CriarAircraftCommand.builder()
				.model(aircraftDTO.getModel())
				.numSerie(aircraftDTO.getNumSerie())
				.infoSystem(aircraftDTO.getInfoSystem())
				.latitude(aircraftDTO.getLatitude())		
				.longitude(aircraftDTO.getLongitude())
				.cargoWeight(aircraftDTO.getCargoWeight())
				//ADD SEATS
				//ADD AIRLINE
				.build();

		return aircraftApp.criar(command);
	}

	@PostMapping(path = "/{id}/update")
	public ResponseEntity<Void> alterar(@PathVariable String id, @RequestBody AlterarAircraftDTO aircraftDTO) {
		AlterarAircraftCommand command = AlterarAircraftCommand.builder()
				.id(id)
				.model(aircraftDTO.getModel())
				.numSerie(aircraftDTO.getNumSerie())
				.infoSystem(aircraftDTO.getInfoSystem())
				.latitude(aircraftDTO.getLatitude())
				.longitude(aircraftDTO.getLongitude())
				.cargoWeight(aircraftDTO.getCargoWeight())
				//ADD SEATS
				//ADD AIRLINE
				.build();

		aircraftApp.alterar(command);

		return ResponseEntity.ok().build();
	}

	@PostMapping(path = "/{id}/ativar")
	public ResponseEntity<Void> ativar(@PathVariable String id) {
		aircraftApp.ativar(id);

		return ResponseEntity.ok().build();
	}

	@PostMapping(path = "/{id}/inativar")
	public ResponseEntity<Void> inativar(@PathVariable String id) {
		aircraftApp.inativar(id);

		return ResponseEntity.ok().build();
	}

	@GetMapping
	public Page<AircraftView> getAll(GetAllAircraftRequest filterRequest, Pageable pageable) {
		return this.repositoryView.findAll(filterRequest.buildSpecification(), pageable);
	}

	@GetMapping(path = "/{id}")
	public AircraftView getById(@PathVariable String id) {
		return Optional.ofNullable(this.repositoryView.findById(id, AircraftView.class)).orElseThrow();
	}
}
