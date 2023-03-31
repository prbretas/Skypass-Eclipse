package br.com.totvs.flight.model.repository;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.totvs.flight.model.Flight;


@Transactional
public interface FlightRepository extends JpaRepository<Flight, String> {
	<T> T findById(String id, Class<T> type);
}