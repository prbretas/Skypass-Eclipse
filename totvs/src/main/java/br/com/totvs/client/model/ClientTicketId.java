package br.com.totvs.client.model;

import java.io.Serializable;

import lombok.EqualsAndHashCode;

@EqualsAndHashCode
public class ClientTicketId implements Serializable {
	private static final long serialVersionUID = 8799860162548070784L;

	private String id;

	private String clientId;
}