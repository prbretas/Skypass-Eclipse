package br.com.totvs.ticket.model.repository;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.totvs.ticket.model.Ticket;

@Transactional
public interface TicketRepository extends JpaRepository<Ticket, String> {
	<T> T findById(String id, Class<T> type);
}