package br.com.totvs.address.model.repository;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.totvs.address.model.Address;

@Transactional
public interface AddressRepository extends JpaRepository<Address, String> {
	<T> T findById(String id, Class<T> type);
}