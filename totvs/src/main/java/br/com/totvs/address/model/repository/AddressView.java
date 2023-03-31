package br.com.totvs.address.model.repository;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "address")
public class AddressView implements Serializable {

	private static final long serialVersionUID = 4892628694758948762L;
	@Id
	private String id;
	private String street;
	private int number;
	private String addInfo;
	private String city;
	private String state;
	private String stateCode;
	private String zipCode;
	private String country;
}