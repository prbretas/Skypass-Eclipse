package br.com.totvs.aircraft.model.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;


public interface AircraftRepositoryView
		extends JpaRepository<AircraftView, String>, JpaSpecificationExecutor<AircraftView> {
	<T> T findById(String id, Class<T> type);
}