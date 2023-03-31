package br.com.totvs.airport.model.repository;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.totvs.airport.model.Airport;

@Transactional
public interface AirportRepository extends JpaRepository<Airport, String> {
	<T> T findById(String id, Class<T> type);
}