package br.com.totvs.seat.model.repository;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.totvs.seat.model.Seat;


@Transactional
public interface SeatRepository extends JpaRepository<Seat, String> {
	<T> T findById(String id, Class<T> type);
}