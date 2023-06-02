package br.com.totvs.airline.model.repository;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.totvs.airline.model.Airline;


@Transactional
public interface AirlineRepository extends JpaRepository<Airline, String> {
	<T> T findById(String id, Class<T> type);
}