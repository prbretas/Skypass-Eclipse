package br.com.totvs.client.model.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;


public interface ClientRepositoryView
		extends JpaRepository<ClientView, String>, JpaSpecificationExecutor<ClientView> {
	<T> T findById(String id, Class<T> type);
}