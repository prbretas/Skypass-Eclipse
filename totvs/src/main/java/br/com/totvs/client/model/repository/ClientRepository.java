package br.com.totvs.client.model.repository;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.totvs.client.model.Client;

@Transactional
public interface ClientRepository extends JpaRepository<Client, String> {
	<T> T findById(String id, Class<T> type);
}