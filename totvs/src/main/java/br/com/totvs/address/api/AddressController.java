package br.com.totvs.address.api;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.totvs.address.api.dto.AlterarAddressDTO;
import br.com.totvs.address.api.dto.CriarAddressDTO;
import br.com.totvs.address.application.AddressApplication;
import br.com.totvs.address.application.command.AlterarAddressCommand;
import br.com.totvs.address.application.command.CriarAddressCommand;
import br.com.totvs.address.model.repository.AddressRepositoryView;
import br.com.totvs.address.model.repository.AddressView;
import lombok.AllArgsConstructor;

@AllArgsConstructor
@RestController
@RequestMapping(path = "/api/v1/addresses")
public class AddressController {

	@Autowired
	AddressApplication addressApp;

	private final AddressRepositoryView repositoryView;

	@PostMapping
	public String criar(@RequestBody CriarAddressDTO addressDTO) {
		CriarAddressCommand command = CriarAddressCommand.builder()
				.street(addressDTO.getStreet())
				.number(addressDTO.getNumber())
				.city(addressDTO.getCity())
				.state(addressDTO.getState())
				.stateCode(addressDTO.getStateCode())
				.zipCode(addressDTO.getZipCode())
				.country(addressDTO.getCountry())
				.build();

		return addressApp.criar(command);
	}

	@PostMapping(path = "/{id}/alterar")
	public ResponseEntity<Void> alterar(@PathVariable String id, @RequestBody AlterarAddressDTO addressDTO) {
		AlterarAddressCommand command = AlterarAddressCommand.builder()
				.id(id)
				.street(addressDTO.getStreet())
				.number(addressDTO.getNumber())
				.city(addressDTO.getCity())
				.state(addressDTO.getState())
				.stateCode(addressDTO.getStateCode())
				.zipCode(addressDTO.getZipCode())
				.country(addressDTO.getCountry())
				.build();

		addressApp.alterar(command);

		return ResponseEntity.ok().build();
	}

	@PostMapping(path = "/{id}/ativar")
	public ResponseEntity<Void> ativar(@PathVariable String id) {
		addressApp.ativar(id);

		return ResponseEntity.ok().build();
	}

	@PostMapping(path = "/{id}/inativar")
	public ResponseEntity<Void> inativar(@PathVariable String id) {
		addressApp.inativar(id);

		return ResponseEntity.ok().build();
	}

	@GetMapping
	public Page<AddressView> getAll(GetAllAddressRequest filterRequest, Pageable pageable) {
		return this.repositoryView.findAll(filterRequest.buildSpecification(), pageable);
	}

	@GetMapping(path = "/{id}")
	public AddressView getById(@PathVariable String id) {
		return Optional.ofNullable(this.repositoryView.findById(id, AddressView.class)).orElseThrow();
	}
}
