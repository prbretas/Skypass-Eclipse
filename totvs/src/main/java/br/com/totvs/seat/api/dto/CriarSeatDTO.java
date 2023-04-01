package br.com.totvs.seat.api.dto;


import br.com.totvs.seat.model.enums.Category;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor(staticName = "of")
@NoArgsConstructor(access = AccessLevel.PRIVATE, force = true)
public class CriarSeatDTO {
	private String seatName;
	private Category category;
}