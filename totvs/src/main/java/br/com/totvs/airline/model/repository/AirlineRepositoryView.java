package br.com.totvs.airline.model.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface AirlineRepositoryView
		extends JpaRepository<AirlineView, String>, JpaSpecificationExecutor<AirlineView> {
	<T> T findById(String id, Class<T> type);
}