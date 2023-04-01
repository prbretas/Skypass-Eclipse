package br.com.totvs.ticket.model.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;


public interface TicketRepositoryView
		extends JpaRepository<TicketView, String>, JpaSpecificationExecutor<TicketView> {
	<T> T findById(String id, Class<T> type);
}