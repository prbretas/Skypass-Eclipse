package br.com.totvs.seat.model.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;


public interface SeatRepositoryView
		extends JpaRepository<SeatView, String>, JpaSpecificationExecutor<SeatView> {
	<T> T findById(String id, Class<T> type);
}