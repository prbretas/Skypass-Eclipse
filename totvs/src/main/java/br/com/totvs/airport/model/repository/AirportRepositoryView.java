package br.com.totvs.airport.model.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;


public interface AirportRepositoryView
		extends JpaRepository<AirportView, String>, JpaSpecificationExecutor<AirportView> {
	<T> T findById(String id, Class<T> type);
}