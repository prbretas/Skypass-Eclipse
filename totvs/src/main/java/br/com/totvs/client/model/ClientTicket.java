package br.com.totvs.client.model;

import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor(staticName = "of")
@NoArgsConstructor
@Entity
@IdClass(ClientTicketId.class)
@Table(name = "client_ticket")
public class ClientTicket {

	@Id
	private String id;

	@Id
	@NotNull
	@Column(name = "client_id")
	private String clientId;

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ClientTicket other = (ClientTicket) obj;
		return Objects.equals(id, other.id) && Objects.equals(clientId, other.clientId);
	}

	@Override
	public int hashCode() {
		return Objects.hash(id, clientId);
	}
}