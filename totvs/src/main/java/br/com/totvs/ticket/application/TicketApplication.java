package br.com.totvs.ticket.application;

import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

import org.springframework.stereotype.Service;

import br.com.totvs.ticket.application.command.AlterarTicketCommand;
import br.com.totvs.ticket.application.command.CriarTicketCommand;
import br.com.totvs.ticket.model.Ticket;
import br.com.totvs.ticket.model.repository.TicketRepository;
import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class TicketApplication {
	private final TicketRepository repository;

	Set<Ticket> tickets = new HashSet<>();

	public String criar(CriarTicketCommand criarTicketCommand) {
		Ticket ticket = Ticket.builder().id(UUID.randomUUID().toString())
				.amountLuggage(criarTicketCommand.getAmountLuggage())
				.weightLuggage(criarTicketCommand.getWeightLuggage())
				//.date(criarTicketCommand.getDate()) ----> A DATA JA ESTA INSERIDA NO FLIGHT
				.ticketPrice(criarTicketCommand.getTicketPrice())
				//.clientId(criarTicketCommand.getClientId()) ---> ESTA NA TABELA INTERMEDIARIA CLIENTETICKET
				//.flightId(criarTicketCommand.getFlightId())--->  ESTA NA TABELA INTERMEDIARIA FLIGHTETICKET
				.seatId(criarTicketCommand.getSeatId())
				.build();

		this.repository.save(ticket);

		return ticket.getId();
	}

	public void alterar(AlterarTicketCommand alterarTicketCommand) {
		this.repository.findById(alterarTicketCommand.getId()).ifPresent(ticket -> {
			ticket.setAmountLuggage(alterarTicketCommand.getAmountLuggage());
			ticket.setWeightLuggage(alterarTicketCommand.getWeightLuggage());
			//ticket.setDate(alterarTicketCommand.getDate());
			ticket.setTicketPrice(alterarTicketCommand.getTicketPrice());
			//ticket.setClientId(alterarTicketCommand.getClientId());
			//ticket.setFlightId(alterarTicketCommand.getFlightId());
			ticket.setSeatId(alterarTicketCommand.getSeatId());			
			this.repository.save(ticket);
		});
	}

	public void ativar(String id) {
		this.repository.findById(id).ifPresent(ticket -> {
			ticket.ativar();

			this.repository.save(ticket);
		});
	}

	public void inativar(String id) {
		this.repository.findById(id).ifPresent(ticket -> {
			ticket.inativar();

			this.repository.save(ticket);
		});
	}
}