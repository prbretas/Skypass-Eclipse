package br.com.totvs.flight.model;

import java.io.Serializable;

import lombok.EqualsAndHashCode;

@EqualsAndHashCode
public class FlightTicketId implements Serializable {
	private static final long serialVersionUID = -7333436257720510569L;

	private String id;

	private String flightId;
}