package br.com.totvs.flight.model.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;


public interface FlightRepositoryView
		extends JpaRepository<FlightView, String>, JpaSpecificationExecutor<FlightView> {
	<T> T findById(String id, Class<T> type);
}