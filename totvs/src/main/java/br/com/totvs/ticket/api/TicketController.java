package br.com.totvs.ticket.api;

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

import br.com.totvs.ticket.api.dto.AlterarTicketDTO;
import br.com.totvs.ticket.api.dto.CriarTicketDTO;
import br.com.totvs.ticket.application.TicketApplication;
import br.com.totvs.ticket.application.command.AlterarTicketCommand;
import br.com.totvs.ticket.application.command.CriarTicketCommand;
import br.com.totvs.ticket.model.repository.TicketRepositoryView;
import br.com.totvs.ticket.model.repository.TicketView;
import lombok.AllArgsConstructor;

@AllArgsConstructor
@RestController
@RequestMapping(path = "/api/v1/tickets")
public class TicketController {

	@Autowired
	TicketApplication ticketApp;

	private final TicketRepositoryView repositoryView;

	@PostMapping
	public String criar(@RequestBody CriarTicketDTO ticketDTO) {
		CriarTicketCommand command = CriarTicketCommand.builder()
				.amountLuggage(ticketDTO.getAmountLuggage())
				.weightLuggage(ticketDTO.getWeightLuggage())
				.date(ticketDTO.getDate())
				.ticketPrice(ticketDTO.getTicketPrice())
				.clientId(ticketDTO.getClientId())
				.flightId(ticketDTO.getFlightId())
				.seatId(ticketDTO.getSeatId())
				.build();

		return ticketApp.criar(command);
	}

	@PostMapping(path = "/{id}/update")
	public ResponseEntity<Void> alterar(@PathVariable String id, @RequestBody AlterarTicketDTO ticketDTO) {
		AlterarTicketCommand command = AlterarTicketCommand.builder()
				.id(id)
				.amountLuggage(ticketDTO.getAmountLuggage())
				.weightLuggage(ticketDTO.getWeightLuggage())
				.date(ticketDTO.getDate())
				.ticketPrice(ticketDTO.getTicketPrice())
				.clientId(ticketDTO.getClientId())
				.flightId(ticketDTO.getFlightId())
				.seatId(ticketDTO.getSeatId())	
				.build();

		ticketApp.alterar(command);

		return ResponseEntity.ok().build();
	}

	@PostMapping(path = "/{id}/ativar")
	public ResponseEntity<Void> ativar(@PathVariable String id) {
		ticketApp.ativar(id);

		return ResponseEntity.ok().build();
	}

	@PostMapping(path = "/{id}/inativar")
	public ResponseEntity<Void> inativar(@PathVariable String id) {
		ticketApp.inativar(id);

		return ResponseEntity.ok().build();
	}

	@GetMapping
	public Page<TicketView> getAll(GetAllTicketRequest filterRequest, Pageable pageable) {
		return this.repositoryView.findAll(filterRequest.buildSpecification(), pageable);
	}

	@GetMapping(path = "/{id}")
	public TicketView getById(@PathVariable String id) {
		return Optional.ofNullable(this.repositoryView.findById(id, TicketView.class)).orElseThrow();
	}
}
