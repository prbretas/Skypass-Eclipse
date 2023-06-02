package br.com.totvs.airline.model;

import java.io.Serializable;

import lombok.EqualsAndHashCode;

@EqualsAndHashCode
public class AirlineAddressId implements Serializable {
	private static final long serialVersionUID = 8796740785272529067L;

	private String id;
	private String airlineId;
}