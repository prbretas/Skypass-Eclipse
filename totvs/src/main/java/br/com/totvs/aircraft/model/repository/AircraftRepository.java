package br.com.totvs.aircraft.model.repository;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.totvs.aircraft.model.Aircraft;


@Transactional
public interface AircraftRepository extends JpaRepository<Aircraft, String> {
	<T> T findById(String id, Class<T> type);
}