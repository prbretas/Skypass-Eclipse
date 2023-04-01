package br.com.totvs.seat.application;

import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

import org.springframework.stereotype.Service;

import br.com.totvs.seat.application.command.AlterarSeatCommand;
import br.com.totvs.seat.application.command.CriarSeatCommand;
import br.com.totvs.seat.model.Seat;
import br.com.totvs.seat.model.repository.SeatRepository;
import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class SeatApplication {
	private final SeatRepository repository;

	Set<Seat> seats = new HashSet<>();

	public String criar(CriarSeatCommand criarSeatCommand) {
		Seat seat = Seat.builder().id(UUID.randomUUID().toString())
				.seatName(criarSeatCommand.getSeatName())
				.category(criarSeatCommand.getCategory())
				.build();

		this.repository.save(seat);

		return seat.getId();
	}

	public void alterar(AlterarSeatCommand alterarSeatCommand) {
		this.repository.findById(alterarSeatCommand.getId()).ifPresent(seat -> {
			seat.setSeatName(alterarSeatCommand.getSeatName());
			seat.setCategory(alterarSeatCommand.getCategory());
			this.repository.save(seat);
		});
	}

	public void ativar(String id) {
		this.repository.findById(id).ifPresent(seat -> {
			seat.ativar();

			this.repository.save(seat);
		});
	}

	public void inativar(String id) {
		this.repository.findById(id).ifPresent(seat -> {
			seat.inativar();

			this.repository.save(seat);
		});
	}
}