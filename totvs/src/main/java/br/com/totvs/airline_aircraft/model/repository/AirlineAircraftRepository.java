package br.com.totvs.airline_aircraft.model.repository;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.totvs.airline_aircraft.model.AirlineAircraft;



@Transactional
public interface AirlineAircraftRepository extends JpaRepository<AirlineAircraft, String> {
	<T> T findById(String id, Class<T> type);
}