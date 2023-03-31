package br.com.totvs.aircraft.model.repository;

import java.io.Serializable;

//import javax.persistence.ConstraintMode;
import javax.persistence.Entity;
//import javax.persistence.ForeignKey;
import javax.persistence.Id;
//import javax.persistence.JoinColumn;
//import javax.persistence.OneToOne;
import javax.persistence.Table;

//import org.hibernate.annotations.NotFound;
//import org.hibernate.annotations.NotFoundAction;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "aircraft")
public class AircraftView implements Serializable {

	private static final long serialVersionUID = -6603195158796035142L;
	@Id
	private String id;
	private String model;
	private String numSerie;
	private String infoSystem;
	private String latitude;
	private String longitude;
	private double cargoWeight;
	
	//EXEMPLO
	//@OneToOne
	//@NotFound(action = NotFoundAction.IGNORE)
	//@JoinColumn(name = "addressId", referencedColumnName = "id", foreignKey = @ForeignKey(value = ConstraintMode.NO_CONSTRAINT), insertable = false, updatable = false)
	//AddressView address;
	
	//ADD LIST SEATS - ONETOMANY
	//ADD AIRLINE - MANYTOONE
}