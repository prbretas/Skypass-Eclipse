package br.com.totvs.airline_aircraft.model.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;


public interface AirlineAircraftRepositoryView
		extends JpaRepository<AirlineAircraftView, String>, JpaSpecificationExecutor<AirlineAircraftView> {
	<T> T findById(String id, Class<T> type);
}