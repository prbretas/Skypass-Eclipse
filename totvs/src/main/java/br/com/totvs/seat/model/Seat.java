package br.com.totvs.seat.model;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;

import br.com.totvs.seat.model.enums.Category;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@Table(name = "seat")
public class Seat {
	@Id
	private String id;
	@NotBlank
	private String seatName;
	@Enumerated(EnumType.STRING)
	private Category category;
	private boolean ativo;
	

	@Builder
	private Seat(String id, String seatName, Category category) {
		this.id = id;
		this.seatName = seatName;
		this.category = category;
		this.ativo = true;
	}
	
	public void ativar() {
		this.ativo = true;
	}
	
	public void inativar() {
		this.ativo = false;
	}
}