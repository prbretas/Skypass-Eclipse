package br.com.totvs.airline.model;

import java.io.Serializable;

import lombok.EqualsAndHashCode;

@EqualsAndHashCode
public class AirlineAircraftId implements Serializable {
	private static final long serialVersionUID = -6147077631332382371L;

	private String id;
	private String airlineId;
}