package br.com.totvs.seat.model.repository;

import java.io.Serializable;


import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Id;
import javax.persistence.Table;

import br.com.totvs.seat.model.enums.Category;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "seat")
public class SeatView implements Serializable {
	private static final long serialVersionUID = 7405120452701954531L;
	
	@Id
	private String id;
	private String seatName;
	@Enumerated(EnumType.STRING)
	private Category category;
	private boolean ativo;
		
}