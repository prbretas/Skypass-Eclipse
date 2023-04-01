package br.com.totvs.seat.application.command;

import br.com.totvs.seat.model.enums.Category;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class AlterarSeatCommand {
	private String id;
	private String seatName;
	private Category category;

}