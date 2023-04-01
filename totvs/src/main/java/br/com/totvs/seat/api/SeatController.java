package br.com.totvs.seat.api;

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

import br.com.totvs.seat.api.dto.AlterarSeatDTO;
import br.com.totvs.seat.api.dto.CriarSeatDTO;
import br.com.totvs.seat.application.SeatApplication;
import br.com.totvs.seat.application.command.AlterarSeatCommand;
import br.com.totvs.seat.application.command.CriarSeatCommand;
import br.com.totvs.seat.model.repository.SeatRepositoryView;
import br.com.totvs.seat.model.repository.SeatView;
import lombok.AllArgsConstructor;

@AllArgsConstructor
@RestController
@RequestMapping(path = "/api/v1/seats")
public class SeatController {

	@Autowired
	SeatApplication seatApp;

	private final SeatRepositoryView repositoryView;

	@PostMapping
	public String criar(@RequestBody CriarSeatDTO seatDTO) {
		CriarSeatCommand command = CriarSeatCommand.builder()
				.seatName(seatDTO.getSeatName())
				.category(seatDTO.getCategory())
				.build();

		return seatApp.criar(command);
	}

	@PostMapping(path = "/{id}/update")
	public ResponseEntity<Void> alterar(@PathVariable String id, @RequestBody AlterarSeatDTO seatDTO) {
		AlterarSeatCommand command = AlterarSeatCommand.builder()
				.id(id)
				.seatName(seatDTO.getSeatName())
				.category(seatDTO.getCategory())		
				.build();

		seatApp.alterar(command);

		return ResponseEntity.ok().build();
	}

	@PostMapping(path = "/{id}/ativar")
	public ResponseEntity<Void> ativar(@PathVariable String id) {
		seatApp.ativar(id);

		return ResponseEntity.ok().build();
	}

	@PostMapping(path = "/{id}/inativar")
	public ResponseEntity<Void> inativar(@PathVariable String id) {
		seatApp.inativar(id);

		return ResponseEntity.ok().build();
	}

	@GetMapping
	public Page<SeatView> getAll(GetAllSeatRequest filterRequest, Pageable pageable) {
		return this.repositoryView.findAll(filterRequest.buildSpecification(), pageable);
	}

	@GetMapping(path = "/{id}")
	public SeatView getById(@PathVariable String id) {
		return Optional.ofNullable(this.repositoryView.findById(id, SeatView.class)).orElseThrow();
	}
}
