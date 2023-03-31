package br.com.totvs.address.application;

import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

import org.springframework.stereotype.Service;

import br.com.totvs.address.application.command.AlterarAddressCommand;
import br.com.totvs.address.application.command.CriarAddressCommand;
import br.com.totvs.address.model.Address;
import br.com.totvs.address.model.repository.AddressRepository;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class AddressApplication {
	private final AddressRepository repository;

	Set<Address> clients = new HashSet<>();

	public String criar(CriarAddressCommand criarAddressCommand) {
		Address address = Address.builder().id(UUID.randomUUID().toString())
				.street(criarAddressCommand.getStreet())
				.number(criarAddressCommand.getNumber())
				.addInfo(criarAddressCommand.getAddInfo())
				.city(criarAddressCommand.getCity())
				.state(criarAddressCommand.getState())
				.stateCode(criarAddressCommand.getStateCode())
				.zipCode(criarAddressCommand.getZipCode())
				.country(criarAddressCommand.getCountry())
				.build();

		this.repository.save(address);
		return address.getId();
	}

	public void alterar(AlterarAddressCommand alterarAddressCommand) {
		this.repository.findById(alterarAddressCommand.getId()).ifPresent(address -> {
			address.setStreet(alterarAddressCommand.getStreet());
			address.setNumber(alterarAddressCommand.getNumber());
			address.setAddInfo(alterarAddressCommand.getAddInfo());
			address.setCity(alterarAddressCommand.getCity());
			address.setState(alterarAddressCommand.getState());
			address.setStateCode(alterarAddressCommand.getStateCode());
			address.setZipCode(alterarAddressCommand.getZipCode());
			address.setCountry(alterarAddressCommand.getCountry());
			
			this.repository.save(address);
		});
	}

	public void ativar(String id) {
		this.repository.findById(id).ifPresent(address -> {
			address.ativar();

			this.repository.save(address);
		});
	}

	public void inativar(String id) {
		this.repository.findById(id).ifPresent(address -> {
			address.inativar();

			this.repository.save(address);
		});
	}
}