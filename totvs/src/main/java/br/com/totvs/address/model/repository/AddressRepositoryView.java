package br.com.totvs.address.model.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;


public interface AddressRepositoryView
		extends JpaRepository<AddressView, String>, JpaSpecificationExecutor<AddressView> {
	<T> T findById(String id, Class<T> type);
}