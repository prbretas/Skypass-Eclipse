package br.com.totvs.client.api;

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

import br.com.totvs.client.api.dto.AlterarClientDTO;
import br.com.totvs.client.api.dto.CriarClientDTO;
import br.com.totvs.client.application.ClientApplication;
import br.com.totvs.client.application.command.AlterarClientCommand;
import br.com.totvs.client.application.command.CriarClientCommand;
import br.com.totvs.client.model.repository.ClientRepositoryView;
import br.com.totvs.client.model.repository.ClientView;
import lombok.AllArgsConstructor;

@AllArgsConstructor
@RestController
@RequestMapping(path = "/api/v1/clients")
public class ClientController {

	@Autowired
	ClientApplication clientApp;

	private final ClientRepositoryView repositoryView;

	@PostMapping
	public String criar(@RequestBody CriarClientDTO clientDTO) {
		CriarClientCommand command = CriarClientCommand.builder()
				.userName(clientDTO.getUserName())
				.name(clientDTO.getName())
				.lastName(clientDTO.getLastName())
				.numReg(clientDTO.getNumReg())
				.phone(clientDTO.getPhone())
				.email(clientDTO.getPhone())
				.password(clientDTO.getPassword())
				.birthdate(clientDTO.getBirthdate())
				.addressId(clientDTO.getAddressId())
				.build();

		return clientApp.criar(command);
	}

	@PostMapping(path = "/{id}/alterar")
	public ResponseEntity<Void> alterar(@PathVariable String id, @RequestBody AlterarClientDTO clientDTO) {
		AlterarClientCommand command = AlterarClientCommand.builder()
				.id(id).userName(clientDTO.getUserName())
				.name(clientDTO.getName())
				.lastName(clientDTO.getLastName())
				.numReg(clientDTO.getNumReg())
				.phone(clientDTO.getPhone())
				.email(clientDTO.getPhone())
				.password(clientDTO.getPassword())
				.birthdate(clientDTO.getBirthdate())
				.addressId(clientDTO.getAddressId())				
				.build();

		clientApp.alterar(command);

		return ResponseEntity.ok().build();
	}

	@PostMapping(path = "/{id}/ativar")
	public ResponseEntity<Void> ativar(@PathVariable String id) {
		clientApp.ativar(id);

		return ResponseEntity.ok().build();
	}

	@PostMapping(path = "/{id}/inativar")
	public ResponseEntity<Void> inativar(@PathVariable String id) {
		clientApp.inativar(id);

		return ResponseEntity.ok().build();
	}

	@GetMapping
	public Page<ClientView> getAll(GetAllClientRequest filterRequest, Pageable pageable) {
		return this.repositoryView.findAll(filterRequest.buildSpecification(), pageable);
	}

	@GetMapping(path = "/{id}")
	public ClientView getById(@PathVariable String id) {
		return Optional.ofNullable(this.repositoryView.findById(id, ClientView.class)).orElseThrow();
	}
}
