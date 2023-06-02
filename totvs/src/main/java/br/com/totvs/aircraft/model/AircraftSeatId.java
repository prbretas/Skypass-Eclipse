package br.com.totvs.aircraft.model;

import java.io.Serializable;

import lombok.EqualsAndHashCode;

@EqualsAndHashCode
public class AircraftSeatId implements Serializable {
	private static final long serialVersionUID = 8502451689034980798L;

	private String id;
	private String aircraftId;
}